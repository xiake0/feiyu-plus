package com.modules.sys.service.impl;

import com.AdminApplication;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.vo.DateVo;
import com.modules.sys.entity.User;
import com.modules.sys.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByPage() {
        Page<User> page = new Page<>(1, 5);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        IPage<User> iPage = userMapper.selectPage(page, queryWrapper);
        System.out.println(iPage.getPages());
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getRecords());

    }

    @Test
    public void select(){
        Page<User> page = new Page<>(1, 5);
        User user =new User();
        user.setUsername("admin");
        user.setMobile("tt");
        DateVo dateVo = new DateVo();
        dateVo.setStartDate("2019-01-21");
        IPage<User> iPage=userMapper.getByCondition(page,user,dateVo,"create_time","desc");
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getRecords());
        System.out.println(iPage.toString());
    }
}