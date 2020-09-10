package com.snow.blog.service;

import com.snow.blog.pojo.Log;

/**
 * 接口访问日志表服务层接口
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
public interface LogService {

    /**
     * 保存日志
     *
     * @param logger
     */
    void save(Log logger);

}
