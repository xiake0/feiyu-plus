package com.modules.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.common.utils.ResultUtil;
import com.common.utils.UserDetailsUtils;
import com.common.vo.DateVo;
import com.common.vo.PageVo;
import com.common.vo.Result;
import com.modules.sys.entity.User;
import com.modules.sys.service.UserRoleService;
import com.modules.sys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private UserRoleService userRoleService;

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
    public Result<IPage<User>> getByCondition(@ModelAttribute User user,
                                              @ModelAttribute DateVo dateVo,
                                              @ModelAttribute PageVo pageVo) {
        IPage<User> iPage = userService.getByCondition(pageVo, user, dateVo);
        return new ResultUtil<IPage<User>>().setData(iPage);
    }


    @PostMapping("/add")
//    @ApiOperation(value = "添加用户")
    public Result<Object> addUser(@ModelAttribute User user,
                                  @RequestParam(required = false) String[] roleIds) {

        if(userService.getCounts(user.getUsername())>0){
         return new ResultUtil<Object>().setErrorMsg("已存在该用户");
        }
        userService.addUser(user);
        userRoleService.addUserRole(user.getId(),roleIds);
        return new ResultUtil<Object>().setSuccessMsg("添加成功");
    }

    @PostMapping(value = "/enable/{userId}")
    @ApiOperation(value = "后台启用用户")
    public Result<Object> enable(@ApiParam("用户唯一id标识") @PathVariable String userId){

        User user = userService.getUserByUserId(userId);
        if(user==null){
            return new ResultUtil<Object>().setErrorMsg("通过userId获取用户失败");
        }
        userService.enable(user);
        return new ResultUtil<Object>().setSuccessMsg("操作成功");
    }


    @PostMapping(value = "/disable/{userId}")
    @ApiOperation(value = "后台禁用用户")
    public Result<Object> disable(@ApiParam("用户唯一id标识") @PathVariable String userId){

        User user = userService.getUserByUserId(userId);
        if(user==null){
            return new ResultUtil<Object>().setErrorMsg("通过userId获取用户失败");
        }
        userService.disable(user);
        return new ResultUtil<Object>().setSuccessMsg("操作成功");
    }

    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "批量通过ids删除")
    public Result<Object> delAllByIds(@PathVariable String[] ids){
        for(String id:ids){
            User u = userService.getUserByUserId(id);
            userService.delete(id);
            //删除该用户角色
            userRoleService.deleteByUserId(u.getId());
        }
        return new ResultUtil<Object>().setSuccessMsg("批量通过id删除数据成功");
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public Result<Object> edit(@ModelAttribute User u,
                               @RequestParam(required = false) String[] roleIds){

        User old = userService.getUserByUserId(u.getId());

        //判断新用户名是否存在
        if(!old.getUsername().equals(u.getUsername())){
            if(userService.findByUsername(u.getUsername())!=null){
                return new ResultUtil<Object>().setErrorMsg("该用户名已存在");
            }
        }
        //删除该用户角色
        userRoleService.deleteByUserId(u.getId());
        userService.updateUser(u);
        userRoleService.addUserRole(u.getId(),roleIds);
        return new ResultUtil<Object>().setSuccessMsg("修改成功");
    }
}
