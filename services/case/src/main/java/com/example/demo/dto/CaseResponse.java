package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class CaseResponse {
    private UUID id;
    private String name;
    private Boolean due;
    private LocalDateTime created_at;

    public CaseResponse(UUID id, String name, Boolean due, LocalDateTime created_at) {
        this.id = id;
        this.name = name;
        this.due = due;
        this.created_at = created_at;
    }
}
