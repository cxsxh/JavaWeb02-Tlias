package com.itheima.mapper;

import com.itheima.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    /*
     * 分页查询日志
     */
    @Select("select id, operate_time, info methodParams from emp_log")
    List<Log> findAll();
}
