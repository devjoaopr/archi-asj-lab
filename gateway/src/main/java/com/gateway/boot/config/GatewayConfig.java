package com.gateway.boot.config;

import com.gateway.boot.filter.CorrelationIdBeforeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.rewritePath;
import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;

@Configuration
public class GatewayConfig {

    private final CorrelationIdBeforeFilter correlationIdBeforeFilter;

    public GatewayConfig(CorrelationIdBeforeFilter correlationIdBeforeFilter){
        this.correlationIdBeforeFilter = correlationIdBeforeFilter;
    }

    @Bean
    public RouterFunction<ServerResponse> userServiceRoute(){
        return route("customer-service-route")
                .route(path("/v1/customer/**"), http())
                .before(correlationIdBeforeFilter)
                .filter(lb("customer-service"))
                .filter(rewritePath("/v1/customer/(?<segment>.*)", "/${segment}"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> caseServiceRoute(){
        return route("case-service-route")
                .route(path("/v1/case/**"),
                        http())
                .before(correlationIdBeforeFilter)
                .filter(lb("case-service"))
                .filter(rewritePath("/v1/case/(?<segment>.*)", "/${segment}"))
                .build();
    }
}