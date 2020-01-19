package com.modules.sys.service.impl;

import com.AdminApplication;
import com.modules.sys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void insert() throws Exception {
        userService.insert();
    }

    @Test
    public void delete() throws Exception {
        userService.delete();
    }

}