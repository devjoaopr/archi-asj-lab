package com.service.customer.dto;

import java.util.UUID;

public class CustomerResponse {
    private UUID id;
    private String username;
    private Integer age;
    private String cpf;

    public CustomerResponse(UUID id, String username, Integer age, String cpf) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.cpf = cpf;
    }
}
