package com.mastery.java.task.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public EmployeeIncorrectData handleEmployeeServiceNotFoundException(
            EmployeeServiceNotFoundException e) {
        EmployeeIncorrectData employeeIncorrectData = new EmployeeIncorrectData();
        employeeIncorrectData.setInfo(e.getMessage());

        String stackTraceAsString = convertExceptionStackTraceToReadableString(e);
        log.error(stackTraceAsString);
        return employeeIncorrectData;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public EmployeeIncorrectData handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        EmployeeIncorrectData employeeIncorrectData = new EmployeeIncorrectData();
        employeeIncorrectData.setInfo(errors.toString());

        String stackTraceAsString = convertExceptionStackTraceToReadableString(e);
        log.error("Validation error: {}", stackTraceAsString);
        return employeeIncorrectData;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public EmployeeIncorrectData handleConstraintViolationException(ConstraintViolationException e) {
        EmployeeIncorrectData employeeIncorrectData = new EmployeeIncorrectData();
        employeeIncorrectData.setInfo(e.getMessage());

        String stackTraceAsString = convertExceptionStackTraceToReadableString(e);
        log.error("URL parameter validation error: {}", stackTraceAsString);
        return employeeIncorrectData;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public EmployeeIncorrectData handleEmployeeServiceBadRequests(Exception e) {
        EmployeeIncorrectData employeeIncorrectData = new EmployeeIncorrectData();
        employeeIncorrectData.setInfo(e.getMessage());

        String stackTraceAsString = convertExceptionStackTraceToReadableString(e);
        log.error(stackTraceAsString);
        return employeeIncorrectData;
    }

    private String convertExceptionStackTraceToReadableString(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
