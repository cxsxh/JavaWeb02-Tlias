package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RequestMapping("/upload")
@RestController
public class UploadController {

    //本地磁盘存储方案
    /*@PostMapping
    public Result upload(String name, String age, MultipartFile file) throws IOException {
        log.info("文件上传：{},{},{}", name, age, file);
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();

        //新的文件名
        String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
        String newFileName = UUID.randomUUID().toString() + extension;

        //保存文件
        file.transferTo(new File("E:/视频/test/" + newFileName));

        return Result.success();
    }*/

    @Autowired
    AliyunOSSOperator aliyunOSSOperator;

    @SneakyThrows
    @PostMapping
    public Result upload(MultipartFile file) throws IOException {
        log.info("文件上传：{}", file);
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("文件上传成功，url：{}", url);
        return Result.success(url);
    }
}
