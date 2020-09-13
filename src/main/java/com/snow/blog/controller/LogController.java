package com.snow.blog.controller;

import com.snow.blog.enums.ResultEnum;
import com.snow.blog.pojo.Log;
import com.snow.blog.service.LogService;
import com.snow.blog.utils.Page;
import com.snow.blog.utils.Result;
import com.snow.blog.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 日志Controller层
 *
 * @author yangshuo
 * @Description 日志Controller层
 * @Date 2020/9/13
 * @Version 1.0
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @PostMapping("/getByPage")
    public Result<Page<Log>> getByPage(@RequestBody Page<Log> page) {
        String sortColumn = page.getSortColumn();
        if (StringUtils.isNotBlank(sortColumn)) {
            // 排序列不为空
            String[] sortColumns = {"log_url", "log_status", "log_method", "log_time", "created_time"};
            List<String> sortList = Arrays.asList(sortColumns);
            if (!sortList.contains(sortColumn.toLowerCase())) {
                return new Result<>(ResultEnum.PARAMS_ERROR.getCode(), "排序参数不合法！");
            }
        }
        page = logService.getByPage(page);
        return new Result<>(page);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable Integer id) {
        logService.deleteById(id);
        return new Result<>("删除成功！");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @PutMapping("/deleteByIds")
    public Result<Object> deleteByIds(@RequestBody List<Integer> ids) {
        logService.deleteByIds(ids);
        return new Result<>("删除成功！");
    }

//    /**
//     * 全部导出
//     *
//     * @throws Exception
//     */
//    @PostMapping("/export")
//    public void export(HttpServletResponse response) throws Exception {
//        Workbook workbook = logService.export();
//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
//        response.setHeader("Content-Disposition", "attachment;filename=" + "日志");
//        response.flushBuffer();
//        workbook.write(response.getOutputStream());
//    }

}
