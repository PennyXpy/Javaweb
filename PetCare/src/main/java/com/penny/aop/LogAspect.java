package com.penny.aop;


import com.alibaba.fastjson.JSONObject;
import com.penny.mapper.OperateLogMapper;
import com.penny.pojo.OperateLog;
import com.penny.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect // 切面类 -- 针对方法增加其功能
@Component
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.penny.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取属性
        //获取ID-- 获取jwt令牌解析
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operatorUser = (Integer) claims.get("id");

        LocalDateTime operateTime = LocalDateTime.now();

        // 操作类名
        String className = joinPoint.getTarget().getClass().getName();
        //操作方法名
        String methodName = joinPoint.getSignature().getName();
        //操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        // 调用原始目标方法运行
        Long begin = System.currentTimeMillis();
        Object result= joinPoint.proceed();
        Long end = System.currentTimeMillis();
        String returnValue = JSONObject.toJSONString(result);

        Long costTime = end - begin;

        //记录操作日志
        OperateLog operateLog = new OperateLog(null, operatorUser, operateTime, className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(operateLog);

        log.info("AOP操作日志：{}", operateLog);
        return result;

    }
}
