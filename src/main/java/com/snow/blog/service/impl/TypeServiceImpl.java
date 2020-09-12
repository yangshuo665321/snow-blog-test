package com.snow.blog.service.impl;

import com.snow.blog.enums.StateEnums;
import com.snow.blog.exception.BlogException;
import com.snow.blog.mapper.TypeMapper;
import com.snow.blog.pojo.Type;
import com.snow.blog.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 帖子类型表服务实现类
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Service
@Slf4j
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    /**
     * 添加类型
     *
     * @param type
     * @return
     */
    @Override
    public void save(Type type) {
        // 查询分类是否存在
        Type t = typeMapper.getByName(type.getTypeName());
        if (t != null) {
            throw new BlogException("该分类已存在！");
        }
        typeMapper.insert(type);
    }

    /**
     * 后台查询所有类型
     *
     * @return
     */
    @Override
    public List<Type> getAll() {
        return typeMapper.getAll();
    }

    /**
     * 前台查询所有类型
     *
     * @return
     */
    @Override
    public List<Type> getTypeList() {
        return typeMapper.getTypeList();
    }

    /**
     * 根据id更新
     *
     * @param type
     * @return
     */
    @Override
    public void update(Type type) {
        typeMapper.update(type);
    }

    /**
     * 根据id启用
     *
     * @param id
     * @return
     */
    @Override
    public void enableById(Integer id) {
        // 先根据ID查询类型
        Type type = typeMapper.getById(id);
        type.setEnable(StateEnums.ENABLED.getCode());
        // 修改类型
        typeMapper.update(type);
    }

    /**
     * 根据id弃用
     *
     * @param id
     * @return
     */
    @Override
    public void disableById(Integer id) {
        // 先根据ID查询类型
        Type type = typeMapper.getById(id);
        type.setEnable(StateEnums.NOT_ENABLE.getCode());
        // 修改类型
        typeMapper.update(type);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public void deleteById(Integer id) {
        typeMapper.deleteById(id);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Type getById(Integer id) {
        return typeMapper.getById(id);
    }
}
