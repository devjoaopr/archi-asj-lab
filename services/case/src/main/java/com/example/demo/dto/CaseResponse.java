package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CaseResponse {
    private UUID id;
    private String name;
    private Boolean due;
    private LocalDateTime created_at;
    private UUID customer_id;
}
