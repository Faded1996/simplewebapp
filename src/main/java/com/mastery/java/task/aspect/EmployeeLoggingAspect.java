package com.mastery.java.task.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class EmployeeLoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeLoggingAspect.class);

    @Pointcut("execution(* com.mastery.java.task.exceptions.*.* (..))")
    private void methodsFromExceptionsPackage() {

    }

    @Pointcut("execution(* com.mastery.java.task.*.*.* (..))")
    private void allMethods() {
    }

    @Around("allMethods() && !methodsFromExceptionsPackage()")
    public Object logApplicationMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Object[] methodArgs = joinPoint.getArgs();

        LOGGER.debug("Method invoked: {}:{}() with args: {}", className, methodName, Arrays.toString(methodArgs));

        Object result = joinPoint.proceed();

        LOGGER.debug("Method {}:{}() Response: {}", className, methodName, Arrays.toString(methodArgs));

        return result;
    }


}
