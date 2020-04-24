package com.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.modules.sys.entity.RoleMenu;
import com.modules.sys.mapper.RoleMenuMapper;
import com.modules.sys.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/4/21 20:06
 * @Description:
 **/
@Service
@SuppressWarnings("all")
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<RoleMenu> findByRoleId(String roleId) {
        return roleMenuMapper.findByRoleId(roleId);
    }
}
