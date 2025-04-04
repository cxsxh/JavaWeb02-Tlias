package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    /*
     *  查询所有班级信息
     */
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    /*
     * 根据ID删除班级
     */
    void deleteById(Integer id);

    /*
     * 新增班级
     */
    void insert(Clazz clazz);

    /*
     * 根据ID查询班级
     */
    Clazz getById(Integer id);

    /*
     * 修改班级
     */
    void update(Clazz clazz);

    /*
     * 查询所有班级
     */
    List<Clazz> listAll();
}
