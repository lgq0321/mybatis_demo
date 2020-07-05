package com.example.mybatis.service;

import com.example.mybatis.entity.User;
import com.example.mybatis.util.PageRequest;
import com.example.mybatis.util.ResultTypeMy;

import java.util.List;

public interface UserService{

    ResultTypeMy<List<User>> queryList();

    ResultTypeMy queryOne(Long id);

    ResultTypeMy insert(User pojo);

    ResultTypeMy insertSelective(User pojo);

    ResultTypeMy insertList(List<User> pojos);

    ResultTypeMy update(User pojo);
    /**
     * 分页查询接口
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    ResultTypeMy findPage(PageRequest pageRequest);
}
