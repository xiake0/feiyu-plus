package com.modules.video.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.base.BaseEntity;
import lombok.Data;

/**
 * @Author: xiake
 * @Date: 2020/4/7 15:12
 * @Description:
 **/
@Data
@TableName("t_player")
//视频
public class Player extends BaseEntity {

    //视频名称
    private String title;

    //观看数量
    private Integer view;

    //地址
    private String url;

    //封面
    private String pic;

    //相关资料
    private String material;

    //视频介绍
    private String introduction;

    //视频作者
    private String ownerId;
}
