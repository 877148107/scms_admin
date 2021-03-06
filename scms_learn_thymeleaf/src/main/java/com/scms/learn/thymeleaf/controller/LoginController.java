package com.scms.learn.thymeleaf.controller;

import com.scms.learn.thymeleaf.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName: LoginController
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/1/8 21:43
 * @Version: V1.0
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if("admin".equals(userName) && "123456".equals(password)){
            session.setAttribute("userName",userName);
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名密码错误");
            return "login";
        }
    }

    @ResponseBody
    @RequestMapping("/user")
    public String hello(@RequestParam("name")String name){
        if(!name.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello world";
    }
}
