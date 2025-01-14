package com.itheima.controller;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据ID删除班级: {}", id);
        clazzService.deleteById(id);
        return Result.success();
    }

    /*
     * 新增班级
     */
    @PostMapping
    public Result add(@RequestBody Clazz clazz) {
        log.info("新增班级: {}", clazz);
        clazzService.add(clazz);
        return Result.success();
    }

    /*
     * 根据ID查询班级
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询班级: {}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    /*
     * 修改班级
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级: {}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /*
     * 查询所有班级
     */
    @GetMapping("/list")
    public Result listAll() {
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.listAll();
        return Result.success(clazzList);
    }
}
