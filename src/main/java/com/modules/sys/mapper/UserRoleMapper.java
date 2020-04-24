package com.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.modules.sys.entity.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: xiake
 * @Date: 2020/1/31 14:48
 * @Description:
 **/
public interface UserRoleMapper extends BaseMapper<UserRole> {

    @Delete("delete from t_user_role where user_id=#{userId}")
    void deleteByUserId(@Param("userId")String userId);
}
