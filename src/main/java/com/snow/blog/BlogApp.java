package com.snow.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动项
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@SpringBootApplication
@EnableTransactionManagement // 开启事务管理
@MapperScan("com.snow.blog.mapper")
public class BlogApp {

    public static void main(String[] args) {
        SpringApplication.run(BlogApp.class, args);
    }

}
