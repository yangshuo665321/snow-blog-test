package com.snow.blog.service;

import com.snow.blog.pojo.About;
import com.snow.blog.utils.Page;

/**
 * 关于服务层接口
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
public interface AboutService {

    /**
     * 保存
     *
     * @param about
     * @return
     */
    void save(About about);

    /**
     * 更新
     *
     * @param about
     * @return
     */
    void update(About about);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    About getById(Integer id);

    /**
     * 阅读
     *
     * @return
     */
    About read();

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    void deleteById(Integer id);

    /**
     * 启用
     *
     * @param id
     * @return
     */
    void enableById(Integer id);

    /**
     * 弃用
     *
     * @param id
     * @return
     */
    void disableById(Integer id);

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    Page<About> getByPage(Page<About> page);
}
