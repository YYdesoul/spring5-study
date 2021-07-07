package com.soul.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AnnotationPoincut {

    @Before("execution(* com.soul.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("Log, before execute the method, by annotation");
    }

    @AfterReturning("execution(* com.soul.service.UserServiceImpl.*(..))")
    public void afterReturning() {
        System.out.println("Log, after returning execute the method, by annotation");
    }

    @After("execution(* com.soul.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("Log, after execute the method, by annotation");
    }

    @Around("execution(* com.soul.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Log, before around execute the method, by annotation");
        Object proceed = joinPoint.proceed();
        System.out.println("Log, after around execute the method, by annotation");
    }
}
