package com.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.modules.sys.entity.Menu;
import com.modules.sys.mapper.MenuMapper;
import com.modules.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/1/6 22:47
 * @Description:
 **/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    //将result里的List<Role>补充
    @Transactional
    @Override
    public List<Menu> getAllMenu() {
        List<Menu> result=menuMapper.getMenu();
        result.forEach(item->{
            item.setRoles(menuMapper.getRoleByMenuId(item.getId()));
        });
        return result;
    }
}
