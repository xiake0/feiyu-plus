package com.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: xiake
 * @Date: 2019/12/21 22:57
 * @Description:
 **/
@Data
@TableName(value = "t_user_role")
@ApiModel(value = "用户角色关联")
public class UserRole extends BaseEntity {

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "角色id")
    private String roleId;
}
