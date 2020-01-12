package com.modules.sys.controller;

import com.common.utils.ResultUtil;
import com.common.utils.UserDetailsUtils;
import com.common.vo.Result;
import com.modules.sys.entity.Menu;
import com.modules.sys.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/1/11 16:01
 * @Description:
 **/
@RestController
@Api(value = "权限管理")
@RequestMapping("/sys/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/getMenuList")
    @ApiOperation(value = "获取权限路径")
    public Result<List<Menu>> getMenuList(){
        List<Menu> menus=new ArrayList<>();
        return new ResultUtil<List<Menu>>().setData(menuService.getMenuByUserId(UserDetailsUtils.getCurrentUserDetails().getId()));
    }

}
