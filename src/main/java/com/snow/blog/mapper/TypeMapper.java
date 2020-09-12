package com.snow.blog.mapper;

import com.snow.blog.pojo.Type;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 帖子类型表Mapper
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Component
public interface TypeMapper {

    /**
     * 根据名称查询
     *
     * @param typeName
     * @return
     */
    Type getByName(String typeName);

    /**
     * 新增类型
     *
     * @param type
     */
    void insert(Type type);

    /**
     * 查询所有类型
     *
     * @return
     */
    List<Type> getAll();

    /**
     * 查询分类列表
     *
     * @return
     */
    List<Type> getTypeList();

    /**
     * 更新分类
     *
     * @param type
     */
    void update(Type type);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Type getById(Integer id);

    /**
     * 根据id删除
     *
     * @param id
     */
    void deleteById(Integer id);
}
