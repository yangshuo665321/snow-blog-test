package com.snow.blog.controller;

import com.snow.blog.enums.ResultEnum;
import com.snow.blog.pojo.Admin;
import com.snow.blog.service.AdminService;
import com.snow.blog.utils.Result;
import com.snow.blog.utils.ShiroUtils;
import com.snow.blog.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Admin用户Controller层
 *
 * @author yangshuo
 * @Description Admin用户Controller层
 * @Date 2020/9/10
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * admin登陆
     *
     * @param admin
     * @return
     */
    @PostMapping("/login")
    public Result<Object> login(@RequestBody Admin admin) {
        // 1. 校验参数
        if (admin == null || StringUtils.isBlank(admin.getUsername()) || StringUtils.isBlank(admin.getPassword())) {
            return new Result<>(ResultEnum.PARAMS_NULL.getCode(), "用户名或密码错误！");
        }
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken authenticationToken = new UsernamePasswordToken(admin.getUsername(), admin.getPassword());
        try {
            subject.login(authenticationToken);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(ResultEnum.PARAMS_NULL.getCode(), "用户名或密码错误！");
        }

        // 登录成功
        Serializable sessionId = subject.getSession().getId();
        Map<String, Object> returnMap = new HashMap<>(2);
        returnMap.put("token", sessionId);
        return new Result<>(returnMap);
    }

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    @GetMapping("/info")
    public Result<Admin> getLoginInfo() {
        Admin loginAdmin = (Admin) ShiroUtils.getLoginUser();
        // 返回信息设置不带出密码
        loginAdmin.setPassword("");
        return new Result<>(loginAdmin);
    }

    /**
     * 查询管理员
     *
     * @return
     */
    @GetMapping("/getAdmin")
    public Result<Admin> getAdmin() {
        Admin admin = adminService.getAdmin();
        return new Result<>(admin);
    }

    /**
     * 更新个人信息
     *
     * @param admin
     * @return
     */
    @PutMapping("/updateInfo")
    public Result<Object> updateInfo(@RequestBody Admin admin) {
        adminService.updateInfo(admin);
        return new Result<>("更新成功！");
    }

    /**
     * 更新密码
     *
     * @param admin
     * @return
     */
    @PutMapping("/updatePassword")
    public Result<Object> updatePassword(@RequestBody Admin admin) {
        adminService.updatePassword(admin);
        return new Result<>("更新成功！");
    }

}
