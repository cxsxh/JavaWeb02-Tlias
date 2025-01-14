package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result list(StudentQueryParam studentQueryParam) {
        log.info("查询所有学生信息");
        PageResult<Student> pageResult = studentService.list(studentQueryParam);
        return Result.success(pageResult);
    }

    /*
     * 学员信息数据的删除
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable Integer ids) {
        log.info("删除学员信息：{}", ids);
        studentService.delete(ids);
        return Result.success();
    }

    /*
     * 学员信息数据的新增
     */
    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("新增学员信息：{}", student);
        studentService.save(student);
        return Result.success();
    }

    /*
     * 根据ID查询学员信息
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据ID查询员工信息: {}", id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

    /*
     * 学员信息数据的修改
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改员工信息: {}", student);
        studentService.update(student);
        return Result.success();
    }

    /*
     * 学员违纪处理
     */
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("违纪处理: {}, {}", id, score);
        studentService.violation(id, score);
        return Result.success();
    }
}
