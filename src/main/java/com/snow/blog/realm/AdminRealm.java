package com.snow.blog.realm;

import com.snow.blog.enums.ResultEnum;
import com.snow.blog.enums.StateEnums;
import com.snow.blog.exception.BlogException;
import com.snow.blog.pojo.Admin;
import com.snow.blog.pojo.User;
import com.snow.blog.service.AdminService;
import com.snow.blog.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 处理管理员的登录和授权逻辑
 *
 * @author yangshuo
 * @date 2020-08-23
 * @Version 1.0
 */
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

//    @Autowired
//    private UserService userService;

    /**
     * 授权方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();

        Admin admin = adminService.getByUsername(username);
        if (admin == null) {
            // 用户不存在
            throw new BlogException(ResultEnum.ERROR.getCode(), "用户不存在！");
        }
        return new SimpleAuthenticationInfo(admin, admin.getPassword(), this.getName());

//        int state = usernamePasswordToken.getState();
//        if (state == StateEnums.ADMIN.getCode()) {
//            Admin admin = adminService.getByUsername(username);
//            if (admin == null) {
//                // 用户不存在
//                throw new BlogException(ResultEnum.ERROR.getCode(), "用户不存在！");
//            }
//            return new SimpleAuthenticationInfo(admin, admin.getPassword(), this.getName());
//        } else {
//            User user = userService.getByUsername(username);
//            if (user == null || user.getDeleted() == 1) {
//                throw new BlogException(ResultEnum.ERROR.getCode(), "用户不存在！");
//            }
//            return new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
//        }
    }
}
