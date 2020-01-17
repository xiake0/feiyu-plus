package com.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableName;
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
@TableName(value = "t_menu_role")
@ApiModel(value = "角色权限关联")
public class MenuRole extends BaseEntity {

    @ApiModelProperty(value = "权限id")
    private String menuId;

    @ApiModelProperty(value = "角色id")
    private String roleId;
}
