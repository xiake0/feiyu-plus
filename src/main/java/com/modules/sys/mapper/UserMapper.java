package com.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.vo.DateVo;
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
    User getUserByUsername(@Param("username") String username);

    IPage<User> getByCondition(Page<User> page, @Param("u") User user,
                               @Param("d") DateVo dateVo, @Param("s") String sort,
                               @Param("o") String order);

    @Select("select count(*) from t_user where username = #{username}")
    Integer getCounts(String username);
}
