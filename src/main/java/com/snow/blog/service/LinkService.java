package com.snow.blog.service;

import com.snow.blog.pojo.Link;

import java.util.List;

/**
 * 友链服务层接口
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
public interface LinkService {

    /**
     * 添加
     *
     * @param link
     * @return
     */
    void save(Link link);

    /**
     * 修改
     *
     * @param link
     * @return
     */
    void update(Link link);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Link getById(Integer id);

    /**
     * 查询所有
     *
     * @return
     */
    List<Link> getAll();

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    void deleteById(Integer id);
}
