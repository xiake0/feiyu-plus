package com.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.modules.sys.entity.Role;
import com.modules.sys.mapper.RoleMapper;
import com.modules.sys.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @Author: xiake
 * @Date: 2019/12/22 22:02
 * @Description:
 **/
@Service
@SuppressWarnings(value = "all")
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService{
}
