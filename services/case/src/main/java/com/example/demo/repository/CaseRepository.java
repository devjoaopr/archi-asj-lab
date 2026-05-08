package com.example.demo.repository;

import com.example.demo.entity.Cases;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CaseRepository extends CrudRepository<Cases, UUID> {
    Boolean existsByName(String name);
}
