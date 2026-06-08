package com.gateway.boot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    @Primary
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }

    @Bean
    @LoadBalanced
    public RestClient.Builder loadBalancedBuilder() {
        return RestClient.builder();
    }

    @Bean
    public RestClient customerRestClient(
            @Qualifier("loadBalancedBuilder")
            RestClient.Builder builder
    ) {
        return builder
                .clone()
                .baseUrl("http://customer-service")
                .build();
    }

    @Bean
    public RestClient registerRestClient(
            @Qualifier("loadBalancedBuilder")
            RestClient.Builder builder
    ) {
        return builder
                .clone()
                .baseUrl("http://user-service")
                .build();
    }


    @Bean
    public RestClient caseRestClient(
            @Qualifier("loadBalancedBuilder")
            RestClient.Builder builder
    ) {
        return builder
                .clone()
                .baseUrl("http://case-service")
                .build();
    }

}