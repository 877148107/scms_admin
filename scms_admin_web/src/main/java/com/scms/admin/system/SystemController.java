package com.scms.admin.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: SystemController
 * =================================================
 * @Description: 系统控制层
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/1/17 12:30
 * @Version: V1.0
 */
@Controller
public class SystemController {

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password){
        if("admin".equals(username) && "123456".equals(password)){
            return "登录成功";
        }else{
            return "用户名密码错误！";
        }
    }
}
