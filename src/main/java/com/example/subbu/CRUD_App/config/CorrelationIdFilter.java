package com.example.subbu.CRUD_App.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

/**
 * Filter to intercept all HTTP requests, extract or generate a Correlation ID,
 * and populate the SLF4J MDC (Mapped Diagnostic Context) for traceable logging.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorrelationIdFilter extends OncePerRequestFilter {

    private static final String CORRELATION_ID_HEADER = "X-Correlation-Id";
    private static final String MDC_CORRELATION_ID_KEY = "correlationId";
    
    // Nginx standard headers
    private static final String X_FORWARDED_FOR_HEADER = "X-Forwarded-For";
    private static final String X_REAL_IP_HEADER = "X-Real-IP";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. Try to extract correlationId from incoming headers (from Nginx)
        String correlationId = request.getHeader(CORRELATION_ID_HEADER);

        // 2. Generate a new UUID if none was provided by the client/API gateway
        if (correlationId == null || correlationId.trim().isEmpty()) {
            correlationId = UUID.randomUUID().toString();
        }

        // Extract Client IP from Nginx
        String clientIp = request.getHeader(X_REAL_IP_HEADER);
        if (clientIp == null || clientIp.isEmpty()) {
            clientIp = request.getHeader(X_FORWARDED_FOR_HEADER);
        }
        if (clientIp == null || clientIp.isEmpty()) {
            clientIp = request.getRemoteAddr();
        }

        // 3. Put correlationId and IP in MDC so logback can automatically print it in logs
        MDC.put(MDC_CORRELATION_ID_KEY, correlationId);
        MDC.put("clientIp", clientIp);

        // 4. Add it to the response header so the client knows their specific request ID
        response.addHeader(CORRELATION_ID_HEADER, correlationId);

        try {
            // Proceed with the request execution
            filterChain.doFilter(request, response);
        } finally {
            // ALWAYS clear MDC to prevent memory leaks and incorrect log correlation in thread pools
            MDC.remove(MDC_CORRELATION_ID_KEY);
            MDC.remove("clientIp");
        }
    }
}
