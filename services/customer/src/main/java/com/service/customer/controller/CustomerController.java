package com.service.customer.controller;

import com.service.customer.dto.CreateCustomerRequest;
import com.service.customer.dto.CustomerResponse;
import com.service.customer.services.CustomerService;
import org.apache.catalina.Pipeline;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponse create(
            @RequestBody CreateCustomerRequest request
    ) {
        return customerService.create(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCaseById(@PathVariable UUID id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

}
//codigo comentado etc etc