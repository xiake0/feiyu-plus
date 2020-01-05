package com.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author: xiake
 * @Date: 2020/1/5 23:19
 * @Description:
 **/
@Data
@ApiModel(value = "权限")
@TableName(value = "t_menu")
public class Menu extends BaseEntity {
}
