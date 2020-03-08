package com.la.common.logger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 拦截被ParamsLog注释的方法
 *
 * @author: amen
 * @date: 2019-08-21
 * @see
 */
@Slf4j
@Aspect
@Component
public class ParamsLogAspect {

    @Pointcut("@annotation(com.la.common.logger.ParamsLog)")
    public void point() {
    }

    @Before("point()")
    public void doBefore(JoinPoint joinPoint) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            HashMap<String, Object> params = buildParams(signature, joinPoint.getArgs());
            log.info("class: {}, function: {}, params: {}", signature.getDeclaringTypeName(), signature.getName(), params);
        } catch (Exception e) {
            log.error("参数处理异常. errMsg: {}, stackInfo: {}", e.getMessage(), e);
        }
    }

    private HashMap<String, Object> buildParams(MethodSignature signature, Object[] args) {
        String[] parameterNames = signature.getParameterNames();
        int len = parameterNames.length;
        if (len > 0) {
            HashMap<String, Object> paramsMap = new HashMap<>((int) (len / 0.7));
            String[] keys = signature.getMethod().getAnnotation(ParamsLog.class).value();
            if (keys.length > 0) {
                for (String s : keys) {
                    paramsMap.put(s, null);
                }
                for (int i = 0; i < parameterNames.length; i++) {
                    if (paramsMap.containsKey(parameterNames[i])) {
                        paramsMap.put(parameterNames[i], args[i]);
                    }
                }
            } else {
                for (int i = 0; i < parameterNames.length; i++) {
                    paramsMap.put(parameterNames[i], args[i]);
                }
            }
            return paramsMap;
        } else {
            return null;
        }
    }

}
