package com.scms.learn.mybatis.controller;

import com.scms.learn.mybatis.model.User;
import com.scms.learn.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: UserController
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/1/19 17:24
 * @Version: V1.0
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user/{id}")
    public User findUserById(@PathVariable Integer id){
        return userService.findUserById(id);
    }
}
