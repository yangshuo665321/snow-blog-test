package com.snow.blog.mapper;

import com.snow.blog.pojo.Admin;
import org.springframework.stereotype.Component;

/**
 * 管理员表Mapper
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Component
public interface AdminMapper {

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    Admin getByUsername(String username);

    /**
     * 查询管理员
     *
     * @return
     */
    Admin getAdmin();

    /**
     * 更新个人信息
     *
     * @param admin
     */
    void updateInfo(Admin admin);

    /**
     * 更新密码
     *
     * @param admin
     * @return
     */
    void updatePassword(Admin admin);
}
