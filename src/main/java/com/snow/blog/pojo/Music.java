package com.snow.blog.pojo;

import lombok.Data;

/**
 * 音乐
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Data
public class Music {

    /**
     * 音乐id
     */
    private Integer id;

    /**
     * 歌曲名
     */
    private String name;

    /**
     * 歌手
     */
    private String artist;

    /**
     * 歌曲链接
     */
    private String url;

    /**
     * 封面
     */
    private String cover;

    /**
     * 歌词
     */
    private String lrc;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 是否启用，0否1是
     */
    private Integer enabled;

    /**
     * 是否删除，0否1是
     */
    private Integer deleted;

}
