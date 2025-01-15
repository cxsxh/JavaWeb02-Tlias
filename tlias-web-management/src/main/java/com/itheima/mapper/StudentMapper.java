package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    /*
     * 学员列表数据的条件分页查询
     */
    List<Student> list(StudentQueryParam studentQueryParam);

    /*
     * 学员信息数据的删除
     */
    void delete(List<Integer> ids);

    /*
     * 学员信息数据的添加
     */
    void insert(Student student);

    /*
     * 根据ID查询学员信息
     */
    Student getById(Integer id);

    /*
     * 学员信息数据的修改
     */
    void upData(Student student);

    /*
     * 学员学员违纪处理
     */
    void violation(Integer id ,Integer score);

    /*
     * 统计学员学历
     */
    @MapKey("pos")
    List<Map<String, Object>> getStudentDegreeData();

    /*
     * 统计班级人数
     */
    @MapKey("pos")
    List<Map<String, Object>> getStudentCountData();
}
