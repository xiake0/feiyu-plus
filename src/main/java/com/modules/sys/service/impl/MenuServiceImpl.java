package com.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.constant.SysConstants;
import com.modules.sys.entity.Menu;
import com.modules.sys.mapper.MenuMapper;
import com.modules.sys.mapper.RoleMapper;
import com.modules.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private RoleMapper roleMapper;

    //将result里的List<Role>补充
    @Transactional
    @Override
    public List<Menu> getAllMenu() {
        List<Menu> result = menuMapper.getMenu();
        result.forEach(item -> {
            item.setRoles(roleMapper.getRoleByMenuId(item.getId()));
        });
        return result;
    }

    /**
     * 通过userId获取权限路径
     *
     * @param userId
     * @return
     */
    @Override
    public List<Menu> getMenuByUserId(String userId) {
        List<Menu> menus=menuMapper.getMenuByUserId(userId);

        List<Menu> menuList = new ArrayList<>();
        // 筛选一级页面
        for(Menu m : menus){
            if(SysConstants.PERMISSION_PAGE.equals(m.getType())&&SysConstants.LEVEL_ONE.equals(m.getLevel())){
                menuList.add(m);
            }
        }
        // 筛选二级页面
        List<Menu> secondMenuList = new ArrayList<>();
        for(Menu p : menus){
            if(SysConstants.PERMISSION_PAGE.equals(p.getType())&&SysConstants.LEVEL_TWO.equals(p.getLevel())){
                secondMenuList.add(p);
            }
        }

        // 匹配一级页面拥有二级页面
        for(Menu p : menuList){
            List<Menu> secondMenu = new ArrayList<>();
            for(Menu pe : secondMenuList){
                if(p.getId().equals(pe.getParentId())){
                    secondMenu.add(pe);
                }
            }
            p.setChildren(secondMenu);
        }
        return menuList;
    }


}
