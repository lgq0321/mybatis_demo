package com.example.mybatis.controller;

import com.example.mybatis.service.UserService;
import com.example.mybatis.util.PageRequest;
import com.example.mybatis.util.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuguoquan
 * @version 1.0
 * @description
 * @date 2020/7/1 21:42
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryList")
    public ResultType users(){
        return userService.queryList();
    }
    @RequestMapping("/queryOne")
    public ResultType user(){
        return userService.queryOne(2L);
    }

    @RequestMapping(value="/findPage")
    public Object findPage() {
        PageRequest pageQuery = new PageRequest();
        return userService.findPage(pageQuery);
    }
}
