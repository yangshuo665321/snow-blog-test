package com.snow.blog.controller;

import com.snow.blog.pojo.Type;
import com.snow.blog.service.TypeService;
import com.snow.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类型控制层
 *
 * @author yangshuo
 * @Description 类型控制层
 * @Date 2020/9/12
 * @Version 1.0
 */
@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 添加类型
     *
     * @param type
     * @return
     */
    @PostMapping("/save")
    public Result<Object> save(@RequestBody Type type) {
        typeService.save(type);
        return new Result<>("添加成功！");
    }

    /**
     * 后台查询所有类型
     *
     * @return
     */
    @GetMapping("/listBack")
    public Result<List<Type>> list() {
        List<Type> typeList = typeService.getAll();
        return new Result<>(typeList);
    }

    /**
     * 前台查询所有类型
     *
     * @return
     */
    @GetMapping("/getList")
    public Result<List<Type>> getList() {
        List<Type> typeList = typeService.getTypeList();
        return new Result<>(typeList);
    }

    /**
     * 根据id更新
     *
     * @param type
     * @return
     */
    @PutMapping("/update")
    public Result<Object> update(@RequestBody Type type) {
        typeService.update(type);
        return new Result<>("更新成功！");
    }

    /**
     * 根据id启用
     *
     * @param id
     * @return
     */
    @PutMapping("/enable/{id}")
    public Result<Object> enable(@PathVariable Integer id) {
        typeService.enableById(id);
        return new Result<>("已启用");
    }

    /**
     * 根据id弃用
     *
     * @param id
     * @return
     */
    @PutMapping("/disable/{id}")
    public Result<Object> disable(@PathVariable Integer id) {
        typeService.disableById(id);
        return new Result<>("已弃用");
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable Integer id) {
        typeService.deleteById(id);
        return new Result<>("删除成功！");
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result<Type> getById(@PathVariable Integer id) {
        Type type = typeService.getById(id);
        return new Result<>(type);
    }

}
