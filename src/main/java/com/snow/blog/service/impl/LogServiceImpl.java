package com.snow.blog.service.impl;

import com.snow.blog.mapper.LogMapper;
import com.snow.blog.pojo.Log;
import com.snow.blog.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 接口访问日志服务实现类
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Service
@Slf4j
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 保存日志
     *
     * @param logger
     */
    @Override
    public void save(Log logger) {
        logMapper.save(logger);
    }
}
