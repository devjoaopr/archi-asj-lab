package com.gateway.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.function.ServerRequest;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.rewritePath;
import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;
import java.util.UUID;

@Configuration
public class GatewayConfig {

    @Bean
    public RouterFunction<ServerResponse> testRoute() {
        return route("test-route")
                .route(path("/test/**"), http())
                .before(uri("https://httpbin.org"))
                .filter(rewritePath("/test/(?<segment>.*)", "/${segment}"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> helloServiceRoute() {
        return route("hello-service-route")
                .route(path("/hello-service/**"), http())
                .before(request -> {
                    String correlationId = request.headers()
                            .firstHeader("X-Correlation-Id");

                    if (correlationId == null || correlationId.isBlank()) {
                        correlationId = UUID.randomUUID().toString();
                    }
                    return ServerRequest.from(request)
                            .header("X-Correlation-Id", correlationId)
                            .build();
                })
                .filter(lb("hello-service"))
                .filter(rewritePath("/hello-service/(?<segment>.*)", "/${segment}"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userServiceRoute() {
        return route("user-service-route")
                .route(path("/user-service/**"), http())
                .before(request -> {
                    String correlationId = request.headers()
                            .firstHeader("X-Correlation-Id");

                    if (correlationId == null || correlationId.isBlank()) {
                        correlationId = UUID.randomUUID().toString();
                    }
                    return ServerRequest.from(request)
                            .header("X-Correlation-Id", correlationId)
                            .build();
                })
                .filter(lb("user-service"))
                .filter(rewritePath("/user-service/(?<segment>.*)", "/${segment}"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> caseServiceRoute() {
        return route("case-service-route")
                .route(path("/case-service/**"), http())
                .before(request -> {
                    String correlationId = request.headers()
                            .firstHeader("X-Correlation-Id");

                    if (correlationId == null || correlationId.isBlank()) {
                        correlationId = UUID.randomUUID().toString();
                    }
                    return ServerRequest.from(request)
                            .header("X-Correlation-Id", correlationId)
                            .build();
                })
                .filter(lb("case-service"))
                .filter(rewritePath("/case-service/(?<segment>.*)", "/${segment}"))
                .build();
    }
}