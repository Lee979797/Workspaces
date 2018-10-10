package com.ninemax.common.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninemax.common.util.ShiroUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LogAspect {
    @Pointcut("execution(* com.ninemax.sys.service..*.*(..))")
    public void doLog() {
    }
    @Around("doLog()")
    public Object doLogService(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String params = new ObjectMapper().writeValueAsString(args);
        long start = System.nanoTime();
        Object obj = joinPoint.proceed();
        long end = System.nanoTime();
        String userName = ShiroUtils.getPrincipal();
        long executionTime = end - start;
        System.out.println(userName+" / "+method+" / "+params+" / "+executionTime);
        return obj;
    }
}
