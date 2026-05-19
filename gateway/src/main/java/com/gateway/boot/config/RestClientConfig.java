package com.gateway.boot.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    @Bean
    @LoadBalanced
    public RestClient.Builder loadBalancedRestClientBuilder() {
        return RestClient.builder();
    }

    @Bean
    public RestClient customerRestClient(@LoadBalanced RestClient.Builder builder) {
        return builder.baseUrl("http://customer-service").build();
    }

    @Bean
    public RestClient caseRestClient(@LoadBalanced RestClient.Builder builder) {
        return builder.baseUrl("http://case-service").build();
    }
}
