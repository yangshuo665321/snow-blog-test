package com.snow.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动项
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.snow.blog.mapper")
public class BlogApp {

    public static void main(String[] args) {
        SpringApplication.run(BlogApp.class, args);
    }

}
