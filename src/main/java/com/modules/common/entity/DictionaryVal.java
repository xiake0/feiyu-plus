package com.modules.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: xiake
 * @Date: 2020/1/15 22:24
 * @Description:
 **/
@Data
@TableName(value = "t_dictionary_val")
@ApiModel(value = "字典值")
public class DictionaryVal extends BaseEntity {

    @ApiModelProperty(value = "编码id")
    private String dictionaryId;

    @ApiModelProperty(value = "字典内容")
    private String name;

    @ApiModelProperty(value = "值")
    private String value;
}
