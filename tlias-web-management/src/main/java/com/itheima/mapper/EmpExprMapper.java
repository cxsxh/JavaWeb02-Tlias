package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
 * 员工工作经历
 */
@Mapper
public interface EmpExprMapper {
    /*
     * 保存员工工作经历信息
     */
    void insertBatch(List<EmpExpr> exprList);

    /*
     * 根据员工id删除员工工作经历信息
     */
    void deleteByeEmpIds(List<Integer> empIds);
}
