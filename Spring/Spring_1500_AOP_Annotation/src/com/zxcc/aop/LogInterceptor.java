package com.zxcc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect //一个切面
@Component //初始化
public class LogInterceptor {
    @Pointcut("execution(public * com.zxcc.dao..*.*(..))")
    public void myMethod(){}

    @Before("myMethod()") //在方法执行之前 调用此方法
    public void before(){
        System.out.println("method before");
    }

    @AfterReturning("myMethod()") //在所有方法执行之后 调用此方法
    public void afterReturning(){
        System.out.println("method after returning");
    }

    @AfterThrowing("myMethod()") //在调用方法抛异常时 调用此方法
    public void afterThrowing(){
        System.out.println("method after throwing");
    }

    @Around("myMethod()")
    public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("method around start");
        proceedingJoinPoint.proceed();
        System.out.println("method around end");
    }
}
