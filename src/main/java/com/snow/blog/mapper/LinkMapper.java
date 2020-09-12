package com.snow.blog.mapper;

import com.snow.blog.pojo.Link;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 有链Mapper
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Component
public interface LinkMapper {

    /**
     * 添加
     * @param link
     */
    void save(Link link);

    /**
     * 修改
     * @param link
     */
    void update(Link link);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Link getById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Link> getAll();

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Integer id);

}
