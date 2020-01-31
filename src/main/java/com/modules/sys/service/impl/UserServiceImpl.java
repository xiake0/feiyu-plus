package com.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.vo.DateVo;
import com.common.vo.PageVo;
import com.modules.sys.entity.Role;
import com.modules.sys.entity.User;
import com.modules.sys.mapper.RoleMapper;
import com.modules.sys.mapper.UserMapper;
import com.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private BCryptPasswordEncoder encoder;

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

    /**
     * 根据条件分页查询用户
     *
     * @param page
     * @param user
     * @param dateVo
     * @param order
     * @return
     */
    @Override
    public IPage<User> getByCondition(PageVo pageVo, User user, DateVo dateVo) {
        Page<User> userPage = new Page<>(pageVo.getPageNumber(), pageVo.getPageSize());
        IPage<User> iPage = userMapper.getByCondition(userPage, user, dateVo, pageVo.getSort(), pageVo.getOrder());
        return iPage;
    }

    /**
     * 添加新用户
     *
     * @param user
     */
    @Override
    public void addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userMapper.insert(user);
    }

}
