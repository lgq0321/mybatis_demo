package com.example.mybatis.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @version 1.0
 * @description: 返回统一结果集
 * @author: liuguoquan
 * @time: 2019/12/2 10:36
 */
@Builder
@Data
@ApiModel(value = "ResultType", description = "返回结果集")
public class ResultType<T>{
    @ApiModelProperty(value = "返回状态码，成功返回 200,token失效返回 2,正常错误返回 1,接口报错返回 500")
    private int code;
    @ApiModelProperty(value = "返回数据说明")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private T data;

    public ResultType() {
    }

    private ResultType(String message) {
        this.message = message;
    }

    public ResultType(T data) {
        this.code = 200;
        this.message = "success";
        this.data = data;
    }

    public ResultType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultType(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultType success() {
        return new ResultType(200, "success");
    }

    public static ResultType error(String messgae) {
        return new ResultType(messgae);
    }
}
