package com.snow.blog.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 收藏时间实体类
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Data
public class BlogCollection implements Serializable {

    private static final long serialVersionUID = -535915810554536111L;

    /**
     * 收藏id
     */
    private String collectionId;

    /**
     * 帖子id
     */
    private String blogId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 收藏时间
     */
    private String collectionTime;

}
