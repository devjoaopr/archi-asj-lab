package com.example.demo.controller;

import com.example.demo.dto.CaseResponse;
import com.example.demo.dto.CreateCaseRequest;
import com.example.demo.services.CaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cases")
public class CaseController {
    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping
    public ResponseEntity <CaseResponse> create(@RequestBody CreateCaseRequest request){
        return  ResponseEntity.status(HttpStatus.CREATED).body(caseService.create(request));
    }
}
