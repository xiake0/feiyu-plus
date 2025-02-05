package com.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: xiake
 * @Date: 2020/1/7 23:06
 * @Description:
 **/
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 失败消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T result;
}