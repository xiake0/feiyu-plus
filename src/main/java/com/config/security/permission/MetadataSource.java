package com.config.security.permission;

import com.modules.sys.entity.Menu;
import com.modules.sys.entity.Role;
import com.modules.sys.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 动态配置权限
 *
 * @Author: xiake
 * @Date: 2020/1/5 23:46
 * @Description:
 **/
@Component
public class MetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;

    AntPathMatcher antPath = new AntPathMatcher();

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        System.out.println(requestUrl);
        List<Menu> menus = menuService.getAllMenu();
        Set<String> values = new HashSet<>();
        for (Menu menu : menus) {
            //url匹配
            System.out.println(antPath.match(menu.getPath(), requestUrl) + " + " + menu.getPath() +" + ");
            if (antPath.match(menu.getUrl(), requestUrl) && menu.getRoles().size() > 0) {
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                for (int i = 0; i < size; i++) {
                    values.add(roles.get(i).getName());
                    System.out.println(roles.get(i).getName());
                }
            }
        }
        if(values.size()!=0){
            return SecurityConfig.createList(values.toArray(new String[]{}));
        }
        //未匹配成功的请求默认登录后访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
