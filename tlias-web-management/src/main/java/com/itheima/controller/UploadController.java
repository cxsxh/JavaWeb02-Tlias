package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequestMapping("/upload")
@RestController
public class UploadController {

    @PostMapping
    public Result upload(String name, String age, MultipartFile file) {
        log.info("文件上传：{},{},{}", name, age, file);
        return Result.success();
    }
}
