package com.itheima.service;

import com.itheima.pojo.Log;
import com.itheima.pojo.PageAndPageSize;
import com.itheima.pojo.PageResult;

public interface LogService {

    /*
     * 分页查询日志
     */
    PageResult<Log> logPage(PageAndPageSize pageAndPageSize);
}
