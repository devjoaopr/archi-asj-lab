package com.gateway.boot.dto;

public record CustomerResponse(
        String id,
        String name,
        String email
) {
}

