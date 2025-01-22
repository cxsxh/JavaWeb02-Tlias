package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.mapper.LogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageAndPageSize;
import com.itheima.pojo.PageResult;
import com.itheima.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;
    @Autowired
    private EmpMapper empMapper;

    /*
     * 分页查询日志
     */
    @Override
    public PageResult<OperateLog> logPage(PageAndPageSize pageAndPageSize) {
        PageHelper.startPage(pageAndPageSize.getPage(), pageAndPageSize.getPageSize());
        List<OperateLog> logListT = logMapper.findAll();

//        List<Integer> idS = new ArrayList<>();
//        logListT.forEach(log -> idS.add(log.getOperateEmpId()));
//
//        List<OperateLog> logList = empMapper.getByIdS(idS);

        Page<OperateLog> p = (Page<OperateLog>) logListT;
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
