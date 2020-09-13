package com.snow.blog.service.impl;

import com.snow.blog.mapper.LogMapper;
import com.snow.blog.pojo.Log;
import com.snow.blog.service.LogService;
import com.snow.blog.utils.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @Override
    public Page<Log> getByPage(Page<Log> page) {
        // 查询数据
        List<Log> logList = logMapper.getByPage(page);
        page.setList(logList);
        // 查询总数
        int totalCount = logMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        return page;
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public void deleteById(Integer id) {
        logMapper.deleteById(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public void deleteByIds(List<Integer> ids) {
        logMapper.deleteByIds(ids);
    }
}
