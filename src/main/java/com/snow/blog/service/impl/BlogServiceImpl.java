package com.snow.blog.service.impl;

import com.snow.blog.mapper.BlogMapper;
import com.snow.blog.mapper.TypeMapper;
import com.snow.blog.pojo.Blog;
import com.snow.blog.pojo.Type;
import com.snow.blog.service.BlogService;
import com.snow.blog.utils.IdWorker;
import com.snow.blog.utils.Page;
import com.snow.blog.vo.BlogVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 博客表服务实现类
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Service
@Slf4j
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存
     *
     * @param blog
     * @return
     */
    @Override
    public void save(Blog blog) {
        blog.setBlogId(idWorker.nextId() + "");
        blogMapper.save(blog);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Blog getById(String id) {
        return blogMapper.getById(id);
    }

    /**
     * 更新
     *
     * @param blog
     * @return
     */
    @Override
    public void update(Blog blog) {
        blogMapper.update(blog);
    }

    /**
     * 根据id阅读
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BlogVo readById(String id) {
        Blog blog = blogMapper.getById(id);
        // 1 更新阅读数
        blog.setBlogRead(blog.getBlogRead() + 1);
        blogMapper.update(blog);
        // 2 将Blog转换为BlogVo
        BlogVo blogVo = new BlogVo();
        // 使用Spring的BeanUtils转换
        BeanUtils.copyProperties(blog, blogVo);
        // 查询分类
        Type type = typeMapper.getById(blog.getBlogType());
        blogVo.setTypeName(type.getTypeName());
        return blogVo;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public void deleteById(String id) {
        blogMapper.deleteById(id);
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<BlogVo> getByPage(Page<BlogVo> page) {
        // 查询数据
        List<BlogVo> blogVoList = blogMapper.getByPage(page);
        page.setList(blogVoList);
        // 查询总数
        int totalCount = blogMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        return page;
    }
}
