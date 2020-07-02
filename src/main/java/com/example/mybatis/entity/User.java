package com.example.mybatis.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liuguoquan
 * @version 1.0
 * @description
 * @date 2020/7/1 21:04
 */
@Builder
@Data
public class User implements Serializable {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 真实姓名
     */
    private String realName;
}
