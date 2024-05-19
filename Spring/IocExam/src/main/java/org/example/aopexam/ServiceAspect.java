package org.example.aopexam;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
//    @Before("execution(* org.example.aopexam.*.*(..))")
//    public void before(JoinPoint joinPoint) {
//        System.out.println("Before ::::::: " + joinPoint.getSignature().getName());
//    }
//
//    @After("execution(* org.example.aopexam.SimpleService.*(..))")
//    public void after(JoinPoint joinPoint) {
//        System.out.println("After :::::::::: " + joinPoint.getSignature().getName());
//    }

    @Pointcut("execution(* org.example.aopexam.*.*(..))")
    public void pc1() {
        System.out.println("pc1");
    }

    @Pointcut("execution(* org.example.aopexam.SimpleService.*(..))")
    public void pc2() {
        System.out.println("pc2");
    }

    @Before("pc1()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before ::::::: " + joinPoint.getSignature().getName());
    }

    @After("pc2()")
    public void after(JoinPoint joinPoint) {
        System.out.println("After :::::::::: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* org.example.aopexam.*.*(..))", returning = "result")
    public void afterReturningServiceMethod(JoinPoint joinPoint, Object result) {
        System.out.println("After method: " + joinPoint.getSignature().getName() + ", return value: " + result);
    }

    @Before("execution(* setName(..))")
    public void beforeName(JoinPoint joinPoint) {
        System.out.println("beforeName :::::::: ");
        System.out.println("method name ::: " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(System.out::println);
    }

    @Around("pc1()")
    public String around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around run - before method");

        String value = (String) proceedingJoinPoint.proceed();

        System.out.println("around run - after method");
        value += " lee aop run!!";

        return value;
    }
}
