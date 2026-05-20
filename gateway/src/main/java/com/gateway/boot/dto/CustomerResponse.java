package com.gateway.boot.dto;

import java.util.UUID;

public record CustomerResponse(
        UUID id,
        String username,
        Integer age,
        String cpf
) {
}
