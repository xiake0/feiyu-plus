package com.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: xiake
 * @Date: 2020/1/5 23:29
 * @Description:
 **/
@Data
@TableName(value = "t_role_menu")
@ApiModel(value = "角色权限关联")
public class RoleMenu extends BaseEntity {

    @ApiModelProperty(value = "权限id")
    private String menuId;

    @ApiModelProperty(value = "角色id")
    private String roleId;
}
