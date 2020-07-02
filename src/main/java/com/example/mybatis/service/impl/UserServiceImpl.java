package com.example.mybatis.service.impl;

import com.example.mybatis.dao.UserDao;
import com.example.mybatis.entity.User;
import com.example.mybatis.execption.GlobalException;
import com.example.mybatis.execption.GlobalExceptionEnum;
import com.example.mybatis.service.UserService;
import com.example.mybatis.util.PageRequest;
import com.example.mybatis.util.PageUtils;
import com.example.mybatis.util.ResultTypeMy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Autowired
    @Lazy
    private UserService userService;

    @Override
    public ResultTypeMy queryList() {
        try{
            userService.update(User.builder().id(1L).userName("测试").build());
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultTypeMy.success(userDao.queryList());
    }
    @Override
    public ResultTypeMy findPage(PageRequest pageRequest) {
        log.debug("==========");
        return ResultTypeMy.success(PageUtils.getPageResult(getPageInfo(pageRequest)));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<User> getPageInfo(PageRequest pageRequest) {
        List<User> sysMenus = new LinkedList<>();
//            int pageNum = 5;
//            int pageSize = 2;
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        sysMenus = userDao.selectPage();
        return new PageInfo<>(sysMenus);
    }

    @Override
    public ResultTypeMy queryOne(Long id) {
        return ResultTypeMy.success(userDao.queryOneById(id));
    }

    @Override
    public ResultTypeMy insert(User pojo){
        return ResultTypeMy.success(userDao.insert(pojo));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultTypeMy insertSelective(User pojo){
        int i = userDao.insertSelective(pojo);
        System.out.println("i  =" +i );
        return ResultTypeMy.success();
    }

    @Override
    public ResultTypeMy insertList(List<User> pojos){
        return ResultTypeMy.success(userDao.insertList(pojos));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultTypeMy update(User pojo){
        int update = userDao.update(pojo);
        userService.insertSelective(User.builder().userName("测试2").createTime(LocalDateTime.now()).updateTime(LocalDateTime.now()).build());
        System.out.println(update);
        if(true){
            throw new GlobalException(GlobalExceptionEnum.UNKNOW_ERROR.code);
        }
        return ResultTypeMy.success();
    }
}
