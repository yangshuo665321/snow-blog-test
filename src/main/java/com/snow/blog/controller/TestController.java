package com.snow.blog.controller;

import com.snow.blog.exception.BlogException;
import com.snow.blog.utils.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制层
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 测试异常
     *
     * @return
     */
    @RequestMapping(value = "/testException/{id}", method = RequestMethod.GET)
    public Result<Object> testException(@PathVariable Integer id) {

        if (id == 1) {
            return new Result<>();
        } else {
            throw new BlogException("发生了异常！");
        }
    }

}
