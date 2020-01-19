package com.modules.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: xiake
 * @Date: 2020/1/15 22:16
 * @Description:
 **/
@Data
@TableName(value = "t_dictionary")
@ApiModel(value = "字典表")
public class Dictionary extends BaseEntity {

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "字典类型名称")
    private String text;
}
