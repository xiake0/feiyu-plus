package com.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.modules.sys.entity.UserRole;
import com.modules.sys.mapper.UserRoleMapper;
import com.modules.sys.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xiake
 * @Date: 2020/1/31 14:49
 * @Description:
 **/
@Service
@SuppressWarnings("all")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 添加用户角色关联数据
     *
     * @param userId
     * @param roleIds
     */
    @Override
    public void addUserRole(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoleMapper.insert(userRole);
        }
    }
}
