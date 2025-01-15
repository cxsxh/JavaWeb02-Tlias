package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    /*
     * 学员列表数据的条件分页查询
     */
    PageResult<Student> list(StudentQueryParam studentQueryParam);

    /*
     * 学员信息数据的删除
     */
    void delete(List<Integer> ids);

    /*
     * 学员信息数据的新增
     */
    void save(Student student);

    /*
     * 根据ID查询学员信息
     */
    Student getInfo(Integer id);

    /*
     * 学员信息数据的修改
     */
    void update(Student student);

    /*
     * 学员学员违纪处理
     */
    void violation(Integer id ,Integer score);

}
