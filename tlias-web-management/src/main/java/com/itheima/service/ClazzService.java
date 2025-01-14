package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;

public interface ClazzService {

    /*
     *  查询所有班级信息
     */
    PageResult<Clazz> findAll(ClazzQueryParam clazzQueryParam);

    /*
     * 根据ID删除班级
     */
    void deleteById(Integer id);
}
