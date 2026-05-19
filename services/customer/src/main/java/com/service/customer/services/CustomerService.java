package com.service.customer.services;

import com.service.customer.dto.CreateCustomerRequest;
import com.service.customer.dto.CustomerResponse;
import com.service.customer.entity.Customer;
import com.service.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerResponse create(CreateCustomerRequest request) {

        if (repository.existsByCpf(request.getCpf())) {
            throw new IllegalArgumentException("CPF already registered");
        }

        Customer customer = new Customer();
        customer.setUsername(request.getUsername());
        customer.setAge(request.getAge());
        customer.setCpf(request.getCpf());

        Customer saved = repository.save(customer);

        return new CustomerResponse(
                saved.getId(),
                saved.getUsername(),
                saved.getAge(),
                saved.getCpf()
        );
    }

    public CustomerResponse findById(UUID id) {
        Customer entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Case not found: " + id));

        return new CustomerResponse(
                entity.getId(),
                entity.getUsername(),
                entity.getAge(),
                entity.getCpf()
        );
    }

}