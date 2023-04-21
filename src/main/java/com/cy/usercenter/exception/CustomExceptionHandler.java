package com.cy.usercenter.exception;

import com.cy.usercenter.constant.ResponseConstants;
import com.cy.usercenter.model.exception.AppException;
import com.cy.usercenter.model.response.Response;
import com.cy.usercenter.util.ResponseUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 86147
 * create  12/4/2023 上午11:59
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(AppException.class)
    public Response appExceptionHandler(AppException appException){
        appException.printStackTrace();
        int code = appException.getCode();
        String msg = appException.getMsg();
        return ResponseUtil.error(code,msg);
    }

    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(Exception exception){
        exception.printStackTrace();
        int code = ResponseConstants.SYSTEM_ERROR.getCode();
        String msg = ResponseConstants.SYSTEM_ERROR.getMsg();
        return ResponseUtil.error(code,msg);
    }
}
