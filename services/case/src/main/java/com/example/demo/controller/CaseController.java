package com.example.demo.controller;

import com.example.demo.dto.CaseResponse;
import com.example.demo.dto.CreateCaseRequest;
import com.example.demo.services.CaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cases")
public class CaseController {
    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping
    public ResponseEntity<CaseResponse> create(@RequestBody CreateCaseRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(caseService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaseResponse> getCaseById(@PathVariable UUID id) {
        return ResponseEntity.ok(caseService.findById(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<CaseResponse>> getByCustomerId(@PathVariable UUID customerId) {
        return ResponseEntity.ok(caseService.findByCustomerId(customerId));
    }
}
