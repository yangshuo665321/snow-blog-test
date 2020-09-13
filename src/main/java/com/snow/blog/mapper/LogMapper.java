package com.snow.blog.mapper;

import com.snow.blog.pojo.Log;
import com.snow.blog.utils.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口访问日志表Mapper
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Component
public interface LogMapper {

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
    List<Log> getByPage(Page<Log> page);

    /**
     * 查询总数
     *
     * @param page
     * @return
     */
    int getCountByPage(Page<Log> page);

    /**
     * 根据id删除
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 根据id列表删除
     *
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

//    /**
//     * 查询全部
//     * @return
//     */
//    List<Log> getAll();
}
