package com.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.vo.PageVo;
import com.modules.sys.entity.Role;
import com.modules.sys.mapper.RoleMapper;
import com.modules.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2019/12/22 22:02
 * @Description:
 **/
@Service
@SuppressWarnings("all")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }


    @Override
    public IPage<Role> getAll(PageVo pageVo) {
        Page<Role> rolePage=new Page<>(pageVo.getPageNumber(),pageVo.getPageSize());
        IPage<Role> iPage=roleMapper.findAll(rolePage);
        return iPage;
    }
}
