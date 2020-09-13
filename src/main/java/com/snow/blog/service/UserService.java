package com.snow.blog.service;

import com.snow.blog.pojo.User;
import com.snow.blog.utils.Page;

/**
 * 用户表服务层接口
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
public interface UserService {

    /**
     * 保存
     *
     * @param user
     * @return
     */
    void save(User user);

    /**
     * 更新
     *
     * @param user
     * @return
     */
    void update(User user);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    User getById(Integer id);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    void deleteById(Integer id);

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    Page<User> getByPage(Page<User> page);
}
