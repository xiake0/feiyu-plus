package com.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: xiake
 * @Date: 2019/12/17 22:13
 * @Description:
 **/
@Data
@TableName(value = "t_user")
@ApiModel(value = "用户")
public class User extends BaseEntity {


    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("登录密码")
    private String password;

    @ApiModelProperty("用户状态")
    private Boolean status;

    @ApiModelProperty("可用 0")
    private Boolean enabled;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("评论")
    private String remark;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty(value = "0女 1男 2保密")
    private Integer gender;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户拥有的角色")
    @TableField(exist = false)
    private List<Role> roles;

    @ApiModelProperty(value = "用户拥有的权限")
    @TableField(exist = false)
    private List<Menu> permissions;
}
