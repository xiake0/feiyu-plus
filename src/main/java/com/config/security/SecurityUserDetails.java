package com.config.security;

import com.alibaba.druid.util.StringUtils;
import com.modules.sys.entity.Role;
import com.modules.sys.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/1/5 23:10
 * @Description:
 **/
public class SecurityUserDetails extends User implements UserDetails {

    public SecurityUserDetails(User user) {
        if (null != user) {
            this.setId(user.getId());
            this.setUsername(user.getUsername());
            this.setPassword(user.getPassword());
            this.setStatus(user.getStatus());
            this.setEnabled(user.getEnabled());
            this.setRoles(user.getRoles());
            this.setAvatar(user.getAvatar());
        }
    }

    //将角色转换为List<GrantedAuthority>实例
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = this.getRoles();
        if(roles!=null && roles.size()>0){
            // lambda表达式
            roles.forEach(item -> {
                if(!StringUtils.isEmpty(item.getName())){
                    authorities.add(new SimpleGrantedAuthority(item.getName()));
                }
            });
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.getEnabled();
    }
}
