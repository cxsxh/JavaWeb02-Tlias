package com.itheima.service;

import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageAndPageSize;
import com.itheima.pojo.PageResult;

public interface LogService {

    /*
     * 分页查询日志
     */
    PageResult<OperateLog> logPage(PageAndPageSize pageAndPageSize);
}
