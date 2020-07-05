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

    public static <T> ResultTypeMy<T> success(T data) {
        return new ResultTypeMy<T>("0", "success",data);
    }

    public static <T> ResultTypeMy<T> success() {
        return new ResultTypeMy<T>("0", "success");
    }

    public static <T> ResultTypeMy <T> error(String code, String messgae) {
        return new ResultTypeMy<T>(code,messgae);
    }

    public static <T> ResultTypeMy<T> error(String messgae) {
        return new ResultTypeMy<T>("2",messgae);
    }
}
