package com.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.common.vo.DateVo;
import com.common.vo.PageVo;
import com.modules.sys.entity.User;

/**
 * @Author: xiake
 * @Date: 2019/12/17 22:53
 * @Description:
 **/
public interface UserService extends IService<User> {
    User getUserByUsername(String username);

    IPage<User> getByCondition(PageVo pageVo, User user, DateVo dateVo);

    void addUser(User user);

    Integer getCounts(String username);

    User getUserByUserId(String uid);

    void updateUser(User user);

    void enable(User user);

    void disable(User user);

    void delete(String id);

    User findByUsername(String username);
}
