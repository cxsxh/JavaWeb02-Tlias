package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;

import java.util.List;

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

    /*
     * 批量删除员工
     */
    void delete(List<Integer> ids);

    /*
     * 根据ID查询员工信息
     */
    Emp getInfo(Integer id);

    /*
     * 修改员工
     */
    void update(Emp emp);

    /*
     * 查询全部员工
     */
    List<Emp> listAll();
}
