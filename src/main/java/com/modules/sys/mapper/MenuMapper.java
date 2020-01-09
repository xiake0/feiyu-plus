package com.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.modules.sys.entity.Menu;
import com.modules.sys.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/1/6 22:45
 * @Description:
 **/
public interface MenuMapper extends BaseMapper<Menu> {

    @Select("select t.id,t.name,t.level,t.title,t.path,t.del_flag,t.in_active," +
            "t.icon,t.sort_order,t.parent_id,t.url,t.button_type,t.type,t.create_time," +
            "t.create_by,t.update_by,t.update_time from t_menu t")
    List<Menu> getMenu();

    @Select("select * from t_role,t_role_menu where t_role.id = t_role_menu.role_id and " +
            "menu_id = #{menuId}")
    List<Role> getRoleByMenuId(String menuId);
}
