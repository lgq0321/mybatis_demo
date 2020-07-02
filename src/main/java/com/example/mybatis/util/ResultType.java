package com.example.mybatis.util;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @version 1.0
 * @description: 返回统一结果集
 * @author: liuguoquan
 * @time: 2019/12/2 10:36
 */
@Data
@Builder
@ToString
public class ResultType<T>{
    private String code;
    private String message;
    private T data;

    public ResultType() {
    }

    private ResultType(String message) {
        this.message = message;
    }

    public ResultType(T data) {
        this.code = "0";
        this.message = "success";
        this.data = data;
    }

    public ResultType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultType(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultType success(T data) {
        return new ResultType("0", "success",data);
    }

    public static ResultType success() {
        return new ResultType("0", "success");
    }

    public static ResultType error(String code, String messgae) {
        return new ResultType(code,messgae);
    }

    public static ResultType error(String messgae) {
        return new ResultType("2",messgae);
    }
}
