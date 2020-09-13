package com.snow.blog.service;

import com.snow.blog.pojo.Log;
import com.snow.blog.utils.Page;

import java.util.List;

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

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    Page<Log> getByPage(Page<Log> page);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    void deleteById(Integer id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    void deleteByIds(List<Integer> ids);
}
