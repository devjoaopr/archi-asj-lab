package com.service.register.service;

import com.service.register.dto.CreateUserRequest;
import com.service.register.dto.UserResponse;
import com.service.register.entity.User;
import com.service.register.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse create(CreateUserRequest request) {

        if (repository.existsByEmail((request.getEmail()))) {
            throw new IllegalArgumentException("CPF already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User saved = repository.save(user);

        return new UserResponse(
                saved.getUsername(),
                saved.getEmail(),
                saved.getPassword()
        );
    }
}
