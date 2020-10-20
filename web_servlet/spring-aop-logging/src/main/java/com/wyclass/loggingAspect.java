package com.wyclass;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loggingAspect {

    @Before("execution(public * com.wyclass.service.UserService.*(..))")
    public void doAccessCheck(){
        System.out.println("[Before] do access check....");
    }

    @Around("execution(public * com.wyclass.service.MailService.* (..))")
    public Object doLogging(ProceedingJoinPoint point) throws Throwable {
        System.err.println("[Around] start  "+point.getSignature());
        Object retVal =point.proceed();
        System.err.println("[Around] done "+point.getSignature());
        return  retVal;
    }
}
