package com.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.modules.sys.entity.Role;
import com.modules.sys.entity.User;
import com.modules.sys.mapper.RoleMapper;
import com.modules.sys.mapper.UserMapper;
import com.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2019/12/17 22:54
 * @Description:
 **/
@SuppressWarnings("all")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据用户名获取用户
     *
     * @param username
     * @return
     */
    @Override
    @Transactional
    public User getUserByUsername(String username) {
        User user = userMapper.getUserByUsername(username);
        System.out.println(user);
        List<Role> roles = roleMapper.getRolesByUserId(user.getId());
        System.out.println(roles);
        //Todo 需添加异常处理
        if (null != roles || roles.size() > 0) {
            user.setRoles(roles);
        }
        return user;
    }

}
