package com.snow.blog.service;

import com.snow.blog.pojo.Type;

import java.util.List;

/**
 * 帖子类型表服务层接口
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
public interface TypeService {

    /**
     * 添加类型
     *
     * @param type
     * @return
     */
    void save(Type type);

    /**
     * 后台查询所有类型
     *
     * @return
     */
    List<Type> getAll();

    /**
     * 前台查询所有类型
     *
     * @return
     */
    List<Type> getTypeList();

    /**
     * 根据id更新
     *
     * @param type
     * @return
     */
    void update(Type type);

    /**
     * 根据id启用
     *
     * @param id
     * @return
     */
    void enableById(Integer id);

    /**
     * 根据id弃用
     *
     * @param id
     * @return
     */
    void disableById(Integer id);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    void deleteById(Integer id);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Type getById(Integer id);
}
