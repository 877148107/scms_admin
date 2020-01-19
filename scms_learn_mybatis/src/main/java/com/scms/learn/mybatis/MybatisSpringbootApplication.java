package com.scms.learn.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: MybatisSpringbootAppliction
 * =================================================
 * @Description: TODO
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/1/19 17:28
 * @Version: V1.0
 */
@MapperScan("com.scms.learn.mybatis.mapper")
@SpringBootApplication
public class MybatisSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringbootApplication.class,args);
    }
}
