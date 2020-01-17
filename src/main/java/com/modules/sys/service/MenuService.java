package com.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.modules.sys.entity.Menu;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/1/6 22:46
 * @Description:
 **/
public interface MenuService extends IService<Menu> {

    List<Menu> getAllMenu();

    List<Menu> getMenuByUserId(String userId);
}
