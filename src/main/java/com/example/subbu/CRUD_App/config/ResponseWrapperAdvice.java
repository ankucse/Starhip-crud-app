package com.example.subbu.CRUD_App.config;

import com.example.subbu.CRUD_App.dto.ApiResponseWrapper;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ControllerAdvice that intercepts all successful @ResponseBody returns
 * and wraps them automatically with the ApiResponseWrapper without breaking
 * the underlying Controller methods' logic.
 */
@ControllerAdvice(basePackages = "com.example.subbu.CRUD_App.controller")
public class ResponseWrapperAdvice implements ResponseBodyAdvice<Object> {

    @Value("${app.instance.id:instance-1}")
    private String instanceId;

    @Value("${server.port:8080}")
    private String serverPort;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // We only wrap standard domain objects or lists, we do not want to wrap things 
        // that are already wrapped, like Strings, or the Error response Maps from ExceptionHandler.
        // For strings, Jackson struggles to convert ApiResponseWrapper into a string natively,
        // so we exclude String returns here to avoid ClassCastExceptions.
        return !returnType.getParameterType().equals(String.class) &&
               !returnType.getParameterType().equals(ApiResponseWrapper.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, 
                                  MethodParameter returnType, 
                                  MediaType selectedContentType, 
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, 
                                  ServerHttpRequest request, 
                                  ServerHttpResponse response) {
        
        String correlationId = MDC.get("correlationId");

        ApiResponseWrapper.ApiMetadata metadata = ApiResponseWrapper.ApiMetadata.builder()
                .servedBy(instanceId)
                .port(serverPort)
                .correlationId(correlationId != null ? correlationId : "N/A")
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .build();

        return ApiResponseWrapper.builder()
                .data(body)
                .meta(metadata)
                .build();
    }
}
