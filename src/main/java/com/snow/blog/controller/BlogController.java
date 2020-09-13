package com.snow.blog.controller;

import com.snow.blog.enums.ResultEnum;
import com.snow.blog.pojo.Blog;
import com.snow.blog.service.BlogService;
import com.snow.blog.utils.Page;
import com.snow.blog.utils.Result;
import com.snow.blog.utils.StringUtils;
import com.snow.blog.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 博客Controller层
 *
 * @author yangshuo
 * @Description 博客Controller层
 * @Date 2020/9/13
 * @Version 1.0
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 保存
     *
     * @param blog
     * @return
     */
    @PostMapping("/save")
    public Result<Object> save(@RequestBody Blog blog) {
        blogService.save(blog);
        return new Result<>("添加成功！");
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result<Blog> get(@PathVariable String id) {
        Blog blog = blogService.getById(id);
        return new Result<>(blog);
    }

    /**
     * 更新
     *
     * @param blog
     * @return
     */
    @PutMapping("/update")
    public Result<Object> update(@RequestBody Blog blog) {
        blogService.update(blog);
        return new Result<>("更新成功！");
    }

    /**
     * 根据id阅读
     *
     * @param id
     * @return
     */
    @GetMapping("/read/{id}")
    public Result<BlogVo> read(@PathVariable String id) {
        BlogVo blog = blogService.readById(id);
        return new Result<>(blog);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable String id) {
        blogService.deleteById(id);
        return new Result<>("删除成功！");
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @PostMapping("/getByPage")
    public Result<Page<BlogVo>> getByPage(@RequestBody Page<BlogVo> page) {
        String sortColumn = page.getSortColumn();
        if (StringUtils.isNotBlank(sortColumn)) {
            // 排序列不为空
            String[] sortColumns = {"blog_goods", "blog_read", "blog_collection",
                    "type_name", "blog_comment", "created_time", "update_time"};
            List<String> sortList = Arrays.asList(sortColumns);
            if (!sortList.contains(sortColumn.toLowerCase())) {
                return new Result<>(ResultEnum.PARAMS_ERROR.getCode(), "排序参数不合法！");
            }
        }
        page = blogService.getByPage(page);
        return new Result<>(page);
    }

//    /**
//     * 查询时间轴
//     *
//     * @return
//     */
//    @GetMapping("/getTimeLine")
//    public Result<List<TimeLineVo>> getTimeLine() {
//        List<TimeLineVo> timeList = new ArrayList<>(16);
//        List<BlogVo> blogVoList = blogService.getTimeLine();
//        blogVoList.forEach(e -> {
//            String blogMonth = e.getBlogMonth();
//            TimeLineVo timeLineVo = new TimeLineVo();
//            timeLineVo.setMonth(blogMonth);
//            if(timeList.contains(timeLineVo)) {
//                // 取出对应的数据
//                TimeLineVo timeLine = getTimeLineForList(timeList, timeLineVo);
//                List<BlogVo> list = timeLine.getList();
//                if(list == null) {
//                    list = new ArrayList<>(8);
//                }
//                list.add(e);
//                timeLine.setList(list);
//            } else {
//                List<BlogVo> list = timeLineVo.getList();
//                if(list == null) {
//                    list = new ArrayList<>(8);
//                }
//                list.add(e);
//                timeLineVo.setList(list);
//                timeList.add(timeLineVo);
//            }
//        });
//        return new Result<>(timeList);
//    }

//    /**
//     * 分页查询
//     *
//     * @return
//     */
//    @GetMapping("/recomRead")
//    public Result<List<BlogVo>> recomRead() {
//        List<BlogVo> blogList = blogService.recomRead();
//        return new Result<>(blogList);
//    }

//    /**
//     * 点赞
//     *
//     * @param blogGoods
//     * @return
//     */
//    @PostMapping("/good")
//    public Result<Object> good(@RequestBody BlogGoods blogGoods) {
//        if(StringUtils.isBlank(blogGoods.getBlogId())) {
//            return new Result<>("博客id不能为空！");
//        }
//        blogService.goodByBlogAndUser(blogGoods);
//        return new Result<>("点赞成功！");
//    }

//    /**
//     * 根据博客id和当前登录用户查询点赞记录
//     *
//     * @param blogId
//     * @return
//     */
//    @GetMapping("/getGood/{blogId}")
//    public Result<Integer> getGood(@PathVariable String blogId) {
//        int count = blogService.getGoodsCount(blogId);
//        return new Result<>(count);
//    }

//    /**
//     * 收藏
//     *
//     * @param blogCollection
//     * @return
//     */
//    @PostMapping("/collection")
//    public Result<Object> collection(@RequestBody BlogCollection blogCollection) {
//        if(StringUtils.isBlank(blogCollection.getBlogId())) {
//            return new Result<>("博客id不能为空！");
//        }
//        blogService.collectionByBlogId(blogCollection);
//        return new Result<>("收藏成功！");
//    }

//    /**
//     * 根据博客id和当前登录用户查询收藏记录
//     *
//     * @param blogId
//     * @return
//     */
//    @GetMapping("/getCollection/{blogId}")
//    public Result<Integer> getCollection(@PathVariable String blogId) {
//        int count = blogService.getCollectionCount(blogId);
//        return new Result<>(count);
//    }

//    /**
//     * 分页查询我的收藏
//     *
//     * @param page
//     * @return
//     */
//    @PostMapping("/getCollectionList")
//    public Result<Page<BlogCollection>> getCollectionList(@RequestBody Page<BlogCollection> page) {
//        page = blogService.getCollectionByPage(page);
//        return new Result<>(page);
//    }

//    /**
//     * 获取对应的timeLine
//     *
//     * @param timeList
//     * @param timeLineVo
//     * @return
//     */
//    private TimeLineVo getTimeLineForList(List<TimeLineVo> timeList, TimeLineVo timeLineVo) {
//        for (TimeLineVo lineVo : timeList) {
//            if(timeLineVo.getMonth().equals(lineVo.getMonth())) {
//                return lineVo;
//            }
//        }
//        return null;
//    }

}
