package com.service.customer.repository;

import com.service.customer.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    boolean existsByCpf(String cpf);
}
