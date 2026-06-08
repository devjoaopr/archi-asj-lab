package com.gateway.boot.config;

import com.gateway.boot.filter.CorrelationIdBeforeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions.circuitBreaker;
import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.*;
import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;

@Configuration
public class GatewayConfig {

    private final CorrelationIdBeforeFilter correlationIdBeforeFilter;

    public GatewayConfig(CorrelationIdBeforeFilter correlationIdBeforeFilter) {
        this.correlationIdBeforeFilter = correlationIdBeforeFilter;
    }

    @Bean
    public RouterFunction<ServerResponse> customerServiceRoute() {

        return route("customer-service-route")
                .route(path("/v1/customer/**"), http())

                .before(correlationIdBeforeFilter)

                .filter(rewritePath(
                        "/v1/customer/(?<segment>.*)",
                        "/${segment}"
                ))

                .filter(circuitBreaker(config -> config
                        .setId("customerService")
                        .setFallbackPath("/fallback/customer")
                ))
                .filter(lb("customer-service"))

                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> registerServiceRoute() {

        return route("register-service-route")
                .route(path("/v1/user/**"), http())

                .before(correlationIdBeforeFilter)

                .filter(rewritePath(
                        "/v1/user/(?<segment>.*)",
                        "/${segment}"
                ))

                .filter(circuitBreaker(config -> config
                        .setId("userService")
                        .setFallbackPath("/fallback/user")
                ))
                .filter(lb("user-service"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> caseServiceRoute() {
        return route("case-service-route")
                .route(path("/v1/case/**"), http())
                .before(correlationIdBeforeFilter)
                .filter(rewritePath("/v1/case/(?<segment>.*)", "/${segment}"))
                .filter(circuitBreaker(config -> config
                        .setId("caseService")
                        .setFallbackPath("/fallback/case")
                ))
                .filter(lb("case-service"))
                .build();
    }
}