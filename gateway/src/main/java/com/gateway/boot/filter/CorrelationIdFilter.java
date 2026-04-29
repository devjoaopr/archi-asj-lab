package com.gateway.boot;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class CorrelationIdFilter extends OncePerRequestFilter {

    public static final String CORRELATION_ID_HEADER = "X-Correlation-Id";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String correlationId = request.getHeader(CORRELATION_ID_HEADER);

        if (correlationId == null || correlationId.isBlank()) {
            correlationId = UUID.randomUUID().toString();
        }

        final String finalCorrelationId = correlationId;

        MDC.put("correlationId", finalCorrelationId);
        response.setHeader(CORRELATION_ID_HEADER, finalCorrelationId);

        try {
            filterChain.doFilter(
                    new HttpServletRequestWrapper(request) {
                        @Override
                        public String getHeader(String name) {
                            if (CORRELATION_ID_HEADER.equalsIgnoreCase(name)) {
                                return finalCorrelationId;
                            }
                            return super.getHeader(name);
                        }
                    },
                    response
            );
        } finally {
            MDC.clear();
        }
    }
}