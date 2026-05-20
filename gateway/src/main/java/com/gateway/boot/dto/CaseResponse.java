package com.gateway.boot.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CaseResponse(
        UUID id,
        String name,
        Boolean due,
        LocalDateTime created_at,
        UUID customer_id
) {
}