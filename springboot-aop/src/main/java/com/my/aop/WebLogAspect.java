package com.my.aop;

import com.baomidou.mybatisplus.extension.api.R;
import com.my.annotation.OperationLogAnnotation;
import com.my.bean.OperationLog;
import com.my.service.OperationLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author YangYunbo
 * @version 2021-06-08
 * <p>
 * 日志处理切面
 * <p>
 * 参考：https://blog.csdn.net/lmb55/article/details/82470388/
 */
@Aspect
@Component
public class WebLogAspect extends CommonPoints {
    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Autowired
    private OperationLogService operationLogService;

    @Before(value = "inWebLayer()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "result", pointcut = "inWebLayer()")
    public void doAfterReturning(JoinPoint joinPoint, Object result) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 处理完请求，返回内容
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //将返回值转换成map集合
        R r = (R) result;
        OperationLogAnnotation annotation = method.getAnnotation(OperationLogAnnotation.class);
        // 保存操作日志
        if (Objects.nonNull(annotation)) {
            OperationLog log = OperationLog.builder()
                    .user("admin")
                    .module(annotation.module())
                    .ip(request.getRemoteAddr())
                    .type(annotation.type().getType())
                    .description(annotation.description())
                    .result(r.getMsg())
                    .build();
            operationLogService.save(log);
        }
        logger.info("RESPONSE : " + result);
    }
}
