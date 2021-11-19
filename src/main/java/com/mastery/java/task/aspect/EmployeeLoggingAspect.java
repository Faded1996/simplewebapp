package com.mastery.java.task.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
        ObjectMapper objectMapper = new ObjectMapper();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Object[] methodArgs = joinPoint.getArgs();

        LOGGER.debug("Method invoked " + className + " : " + methodName + "()" + " with args : " +
                objectMapper.writeValueAsString(methodArgs));

        Object result = joinPoint.proceed();

        LOGGER.debug(className + " : " + methodName + "()" + " Response:" + objectMapper.writeValueAsString(result));

        return result;
    }


}
