package com.base;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xiake
 * @Description:
 * @Date: Created in 11:58 2019/10/20
 **/
@Data
public class BaseEntity implements Serializable {

    @TableField(value = "id")
    private String id;

    @JsonIgnore
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @JsonIgnore
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Date createBy;

    @JsonIgnore
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    @JsonIgnore
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private Date updateBy;

    @TableField(value = "del_flag")
    private Integer delFlag;
}
