package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.LogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageAndPageSize;
import com.itheima.pojo.PageResult;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /*
     * 分页查询日志
     */
    @Override
    public PageResult<OperateLog> logPage(PageAndPageSize pageAndPageSize) {
        PageHelper.startPage(pageAndPageSize.getPage(), pageAndPageSize.getPageSize());

        List<OperateLog> logList = logMapper.findAll();
        Page<OperateLog> p = (Page<OperateLog>) logList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
