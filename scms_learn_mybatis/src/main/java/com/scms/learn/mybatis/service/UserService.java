package com.scms.learn.mybatis.service;

import com.scms.learn.mybatis.mapper.UserMapper;
import com.scms.learn.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @InterfaceName: UserService
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: Wangmy
 * @Email: wangmingyong@boco.com.cn
 * @CreateDate: 2020/1/19 17:15
 * @Version: V1.0
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findUserById(int id){
        User user = userMapper.findUserById(id);
        System.out.println("USER:"+user);
        return user;
    }
}
