package com.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
        System.out.println(user.getId());
        List<Role> roles = roleMapper.getRolesByUserId(user.getId());
        System.out.println(roles);
        //TODO 需添加异常处理
        if (null != roles || roles.size() > 0) {
            user.setRoles(roles);
        }
        return user;
    }

    @Override
    public void insertUser() {
        userMapper.insertUser("min","dd");
    }

    @Override
    public void insert(){
        User user=new User();
        user.setUsername("min");
        user.setPassword("s");
        userMapper.insert(user);
    }

    @Override
    public void delete(){
        userMapper.deleteById("231344695261794304");
    }

}
