package com.example.hello.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.example.hello.controller..*.*(..))")
    private void cut(){

    }

    @Pointcut("@annotation(com.example.hello.annotation.Timer)")
    private void enableTimer(){

    }

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = proceedingJoinPoint.proceed();

        stopWatch.stop();

        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());

    }

}
