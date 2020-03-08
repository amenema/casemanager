package com.la.common.exception;

import com.la.common.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

/**
 * 全局统一异常处理
 *
 * @author: amen
 * @date: 2019-08-21
 */
@Slf4j
@RestControllerAdvice
public class GlobalHandlerExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseResult missingParams(HttpServletRequest req, MissingServletRequestParameterException ex) {
        log.warn("缺少必要参数: method: {}, path: {}, errMsg: {}, stackInfo: {}", req.getMethod(), req.getRequestURI(), ex.getMessage(), ex);
        return ResponseResult.error("miss params");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult validatedError(HttpServletRequest req, ConstraintViolationException ex) {
        String errMsg = parseConstraintViolationExceptionMsg(ex);
        log.warn("参数校验异常: method: {}, path: {}, {}, stackInfo: {}", req.getMethod(), req.getRequestURI(), errMsg, ex);
        return ResponseResult.error("valid params");
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseResult businessException(HttpServletRequest req, BusinessException ex) {
        log.warn("业务逻辑异常: method: {}, path: {}, errMsg: {}, stackInfo: {}", req.getMethod(), req.getRequestURI(), ex.getMsg(), ex);
        return ResponseResult.error("business error");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseResult runTimeException(HttpServletRequest req, RuntimeException ex) {
        log.error("运行时异常: method: {}, path: {}, errMsg: {}, stackInfo: {}", req.getMethod(), req.getRequestURI(), ex.getMessage(), ex);
        return ResponseResult.error("business error");
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult exception(HttpServletRequest req, Exception ex) {
        log.error("系统异常: method: {}, path: {}, errMsg: {}, stackInfo: {}", req.getMethod(), req.getRequestURI(), ex.getMessage(), ex);
        return ResponseResult.error("system error");

    }

    private String parseConstraintViolationExceptionMsg(ConstraintViolationException ex) {
        Iterator<ConstraintViolation<?>> iterator = ex.getConstraintViolations().iterator();
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()) {
            ConstraintViolation<?> next = iterator.next();
            builder.append(" class: ").append(next.getRootBeanClass().getName())
                    .append(" function: ")
                    .append(next.getPropertyPath())
                    .append(" errMsg: ")
                    .append(next.getMessageTemplate());
        }
        return builder.toString();
    }

}
