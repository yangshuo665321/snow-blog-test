package com.snow.blog.controller;

import com.snow.blog.enums.ResultEnum;
import com.snow.blog.pojo.Music;
import com.snow.blog.service.MusicService;
import com.snow.blog.utils.Page;
import com.snow.blog.utils.Result;
import com.snow.blog.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 音乐Controller层
 *
 * @author yangshuo
 * @Description 音乐Controller层
 * @Date 2020/9/13
 * @Version 1.0
 */
@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    /**
     * 保存
     *
     * @param music
     * @return
     */
    @PostMapping("/save")
    public Result<Object> save(@RequestBody Music music) {
        musicService.save(music);
        return new Result<>("添加成功！");
    }

    /**
     * 更新
     *
     * @param music
     * @return
     */
    @PutMapping("/update")
    public Result<Object> update(@RequestBody Music music) {
        musicService.update(music);
        return new Result<>("修改成功！");
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result<Music> get(@PathVariable Integer id) {
        Music music = musicService.getById(id);
        return new Result<>(music);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable Integer id) {
        musicService.deleteById(id);
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
        musicService.enableById(id);
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
        musicService.disableById(id);
        return new Result<>("弃用成功");
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @PostMapping("/getByPage")
    public Result<Page<Music>> getByPage(@RequestBody Page<Music> page) {
        String sortColumn = page.getSortColumn();
        if (StringUtils.isNotBlank(sortColumn)) {
            // 排序列不为空
            String[] sortColumns = {"artist", "created_time", "enabled"};
            List<String> sortList = Arrays.asList(sortColumns);
            if (!sortList.contains(sortColumn.toLowerCase())) {
                return new Result<>(ResultEnum.PARAMS_ERROR.getCode(), "排序参数不合法！");
            }
        }
        page = musicService.getByPage(page);
        return new Result<>(page);
    }

//    /**
//     * 前台查询
//     *
//     * @return
//     */
//    @RequestMapping(value = "/getList", method = RequestMethod.GET)
//    public Result<List<Music>> getList() {
//        List<Music> musicList = musicService.getList();
//        return new Result<>(musicList);
//    }

}
