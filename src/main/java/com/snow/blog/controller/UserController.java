package com.snow.blog.controller;

import com.snow.blog.enums.ResultEnum;
import com.snow.blog.pojo.User;
import com.snow.blog.service.UserService;
import com.snow.blog.utils.Page;
import com.snow.blog.utils.Result;
import com.snow.blog.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * UserController
 *
 * @author yangshuo
 * @Description UserController
 * @Date 2020/9/13
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 保存
     *
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Result<Object> save(@RequestBody User user) {
        userService.save(user);
        return new Result<>("添加成功！");
    }

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @PutMapping("/update")
    public Result<Object> update(@RequestBody User user) {
        userService.update(user);
        return new Result<>("修改成功！");
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result<User> get(@PathVariable Integer id) {
        User user = userService.getById(id);
        return new Result<>(user);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return new Result<>("删除成功！");
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @PostMapping("/getByPage")
    public Result<Page<User>> getByPage(@RequestBody Page<User> page) {
        String sortColumn = page.getSortColumn();
        if (StringUtils.isNotBlank(sortColumn)) {
            // 排序列不为空
            String[] sortColumns = {"sex", "created_time", "update_time"};
            List<String> sortList = Arrays.asList(sortColumns);
            if (!sortList.contains(sortColumn.toLowerCase())) {
                return new Result<>(ResultEnum.PARAMS_ERROR.getCode(), "排序参数不合法！");
            }
        }
        page = userService.getByPage(page);
        return new Result<>(page);
    }

//    /**
//     * 修改个人信息
//     *
//     * @param user
//     * @return
//     */
//    @PutMapping("/updateInfo")
//    public Result<Object> updateInfo(@RequestBody User user) {
//        userService.updateInfo(user);
//        return new Result<>("修改成功！");
//    }

//    /**
//     * 重置密码
//     *
//     * @return
//     */
//    @RequestMapping(value = "/resetPwd", method = RequestMethod.PUT)
//    public Result<Object> resetPwd(@RequestBody List<Integer> userIds) {
//        userService.resetPwd(userIds);
//        return new Result<>("重置完毕！");
//    }
//
//    /**
//     * 注册
//     */
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public Result<Object> register(@RequestBody User user) {
//        userService.register(user);
//        return new Result<>("注册成功！");
//    }
//
//    /**
//     * 登录
//     *
//     * @param user
//     * @return
//     */
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public Result<Object> login(@RequestBody User user) {
//        if (user == null || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
//            return new Result<>(ResultEnum.PARAMS_NULL.getCode(), "用户名或密码错误！");
//        }
//        Subject subject = SecurityUtils.getSubject();
//        AuthenticationToken authenticationToken = new UsernamePasswordToken(user.getUsername(), user.getPassword(), StateEnums.USER.getCode());
//        try {
//            subject.login(authenticationToken);
//        } catch (Exception e) {
//            return new Result<>(ResultEnum.PARAMS_NULL.getCode(), "用户名或密码错误！");
//        }
//        // 登录成功
//        Serializable sessionId = subject.getSession().getId();
//        User u = (User) subject.getPrincipal();
//        u.setPassword("");
//        u.setDeleted(null);
//        Map<String, Object> returnMap = new HashMap<>(2);
//        returnMap.put("token", sessionId);
//        returnMap.put("user", u);
//        return new Result<>(returnMap);
//    }
//
//    /**
//     * 查询当前用户的评论数和收藏数
//     * @return
//     */
//    @RequestMapping(value = "/commentAndCollectionCount", method = RequestMethod.GET)
//    public Result<Map<String, Object>> commentAndCollectionCount() {
//        Map<String, Object> countMap = userService.getCommentAndCollectionCount();
//        return new Result<>(countMap);
//    }

}
