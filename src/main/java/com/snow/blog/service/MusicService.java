package com.snow.blog.service;

import com.snow.blog.pojo.Music;
import com.snow.blog.utils.Page;

/**
 * 音乐服务层接口
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
public interface MusicService {

    /**
     * 保存
     *
     * @param music
     * @return
     */
    void save(Music music);

    /**
     * 更新
     *
     * @param music
     * @return
     */
    void update(Music music);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Music getById(Integer id);

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
    Page<Music> getByPage(Page<Music> page);
}
