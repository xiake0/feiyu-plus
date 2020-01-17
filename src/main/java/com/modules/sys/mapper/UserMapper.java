package com.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.modules.sys.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: xiake
 * @Date: 2019/12/17 22:52
 * @Description:
 **/
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user where username = #{username} limit 1;")
    User getUserByUsername(@Param("username") String username);

    @Insert("insert into t_user(username,password) values (#{username},#{password}) ")
    void insertUser(@Param("username") String username,@Param("password") String password);
}
