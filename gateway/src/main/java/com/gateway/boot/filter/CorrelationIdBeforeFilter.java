package com.gateway.boot.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.UUID;
import java.util.function.Function;

@Component
public class CorrelationIdBeforeFilter implements Function<ServerRequest, ServerRequest> {

    public static final String CORRELATION_ID_HEADER = "X-Correlation-Id";

    @Override
    public ServerRequest apply(ServerRequest request) {
        String correlationId = request.headers().firstHeader(CORRELATION_ID_HEADER);
        if (correlationId == null || correlationId.isBlank()) {
            correlationId = UUID.randomUUID().toString();
        }
        return ServerRequest.from(request)
                .header(CORRELATION_ID_HEADER, correlationId)
                .build();
    }
}
