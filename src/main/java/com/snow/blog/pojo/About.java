package com.snow.blog.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 关于表实体类
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Data
public class About implements Serializable {

    /**
     * 帖子id
     */
    private Integer aboutId;

    /**
     * 标题
     */
    private String aboutTitle;

    /**
     * 帖子内容
     */
    private String aboutContent;

    /**
     * 阅读数
     */
    private Integer aboutRead;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 是否启用，0否1是
     */
    private Integer enable;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 是否删除，0否1是
     */
    private Integer deleted;

}
