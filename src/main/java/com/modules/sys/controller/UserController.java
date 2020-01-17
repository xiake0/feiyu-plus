package com.modules.sys.controller;

import com.common.utils.ResultUtil;
import com.common.utils.UserDetailsUtils;
import com.common.vo.DateVo;
import com.common.vo.PageVo;
import com.common.vo.Result;
import com.modules.sys.entity.User;
import com.modules.sys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2019/12/17 22:57
 * @Description:
 **/
@RestController
@RequestMapping("/sys/user")
@Api(value = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/currentUser")
    @ApiOperation(value = "获取当前登录用户")
    public Result<User> currentUser() {
        return new ResultUtil<User>().setData(UserDetailsUtils.getCurrentUserDetails());
    }

    @RequestMapping("/login_p")
    public Result<Object> loginPage() {
        return new ResultUtil<Object>().setErrorMsg(302, "登录过期，请重新登录！");
    }

    @GetMapping("/getByCondition")
    @ApiOperation(value = "分页获取用户")
    public Result<List<User>> getByCondition(@RequestBody User user,
                                             @RequestBody DateVo dateVo,
                                             @RequestBody PageVo pageVo) {

        return  null;
    }

    @PostMapping("/add")
    @ApiOperation(value = "add")
    public void add(){
       userService.insertUser();
    }


}
