package com.base;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utils.SnowFlakeUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xiake
 * @Description:
 * @Date: Created in 11:58 2019/10/20
 **/
@Data
public abstract class BaseEntity extends Model implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(value = "id")
    private String id = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

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

    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    private Integer delFlag;
}
