package com.example.demo.services;

import com.example.demo.dto.CaseResponse;
import com.example.demo.dto.CreateCaseRequest;
import com.example.demo.entity.Cases;
import com.example.demo.repository.CaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CaseService {

    private final CaseRepository repository;

    public CaseService(CaseRepository repository) {
        this.repository = repository;
    }

    public CaseResponse create(CreateCaseRequest request) {

        if (repository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Case already exists");
        }

        Cases caseEntity = new Cases();
        caseEntity.setName(request.getName());
        caseEntity.setDue(request.getDue());
        caseEntity.setCustomerId(request.getCustomerId());
        Cases saved = repository.save(caseEntity);

        return new CaseResponse(
                saved.getId(),
                saved.getName(),
                saved.getDue(),
                saved.getCreated_at(),
                saved.getCustomerId()
        );
    }

    public CaseResponse findById(UUID id) {
        Cases entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Case not found: " + id));

        return new CaseResponse(
                entity.getId(),
                entity.getName(),
                entity.getDue(),
                entity.getCreated_at(),
                entity.getCustomerId()
        );
    }

    public List<CaseResponse> findByCustomerId(UUID customer_id) {
        return repository.findByCustomerId(customer_id)
                .stream()
                .map(entity -> new CaseResponse(
                        entity.getId(),
                        entity.getName(),
                        entity.getDue(),
                        entity.getCreated_at(),
                        entity.getCustomerId()
                ))
                .toList();
    }

}