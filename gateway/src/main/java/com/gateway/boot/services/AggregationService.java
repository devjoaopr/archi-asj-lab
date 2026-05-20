package com.gateway.boot.services;

import com.gateway.boot.dto.*;
import jakarta.ws.rs.core.HttpHeaders;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.UUID;

@Service
public class AggregationService {
    private final RestClient customerRestClient;
    private final RestClient caseRestClient;

    public AggregationService(RestClient customerRestClient, RestClient caseRestClient) {
        this.customerRestClient = customerRestClient;
        this.caseRestClient = caseRestClient;
    }

    public CustomerCaseSummary getCustomerwithCases(UUID customerId, String authorizationHeader) {

        CustomerResponse customer = customerRestClient.get()
                .uri("/customers/{id}", customerId)
                .header(HttpHeaders.AUTHORIZATION, authorizationHeader)
                .retrieve()
                .body(CustomerResponse.class);

        List<CaseResponse> cases = caseRestClient.get()
                .uri("/cases/customer/{customerId}", customerId)
                .header(HttpHeaders.AUTHORIZATION, authorizationHeader)
                .retrieve()
                .body(new ParameterizedTypeReference<List<CaseResponse>>() {
                });

        return new CustomerCaseSummary(customer, cases);
    }

}
