package com.example.mybatis.controller;

import com.example.mybatis.entity.User;
import com.example.mybatis.service.UserService;
import com.example.mybatis.util.PageRequest;
import com.example.mybatis.util.ResultTypeMy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuguoquan
 * @version 1.0
 * @description
 * @date 2020/7/1 21:42
 */
@Api(value = "机构报表", tags = "机构报表")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "分渠道到访面板", notes = "分渠道到访面板")
    @GetMapping("/queryList")
    public ResultTypeMy<List<User>> users(){
        return userService.queryList();
    }

    @RequestMapping("/queryOne")
    public ResultTypeMy user(){
        return userService.queryOne(2L);
    }

    @RequestMapping(value="/findPage")
    public Object findPage() {
        PageRequest pageQuery = new PageRequest();
        return userService.findPage(pageQuery);
    }
}
