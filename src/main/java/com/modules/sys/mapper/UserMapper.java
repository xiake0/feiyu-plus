package com.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.modules.sys.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: xiake
 * @Date: 2019/12/17 22:52
 * @Description:
 **/
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user where username = #{username} limit 1;")
    User getByUsername(@Param("username") String username);
}
