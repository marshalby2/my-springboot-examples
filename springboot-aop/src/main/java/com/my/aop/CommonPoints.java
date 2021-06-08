package com.my.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author YangYunbo
 * @version 2021-06-08
 */
public class CommonPoints {
    /**
     * 匹配web包极其子包下的所有方法
     */
    @Pointcut("within(com.my.web..*)")
    public void inWebLayer() {
    }
}
