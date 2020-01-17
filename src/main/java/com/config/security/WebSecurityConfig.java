package com.config.security;

import com.common.utils.ResultUtil;
import com.common.utils.UserDetailsUtils;
import com.common.vo.Result;
import com.config.security.permission.AuthenticationAccessDeniedHandler;
import com.config.security.permission.MetadataSource;
import com.config.security.permission.UrlAccessDecisionManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ctrl+o重写父类
 *
 * @Author: xiake
 * @Date: 2020/1/7 22:53
 * @Description:
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private MetadataSource metadataSource;

    @Autowired
    private UrlAccessDecisionManager urlAccessDecisionManager;

    @Autowired
    private AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/sys/user/login_p",
                "index.html",
                "static/**",
                "/swagger/**",
                "/**/v2/api-docs",
                "/swagger-ui.html",
                "/swagger-resources/**",
                "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {

            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(metadataSource);
                o.setAccessDecisionManager(urlAccessDecisionManager);
                return o;
            }
        })
                .and()
                .formLogin().loginPage("/sys/user/login_p").loginProcessingUrl("/sys/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        Result<Object> result = null;
                        if (e instanceof BadCredentialsException || e instanceof UsernameNotFoundException) {
                            result = new ResultUtil<Object>().setErrorMsg(401, "账号或密码输入错误");
                        } else if (e instanceof LockedException) {
                            result = new ResultUtil<Object>().setErrorMsg(401, "账号被锁定，请联系管理员");
                        } else if (e instanceof CredentialsExpiredException) {
                            result = new ResultUtil<Object>().setErrorMsg(401, "密码过期");
                        } else if (e instanceof AccountExpiredException) {
                            result = new ResultUtil<Object>().setErrorMsg(401, "账号过期");
                        } else if (e instanceof DisabledException) {
                            result = new ResultUtil<Object>().setErrorMsg(401, "账号被禁用");
                        } else result = new ResultUtil<Object>().setErrorMsg(401, "登录失败");
                        httpServletResponse.setStatus(401);
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write(om.writeValueAsString(result));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        Result<Object> result = new ResultUtil<Object>().setData(UserDetailsUtils.getCurrentUserDetails());
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write(om.writeValueAsString(result));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout().permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
    }
}
