package com.snow.blog.service.impl;

import com.snow.blog.enums.ResultEnum;
import com.snow.blog.enums.StateEnums;
import com.snow.blog.exception.BlogException;
import com.snow.blog.mapper.AboutMapper;
import com.snow.blog.pojo.About;
import com.snow.blog.service.AboutService;
import com.snow.blog.utils.Page;
import com.snow.blog.vo.BlogVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 关于服务实现类
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Service
@Slf4j
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutMapper aboutMapper;

    /**
     * 保存
     *
     * @param about
     * @return
     */
    @Override
    public void save(About about) {
        aboutMapper.save(about);
    }

    /**
     * 更新
     *
     * @param about
     * @return
     */
    @Override
    public void update(About about) {
        aboutMapper.update(about);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public About getById(Integer id) {
        return aboutMapper.getById(id);
    }

    /**
     * 阅读
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public About read() {
        About about = aboutMapper.getAbout();
        if (about == null) {
            return null;
        }
        // 更新阅读数
        about.setAboutRead(about.getAboutRead() + 1);
        aboutMapper.update(about);
        return about;
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public void deleteById(Integer id) {
        aboutMapper.deleteById(id);
    }

    /**
     * 启用
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void enableById(Integer id) {
        // 查询是否已经存在我的启用
        About about = aboutMapper.getAbout();
        if (about != null) {
            throw new BlogException(ResultEnum.ERROR.getCode(), "当前已存在启用中的关于我的！");
        }
        about = aboutMapper.getById(id);
        about.setEnable(StateEnums.ENABLED.getCode());
        aboutMapper.updateEnable(about);
    }

    /**
     * 弃用
     *
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void disableById(Integer id) {
        About about = aboutMapper.getById(id);
        about.setEnable(StateEnums.NOT_ENABLE.getCode());
        aboutMapper.updateEnable(about);
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @Override
    public Page<About> getByPage(Page<About> page) {
        // 查询数据
        List<About> aboutList = aboutMapper.getByPage(page);
        page.setList(aboutList);
        // 查询总数
        int totalCount = aboutMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        return page;
    }
}
