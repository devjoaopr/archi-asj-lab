package com.service.customer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {
    private String username;
    private String cpf;
    private Integer age;
}
