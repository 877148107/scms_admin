package com.scms.learn.mybatis.mapper;

import com.scms.learn.mybatis.model.User;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserMapper
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/1/19 17:16
 * @Version: V1.0
 */
@Repository
public interface UserMapper {

    User findUserById(int id);
}
