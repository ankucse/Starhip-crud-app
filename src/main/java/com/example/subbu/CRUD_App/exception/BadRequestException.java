package com.example.subbu.CRUD_App.exception;

/**
 * Custom exception to be thrown for bad requests (like duplicate emails).
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
