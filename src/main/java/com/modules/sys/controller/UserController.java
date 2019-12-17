package com.modules.sys.controller;

import com.modules.sys.entity.User;
import com.modules.sys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiake
 * @Date: 2019/12/17 22:57
 * @Description:
 **/
@RestController
@RequestMapping("/sys/user")
@Api(value = "管理员管理")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/get")
    @ResponseBody
    @ApiOperation(value = "分页获取")
    public User getUser(String username){
        return userService.getByUsername(username);
    }
}
