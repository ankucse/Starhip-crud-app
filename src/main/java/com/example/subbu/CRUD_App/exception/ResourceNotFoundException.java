package com.example.subbu.CRUD_App.exception;

/**
 * Custom exception to be thrown when a resource is not found.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
