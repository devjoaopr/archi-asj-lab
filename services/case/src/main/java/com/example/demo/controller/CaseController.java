package com.example.demo.controller;

import com.example.demo.dto.CaseResponse;
import com.example.demo.dto.CreateCaseRequest;
import com.example.demo.services.CaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cases")
public class CustomerController {
    private final caseService CaseService;

    public CustomerController(CaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping
    public CaseResponse create(
            @RequestBody CreateCaseRequest request
    ) {
        return caseService.create(request);
    }
}
