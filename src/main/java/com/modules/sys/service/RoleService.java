package com.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.common.vo.PageVo;
import com.modules.sys.entity.Role;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2019/12/22 22:02
 * @Description:
 **/
public interface RoleService extends IService<Role> {
    List<Role> getAllRoles();

    IPage<Role> getAll(PageVo pageVo);
}
