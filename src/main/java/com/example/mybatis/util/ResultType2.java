package com.example.mybatis.util;

import java.io.Serializable;

public class ResultType2 implements Serializable {

    private static final long serialVersionUID = 6734833013286171951L;

    public ResultType2() {
    }

    public ResultType2(String status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public static ResultType2 success (Object result) {
        return new ResultType2("0","请求成功！",result);
    }

    public static ResultType2 success (String message, Object result) {
        return new ResultType2("0",message,result);
    }

    public static ResultType2 success (String message) {
        return new ResultType2("0",message,null);
    }

    public static ResultType2 success () {
        return new ResultType2("0","请求成功！",null);
    }

    public static ResultType2 fail(String status, String message) {
        return new ResultType2(status,message,null);
    }
    //状态码
    //状态码，0为成功，2为需要重新登录，其余均为失败
    private String status;
    //返回消息
    private String message;
    //返回数据
    private Object result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultType{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
