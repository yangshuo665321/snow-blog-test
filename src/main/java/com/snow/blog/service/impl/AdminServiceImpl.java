package com.snow.blog.service.impl;

import com.snow.blog.mapper.AdminMapper;
import com.snow.blog.pojo.Admin;
import com.snow.blog.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员表服务实现类
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    @Override
    public Admin getByUsername(String username) {
        return adminMapper.getByUsername(username);
    }

    /**
     * 查询管理员
     *
     * @return
     */
    @Override
    public Admin getAdmin() {
        return adminMapper.getAdmin();
    }

    /**
     * 更新个人信息
     *
     * @param admin
     * @return
     */
    @Override
    public void updateInfo(Admin admin) {
        adminMapper.updateInfo(admin);
    }

    /**
     * 更新密码
     *
     * @param admin
     * @return
     */
    @Override
    public void updatePassword(Admin admin) {
        adminMapper.updatePassword(admin);
    }
}
