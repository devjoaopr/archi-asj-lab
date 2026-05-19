package com.service.customer.repository;

import com.service.customer.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    boolean existsByCpf(String cpf);
}
