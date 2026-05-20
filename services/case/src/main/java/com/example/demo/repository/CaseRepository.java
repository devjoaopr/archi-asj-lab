package com.example.demo.repository;

import com.example.demo.entity.Cases;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CaseRepository extends CrudRepository<Cases, UUID> {
    Boolean existsByName(String name);
    List<Cases> findByCustomerId(UUID customerId);
}
