package com.service.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CustomerResponse {
    private UUID id;
    private String username;
    private Integer age;
    private String cpf;

}
