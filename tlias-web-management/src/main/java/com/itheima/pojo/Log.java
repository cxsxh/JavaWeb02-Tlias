package com.itheima.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Log {
    private Integer id;
    private LocalDateTime operateTime;
    private String methodParams;
}
