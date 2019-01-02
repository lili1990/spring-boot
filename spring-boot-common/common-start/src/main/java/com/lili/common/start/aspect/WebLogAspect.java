package com.lili.common.start.aspect;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;



/**
 * Created by lili19289 on 2016/12/28.
 */

public class WebLogAspect {

    private Logger logger = Logger.getLogger(getClass());


    @Around(value = "webLog()")
    public void webLog(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuilder sb = new StringBuilder();
        // 记录下请求内容
        sb.append("请求url>>>> " ).append( request.getRequestURL().toString()).append("\n");
        sb.append("请求method>>> " ).append( joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()).append("\n");
        sb.append("请求args >>>" ).append(Arrays.toString(joinPoint.getArgs())).append("\n");
        Object result = null;
        try {
            result = joinPoint.proceed();
            sb.append("result>>>>>>>>").append(result);
        } finally {
            long endTime = System.currentTimeMillis();
            sb.append( " >>>>>>>> spend time ").append(endTime - startTime).append("millis");
            logger.error( sb.toString());
            MDC.clear();
        }
        logger.info(sb.toString());
    }
    @AfterReturning(returning = "returnValue", pointcut = "webLog()")
    public void doAfterReturning(Object returnValue) throws Throwable {
        // 处理完请求，返回内容
        logger.info("请求结果 : " + returnValue);
    }

}
