package com.itheima.controller;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /*
     *  查询所有班级信息
     */
    @GetMapping
    public Result list(ClazzQueryParam clazzQueryParam) {
        log.info("查询所有班级信息");
        PageResult<Clazz> pageResult = clazzService.findAll(clazzQueryParam);
        return Result.success(pageResult);
    }

    /*
     * 根据ID删除班级
     */
    @DeleteMapping
    public Result delete(Integer id) {
        log.info("根据ID删除班级: {}", id);
        clazzService.deleteById(id);
        return Result.success();
    }
}
