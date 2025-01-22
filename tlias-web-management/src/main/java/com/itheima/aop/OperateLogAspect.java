package com.itheima.aop;

import com.itheima.pojo.OperateLog;
import com.itheima.mapper.OperateLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    // 定义切入点，匹配com.itheima.controller包及其子包下的所有方法
    @Pointcut("@annotation(com.itheima.anno.Log)")
    public void controllerMethods() {}

    @Around("controllerMethods()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            // 执行目标方法
            Object result = joinPoint.proceed();

            // 记录日志
            recordOperationLog(joinPoint, null, result, start);

            return result;
        } catch (Throwable e) {
            // 如果有异常，同样需要记录日志
            recordOperationLog(joinPoint, e, null, start);
            throw e;
        }
    }

    private void recordOperationLog(ProceedingJoinPoint joinPoint, Throwable throwable, Object result, long startTime) {
        OperateLog log = new OperateLog();

        // 获取操作人ID（这里假设有一个静态方法可以获取当前登录用户ID）
        log.setOperateEmpId(getCurrentUserId());

        // 设置操作时间
        log.setOperateTime(LocalDateTime.now());

        // 设置类名和方法名
        log.setClassName(joinPoint.getTarget().getClass().getName());
        log.setMethodName(joinPoint.getSignature().getName());

        // 设置方法参数
        log.setMethodParams(Arrays.toString(joinPoint.getArgs()));

        // 设置返回值（如果方法抛出了异常，则返回值为null）
        if (throwable == null) {
            log.setReturnValue(result != null ? result.toString() : "null");
        } else {
            log.setReturnValue("Exception: " + throwable.getMessage());
        }

        // 设置方法执行耗时
        long endTime = System.currentTimeMillis();
        log.setCostTime(endTime - startTime);

        // 插入日志记录
        operateLogMapper.insert(log);
    }

    // 假设有一个方法用于获取当前登录用户的ID
    private Integer getCurrentUserId() {
        // 实现此方法以返回当前操作人的ID
        return 1; // 示例中直接返回1作为操作人ID
    }
}