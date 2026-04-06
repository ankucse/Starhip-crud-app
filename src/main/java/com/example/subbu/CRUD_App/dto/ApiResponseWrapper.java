package com.example.subbu.CRUD_App.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A standard, generic wrapper to encapsulate all API responses
 * with metadata for distributed debugging, correlation tracing, and load balancing visibility.
 * @param <T> the type of the payload data
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseWrapper<T> {

    // The actual domain data
    private T data;

    // The distributed systems metadata
    private ApiMetadata meta;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ApiMetadata {
        private String servedBy;     // Which instance handled it (e.g., 'instance-2')
        private String port;         // Which port the instance is running on (e.g., '8082')
        private String correlationId; // The MDC tracking ID for the request
        private String timestamp;    // The ISO 8601 timestamp of the response
    }
}
