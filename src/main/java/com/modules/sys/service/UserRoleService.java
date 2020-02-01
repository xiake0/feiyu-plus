package com.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.modules.sys.entity.UserRole;

/**
 * @Author: xiake
 * @Date: 2020/1/31 14:48
 * @Description:
 **/
public interface UserRoleService extends IService<UserRole> {

    void addUserRole(String userId,String[] roles);
}
