package com.itheima.mapper;

import com.itheima.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    /*
     * 分页查询日志
     */
    @Select("select id, operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time from operate_log")
    List<OperateLog> findAll();
}
