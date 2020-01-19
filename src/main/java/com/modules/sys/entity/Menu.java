package com.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.BaseEntity;
import com.common.constant.SysConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2020/1/5 23:19
 * @Description:
 **/
@Data
@ApiModel(value = "权限菜单")
@TableName(value = "t_menu")
public class Menu extends BaseEntity {

    @ApiModelProperty("菜单/权限名称")
    private String name;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "菜单标题")
    private String title;

    @ApiModelProperty("是否启用 0.禁用 1.启用")
    private Integer isActive = SysConstants.STATUS_NORMAL;

    @ApiModelProperty(value = "页面路径/资源链接url")
    private String path;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "按钮权限类型")
    private Integer buttonType;

    @ApiModelProperty("菜单类型 0.菜单 1.按钮")
    private Integer type;

    @ApiModelProperty(value = "排序值")
    private Integer sortOrder;

    @ApiModelProperty(value = "前端组件")
    private String component;

    @ApiModelProperty("父主键")
    private String parentId;

    @ApiModelProperty(value = "网页链接")
    private String url;

    @ApiModelProperty(value = "子菜单/权限")
    @TableField(exist = false)
    private List<Menu> children;

    @ApiModelProperty("角色列表")
    @TableField(exist = false)
    private List<Role> roles;
}
