package com.config.security;

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
            this.setUsername(user.getUsername());
            this.setPassword(user.getPassword());
            this.setStatus(user.getStatus());
            this.setEnabled(user.getEnabled());
            this.setRoles(user.getRoles());
        }
    }

    //将角色转换为List<GrantedAuthority>实例
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : this.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
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
