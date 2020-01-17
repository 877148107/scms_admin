package com.scms.admin.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: TestController
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/1/17 9:57
 * @Version: V1.0
 */
@Controller
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/hello")
    @ResponseBody
    public String test(){
        return testService.test()+" hello world";
    }

}
