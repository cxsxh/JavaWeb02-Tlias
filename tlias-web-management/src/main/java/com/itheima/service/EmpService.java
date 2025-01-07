package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;

public interface EmpService {

    /*
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);
    //PageResult<Emp> page(Integer page, Integer pageSizeString, String name, Integer gender, LocalDate begin, LocalDate end);

    /*
     * 新增员工
     */
    void save(Emp emp);

}
