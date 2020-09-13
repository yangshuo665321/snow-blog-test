package com.snow.blog.controller;

import com.snow.blog.enums.ResultEnum;
import com.snow.blog.pojo.About;
import com.snow.blog.service.AboutService;
import com.snow.blog.utils.Page;
import com.snow.blog.utils.Result;
import com.snow.blog.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 关于我的Controller层
 *
 * @author yangshuo
 * @Description 关于我的Controller层
 * @Date 2020/9/13
 * @Version 1.0
 */
@RestController
@RequestMapping("/about")
public class AboutController {

    @Autowired
    private AboutService aboutService;

    /**
     * 保存
     *
     * @param about
     * @return
     */
    @PostMapping("/save")
    public Result<Object> save(@RequestBody About about) {
        aboutService.save(about);
        return new Result<>("添加成功！");
    }

    /**
     * 更新
     *
     * @param about
     * @return
     */
    @PutMapping("/update")
    public Result<Object> update(@RequestBody About about) {
        aboutService.update(about);
        return new Result<>("修改成功！");
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result<About> get(@PathVariable Integer id) {
        About about = aboutService.getById(id);
        return new Result<>(about);
    }

    /**
     * 阅读
     *
     * @return
     */
    @GetMapping("/read")
    public Result<About> read() {
        About about = aboutService.read();
        return new Result<>(about);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable Integer id) {
        aboutService.deleteById(id);
        return new Result<>("删除成功！");
    }

    /**
     * 启用
     *
     * @param id
     * @return
     */
    @PutMapping("/enable/{id}")
    public Result<Object> enable(@PathVariable Integer id) {
        aboutService.enableById(id);
        return new Result<>("启用成功");
    }

    /**
     * 弃用
     *
     * @param id
     * @return
     */
    @PutMapping("/disable/{id}")
    public Result<Object> disable(@PathVariable Integer id) {
        aboutService.disableById(id);
        return new Result<>("弃用成功");
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @PostMapping("/getByPage")
    public Result<Page<About>> getByPage(@RequestBody Page<About> page) {
        String sortColumn = page.getSortColumn();
        if (StringUtils.isNotBlank(sortColumn)) {
            // 排序列不为空
            String[] sortColumns = {"about_read", "created_time", "update_time"};
            List<String> sortList = Arrays.asList(sortColumns);
            if (!sortList.contains(sortColumn.toLowerCase())) {
                return new Result<>(ResultEnum.PARAMS_ERROR.getCode(), "排序参数不合法！");
            }
        }
        page = aboutService.getByPage(page);
        return new Result<>(page);
    }

}
