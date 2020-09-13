package com.snow.blog.service.impl;

import com.snow.blog.enums.StateEnums;
import com.snow.blog.mapper.MusicMapper;
import com.snow.blog.pojo.About;
import com.snow.blog.pojo.Music;
import com.snow.blog.service.MusicService;
import com.snow.blog.utils.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 音乐服务实现类
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Service
@Slf4j
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicMapper musicMapper;

    /**
     * 保存
     *
     * @param music
     * @return
     */
    @Override
    public void save(Music music) {
        musicMapper.save(music);
    }

    /**
     * 更新
     *
     * @param music
     * @return
     */
    @Override
    public void update(Music music) {
        musicMapper.update(music);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Music getById(Integer id) {
        return musicMapper.getById(id);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public void deleteById(Integer id) {
        musicMapper.deleteById(id);
    }

    /**
     * 启用
     *
     * @param id
     * @return
     */
    @Override
    public void enableById(Integer id) {
        Music music = musicMapper.getById(id);
        music.setEnabled(StateEnums.ENABLED.getCode());
        musicMapper.update(music);
    }

    /**
     * 弃用
     *
     * @param id
     * @return
     */
    @Override
    public void disableById(Integer id) {
        Music music = musicMapper.getById(id);
        music.setEnabled(StateEnums.NOT_ENABLE.getCode());
        musicMapper.update(music);
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @Override
    public Page<Music> getByPage(Page<Music> page) {
        // 查询数据
        List<Music> musicList = musicMapper.getByPage(page);
        page.setList(musicList);
        // 查询总数
        int totalCount = musicMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        return page;
    }
}
