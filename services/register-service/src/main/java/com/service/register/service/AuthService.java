package com.service.register.service;

import com.service.register.dto.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
