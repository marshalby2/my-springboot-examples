package com.my.aop;

import com.baomidou.mybatisplus.extension.api.R;
import com.my.annotation.OperationLogAnnotation;
import com.my.bean.OperationLog;
import com.my.service.OperationLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

/**
 * @author YangYunbo
 * @version 2021-06-08
 */
@Aspect
@Component
public class OperationLogAspect extends CommonPoints {

    @Autowired
    private OperationLogService operationLogService;

    @AfterReturning(returning = "result", pointcut = "inWebLayer()")
    public void saveOperationLog(JoinPoint joinPoint, Object result) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //将返回值转换成map集合
        R r = (R) result;
        OperationLogAnnotation annotation = method.getAnnotation(OperationLogAnnotation.class);
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
    }
}
