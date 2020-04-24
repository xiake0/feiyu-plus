package com.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.modules.sys.entity.RoleMenu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/4/21 20:07
 * @Description:
 **/
public interface RoleMenuMapper extends BaseMapper<RoleMenu>{

    @Select("select * from t_role_menu where role_id = #{roleId}")
    List<RoleMenu> findByRoleId(String roleId);
}
