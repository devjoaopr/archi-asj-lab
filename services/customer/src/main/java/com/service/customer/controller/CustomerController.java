package com.service.customer.controller;

import com.service.customer.dto.CreateCustomerRequest;
import com.service.customer.dto.CustomerResponse;
import com.service.customer.services.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
