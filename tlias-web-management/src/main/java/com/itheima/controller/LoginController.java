package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    /*
     *  用户登录
     */
    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("用户登录：{}", emp);
        LoginInfo info = empService.Login(emp);
        if (info != null) {
            return Result.success();
        }
        return Result.error("用户名或密码错误");
    }
}
