package com.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.common.constant.SysConstants;
import com.common.utils.UserDetailsUtils;
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
public class MetaHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasGetter(SysConstants.CREATE_TIME)) {
            this.setFieldValByName(SysConstants.CREATE_TIME, new Date(), metaObject);
        }
//        if (metaObject.hasGetter(SysConstants.CREATE_BY)) {
//            this.setFieldValByName(SysConstants.CREATE_BY, UserDetailsUtils.getCurrentUserDetails().getUsername(), metaObject);
//        }
        if (metaObject.hasGetter(SysConstants.DEL_FLAG)) {
            System.out.println(SysConstants.STATUS_NORMAL);
            this.setFieldValByName(SysConstants.DEL_FLAG, SysConstants.STATUS_NORMAL, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (null != this.getFieldValByName(SysConstants.UPDATE_TIME, metaObject)) {
            this.setFieldValByName(SysConstants.UPDATE_TIME, new Date(), metaObject);
        }
        if (null != this.getFieldValByName(SysConstants.UPDATE_BY, metaObject)) {
            this.setFieldValByName(SysConstants.UPDATE_BY, UserDetailsUtils.getCurrentUserDetails().getUsername(), metaObject);
        }
    }
}
