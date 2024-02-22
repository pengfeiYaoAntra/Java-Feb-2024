package com.training.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyExceptionHandlerLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandlerLoggingAspect.class);

    //pointCut
    @Pointcut("within(com.training.demo.exceptions.MyExceptions)")
    public void exceptionHandlerMethods(){}

    //before advice

    @Before("exceptionHandlerMethods()")
    public void logBeforeExceptionHandler(JoinPoint joinPoint){
        logger.info("Before executing handler method: {}",joinPoint.getSignature().getName());
    }


    @After("exceptionHandlerMethods()")
    public void logAfterExceptionHandler(JoinPoint joinPoint){
        logger.info("After executing handler method: {}",joinPoint.getSignature().getName());
    }
}
