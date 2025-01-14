package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*
     * 学员列表数据的条件分页查询
     */
    @GetMapping
    public Result list() {
        log.info("查询所有学生信息");
        return Result.success();
    }
}
