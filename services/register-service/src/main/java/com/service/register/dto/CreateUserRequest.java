package com.service.register.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateUserRequest {

    private String username;
    private String email;
    private String password;
    private String role;
}
