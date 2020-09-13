package com.snow.blog.service.impl;

import com.snow.blog.mapper.UserMapper;
import com.snow.blog.pojo.User;
import com.snow.blog.service.UserService;
import com.snow.blog.utils.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表服务实现类
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 保存
     *
     * @param user
     * @return
     */
    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @Override
    public Page<User> getByPage(Page<User> page) {
        // 查询数据
        List<User> userList = userMapper.getByPage(page);
        page.setList(userList);
        // 查询总数
        int totalCount = userMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        return page;
    }
}
