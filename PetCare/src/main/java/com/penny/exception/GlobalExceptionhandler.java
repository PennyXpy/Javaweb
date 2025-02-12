package com.penny.exception;


import com.penny.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionhandler {

    @ExceptionHandler(Exception.class) // 补货所有异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("请联系管理员有error");
    }
}
