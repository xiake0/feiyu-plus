package com.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.modules.sys.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/1/6 22:45
 * @Description:
 **/
public interface MenuMapper extends BaseMapper<Menu> {

    @Select("select t.id,t.name,t.level,t.title,t.path,t.del_flag,t.is_active,t.component," +
            "t.icon,t.sort_order,t.parent_id,t.url,t.button_type,t.type,t.create_time," +
            "t.create_by,t.update_by,t.update_time from t_menu t")
    List<Menu> getMenu();

    //TODO 考虑is
    @Select("SELECT m.id,m.name,m.level,m.title,m.path,m.del_flag,m.is_active,m.icon,m.sort_order,m.parent_id,m.url,m.component," +
            "  m.button_type,m.type,m.create_time,m.create_by,m.update_by,m.update_time FROM t_menu m,t_role_menu rm," +
            "  t_role r,t_user_role ur,t_user u WHERE m.id=rm.menu_id AND rm.role_id=r.id AND r.id=ur.role_id" +
            "  AND ur.user_id=u.id AND u.id=#{userId} and m.path!=''")
    List<Menu> getMenuByUserId(@Param(value = "userId") String userId);
}
