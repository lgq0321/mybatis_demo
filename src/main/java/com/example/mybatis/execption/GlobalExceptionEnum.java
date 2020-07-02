package com.example.mybatis.execption;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @description:
 * @author: liuguoquan
 * @time: 2020/1/13 15:25
 */
@AllArgsConstructor
@NoArgsConstructor
public enum GlobalExceptionEnum {
    /**
     *
     */
    UNKNOW_ERROR("E000001", "未知错误"),
    /**
     *
     */
    NULL_EXCEPTION("E000002", "空指针异常：NullPointerException"),


    ;

    public String code;

    public String msg;

}
