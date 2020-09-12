package com.snow.blog.service.impl;

import com.snow.blog.mapper.LinkMapper;
import com.snow.blog.pojo.Link;
import com.snow.blog.service.LinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友链服务实现类
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Service
@Slf4j
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    /**
     * 添加
     *
     * @param link
     * @return
     */
    @Override
    public void save(Link link) {
        linkMapper.save(link);
    }

    /**
     * 修改
     *
     * @param link
     * @return
     */
    @Override
    public void update(Link link) {
        linkMapper.update(link);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Link getById(Integer id) {
        return linkMapper.getById(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Link> getAll() {
        return linkMapper.getAll();
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public void deleteById(Integer id) {
        linkMapper.deleteById(id);
    }
}
