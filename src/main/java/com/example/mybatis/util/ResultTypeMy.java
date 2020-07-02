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
public class ResultTypeMy<T>{
    private String code;
    private String message;
    private T data;

    public ResultTypeMy() {
    }

    private ResultTypeMy(String message) {
        this.message = message;
    }

    public ResultTypeMy(T data) {
        this.code = "0";
        this.message = "success";
        this.data = data;
    }

    public ResultTypeMy(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultTypeMy(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultTypeMy success(T data) {
        return new ResultTypeMy("0", "success",data);
    }

    public static <T> ResultTypeMy success() {
        return new ResultTypeMy("0", "success");
    }

    public static ResultTypeMy error(String code, String messgae) {
        return new ResultTypeMy(code,messgae);
    }

    public static ResultTypeMy error(String messgae) {
        return new ResultTypeMy("2",messgae);
    }
}
