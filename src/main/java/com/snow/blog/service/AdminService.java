package com.snow.blog.service;

import com.snow.blog.pojo.Admin;

/**
 * 管理员表服务层接口
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
public interface AdminService {

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    Admin getByUsername(String username);

}
