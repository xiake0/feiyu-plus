package com.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.modules.sys.entity.User;

/**
 * @Author: xiake
 * @Date: 2019/12/17 22:53
 * @Description:
 **/
public interface UserService extends IService<User> {
    User getUserByUsername(String username);

    void addUser(User user);
}
