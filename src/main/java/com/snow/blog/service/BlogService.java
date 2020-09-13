package com.snow.blog.service;

import com.snow.blog.pojo.Blog;
import com.snow.blog.utils.Page;
import com.snow.blog.vo.BlogVo;

/**
 * 博客表服务层接口
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
public interface BlogService {

    /**
     * 保存
     *
     * @param blog
     * @return
     */
    void save(Blog blog);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Blog getById(String id);

    /**
     * 更新
     *
     * @param blog
     * @return
     */
    void update(Blog blog);

    /**
     * 根据id阅读
     *
     * @param id
     * @return
     */
    BlogVo readById(String id);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    void deleteById(String id);

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    Page<BlogVo> getByPage(Page<BlogVo> page);
}
