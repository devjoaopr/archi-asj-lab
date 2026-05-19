package com.gateway.boot.controller;

import com.gateway.boot.services.AggregationService;
import jakarta.ws.rs.core.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gateway.boot.dto.CustomerCaseSummary;

@RestController
@RequestMapping("/v1/aggregate")
public class AggregationController {

    private final AggregationService aggregationService;

    public AggregationController(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerCaseSummary> getCustomerWithCases(
            @PathVariable String customerId,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization
    ) {
        CustomerCaseSummary summary = this.aggregationService.getCustomerwithCases(customerId, authorization);
        return ResponseEntity.ok().body(summary);
    }


}
