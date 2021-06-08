package com.my.annotation;

import com.my.constant.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author YangYunbo
 * @version 2021-06-08
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLogAnnotation {
    /**
     * 模块
     *
     * @return
     */
    String module() default "";

    /**
     * 类型
     *
     * @return
     */
    OperationType type() default OperationType.OTHER;

    /**
     * 操作描述
     *
     * @return
     */
    String description() default "";
}
