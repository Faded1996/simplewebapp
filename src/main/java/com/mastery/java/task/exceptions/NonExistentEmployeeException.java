package com.mastery.java.task.exceptions;

public class NonExistentEmployeeException extends RuntimeException {

    public NonExistentEmployeeException(String message) {
        super(message);
    }
}
