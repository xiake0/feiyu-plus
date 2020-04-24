package com.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.modules.sys.entity.RoleMenu;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/4/21 20:06
 * @Description:
 **/
public interface RoleMenuService extends IService<RoleMenu> {

    /**
     * 通过roleId获取
     * @param roleId
     * @return
     */
    List<RoleMenu> findByRoleId(String roleId);
}
