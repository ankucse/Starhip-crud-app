package com.example.subbu.CRUD_App.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Centralized exception handling to provide uniform API responses.
 * Enhanced to support correlation ID tracing for multi-instance environments.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @Value("${app.instance.id:instance-1}")
    private String instanceId;

    @Value("${server.port:8080}")
    private String serverPort;

    private Map<String, Object> buildBaseErrorResponse(HttpServletRequest request, HttpStatus status, String error, Object message) {
        String correlationId = MDC.get("correlationId");
        
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", status.value());
        errorResponse.put("error", error);
        errorResponse.put("message", message);
        errorResponse.put("path", request.getRequestURI());
        
        // Add distributed tracking metadata
        Map<String, String> meta = new HashMap<>();
        meta.put("servedBy", instanceId);
        meta.put("port", serverPort);
        meta.put("correlationId", correlationId != null ? correlationId : "N/A");
        errorResponse.put("meta", meta);
        
        return errorResponse;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        log.error("ResourceNotFoundException caught: {}", ex.getMessage());
        return new ResponseEntity<>(buildBaseErrorResponse(request, HttpStatus.NOT_FOUND, "Not Found", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequestException(BadRequestException ex, HttpServletRequest request) {
        log.error("BadRequestException caught: {}", ex.getMessage());
        return new ResponseEntity<>(buildBaseErrorResponse(request, HttpStatus.BAD_REQUEST, "Bad Request", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        log.error("MethodArgumentNotValidException caught. Validation failed.");

        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(buildBaseErrorResponse(request, HttpStatus.BAD_REQUEST, "Validation Failed", errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex, HttpServletRequest request) {
        log.error("Unexpected exception caught: ", ex);
        return new ResponseEntity<>(buildBaseErrorResponse(request, HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
