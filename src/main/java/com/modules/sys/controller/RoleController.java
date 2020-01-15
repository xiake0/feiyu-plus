package com.modules.sys.controller;

import com.common.utils.ResultUtil;
import com.modules.sys.entity.Menu;
import com.modules.sys.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/1/14 0:07
 * @Description:
 **/
@RestController
@RequestMapping("/sys/role")
@Api(value = "角色管理")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取角色权限")
    @GetMapping("/getRoleMenuList")
    public ResultUtil<List<Menu>> getRoleMenuList() {
        //TODO
        return null;
    }
}
