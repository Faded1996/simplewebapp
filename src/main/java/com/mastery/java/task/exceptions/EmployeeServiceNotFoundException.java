package com.mastery.java.task.exceptions;

public class EmployeeServiceNotFoundException extends RuntimeException {

    public EmployeeServiceNotFoundException(String message) {
        super(message);
    }
}
