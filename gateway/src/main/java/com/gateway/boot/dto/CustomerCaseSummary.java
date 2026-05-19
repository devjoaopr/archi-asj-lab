package com.gateway.boot.dto;
import java.util.List;

public record CustomerCaseSummary(
        CustomerResponse customer,
        List<CaseResponse> cases
){}

