package com.snow.blog.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 友情链接
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Data
public class Link implements Serializable {

    /**
     * 链接id
     */
    private Integer linkId;

    /**
     * 名称
     */
    private String linkName;

    /**
     * 链接地址
     */
    private String linkUrl;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 是否删除，0否1是
     */
    private Integer deleted;

}
