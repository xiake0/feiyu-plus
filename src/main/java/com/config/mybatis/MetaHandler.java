package com.config.mybatis;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.common.constant.SysConstants;
import com.utils.SnowFlakeUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ctrl+alt+L格式化代码
 * 自动字段填充的组件配置
 *
 * @Author: xiake
 * @Date: 2019/12/18 23:41
 * @Description:
 **/
@Component
public class MetaHandler extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("id", String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId()), metaObject);
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("del_flag", SysConstants.STATUS_NORMAL, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
