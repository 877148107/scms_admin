package com.scms.admin.test.impl;

import com.scms.admin.test.TestService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TestServiceImpl
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/1/17 9:58
 * @Version: V1.0
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "Springboot";
    }
}
