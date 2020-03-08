package com.la.common.logger;

import java.lang.annotation.*;

/**
 * 自定义日志注解
 * 可以注解在类上或者public的方法中
 * keys用于表示需要输出哪些参数，多个参数用','隔开。keys只有应用到方法中时，才有效
 * keys 不支持对对象内部属性进行过滤
 *
 * @author amen
 * @date: 2019-08-21
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ParamsLog {
    String[] value() default {};
}
