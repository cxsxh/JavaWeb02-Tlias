package com.itheima.controller;

import com.itheima.pojo.Log;
import com.itheima.pojo.PageAndPageSize;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/log")
@RestController
public class LogController {

    @Autowired
    private LogService logService;

    /*
     * 分页查询日志
     */
    @GetMapping("/page")
    public Result logPage(PageAndPageSize pageAndPageSize) {
        log.info("日志分页查询");
        PageResult<Log> pageResult = logService.logPage(pageAndPageSize);
        return Result.success(pageResult);
    }
}
