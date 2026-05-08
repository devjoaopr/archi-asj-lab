package com.example.demo.services;

import com.example.demo.dto.CaseResponse;
import com.example.demo.dto.CreateCaseRequest;
import com.example.demo.entity.Cases;
import com.example.demo.repository.CaseRepository;
import org.springframework.stereotype.Service;

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

        Cases saved = repository.save(caseEntity);

        return new CaseResponse(
                saved.getId(),
                saved.getName(),
                saved.getDue(),
                saved.getCreated_at()
        );
    }
}