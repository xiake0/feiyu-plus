package com.modules.sys.entity;

import com.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: xiake
 * @Date: 2019/12/21 22:57
 * @Description:
 **/
@Data
public class UserRole extends BaseEntity {

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "角色id")
    private String RoleId;
}
