package com.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: xiake
 * @Date: 2019/12/20 23:02
 * @Description:
 **/
@Data
@ApiModel(value = "角色表")
@TableName(value = "t_role")
public class Role extends BaseEntity {

    @ApiModelProperty(value = "角色名")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "")
    private String s;
}
