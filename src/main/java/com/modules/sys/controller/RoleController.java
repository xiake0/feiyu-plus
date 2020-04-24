package com.modules.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.common.utils.ResultUtil;
import com.common.vo.PageVo;
import com.common.vo.Result;
import com.modules.sys.entity.Role;
import com.modules.sys.entity.RoleMenu;
import com.modules.sys.service.RoleMenuService;
import com.modules.sys.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @Autowired
    private RoleMenuService roleMenuService;

    @ApiOperation(value = "获取角色权限")
    @GetMapping("/getAllRoles")
    public Result<List<Role>> getAllRoles() {

        return new ResultUtil<List<Role>>().setData(roleService.getAllRoles());
    }


    @GetMapping(value = "/getAllByPage")
    @ApiOperation(value = "分页获取角色")
    public Result<IPage<Role>> getRoleByPage(@ModelAttribute PageVo page){

        IPage<Role> iPage=roleService.getAll(page);
        List<Role> roles=iPage.getRecords();
        for(Role role : roles){
            // 角色拥有权限
            List<RoleMenu> permissions = roleMenuService.findByRoleId(role.getId());
            role.setPermissions(permissions);
        }
        return new ResultUtil<IPage<Role>>().setData(iPage);
    }
}
