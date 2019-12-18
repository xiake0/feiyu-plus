package com.base;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: simdy
 * @Description:
 * @Date: Created in 11:58 2019/10/20
 * @Modified By:
 **/
@Data
public class BaseEntity implements Serializable {

    @TableField(value = "id")
    private String id;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "del_flag")
    private Integer delFlag;
}
