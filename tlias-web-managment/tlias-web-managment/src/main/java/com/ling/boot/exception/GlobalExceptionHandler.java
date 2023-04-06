package com.ling.boot.exception;

import com.ling.boot.pojo.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex){
        ex.printStackTrace();
        return  Result.error("对不起,操作失败，请联系管理员");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result ex(DuplicateKeyException duplicateKeyException){
        duplicateKeyException.printStackTrace();
        return  Result.error("添加失败，您添加了一个重名的部门,部门名称不可重复！！！");
    }

}
