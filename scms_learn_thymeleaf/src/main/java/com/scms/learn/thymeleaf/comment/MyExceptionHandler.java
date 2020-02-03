package com.scms.learn.thymeleaf.comment;

import com.scms.learn.thymeleaf.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MyExceptionHandler
 * =================================================
 * @Description: 异常处理器
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/1/27 22:51
 * @Version: V1.0
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
     public String handlerException(Exception e){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","not exist");
        map.put("error",e.getMessage());
        return "forward:/error";
     }
}
