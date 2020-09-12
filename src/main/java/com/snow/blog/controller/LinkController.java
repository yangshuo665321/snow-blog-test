package com.snow.blog.controller;

import com.snow.blog.pojo.Link;
import com.snow.blog.service.LinkService;
import com.snow.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 友情链接Controller层
 *
 * @author yangshuo
 * @Description 友情链接Controller层
 * @Date 2020/9/12
 * @Version 1.0
 */
@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    /**
     * 添加
     *
     * @param link
     * @return
     */
    @PostMapping("/save")
    public Result<Object> save(@RequestBody Link link) {
        linkService.save(link);
        return new Result<>("添加成功！");
    }

    /**
     * 修改
     *
     * @param link
     * @return
     */
    @PutMapping("/update")
    public Result<Object> update(@RequestBody Link link) {
        linkService.update(link);
        return new Result<>("修改成功！");
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result<Link> get(@PathVariable Integer id) {
        Link link = linkService.getById(id);
        return new Result<>(link);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("/list")
    public Result<List<Link>> list() {
        List<Link> linkList = linkService.getAll();
        return new Result<>(linkList);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable Integer id) {
        linkService.deleteById(id);
        return new Result<>("删除成功！");
    }

}
