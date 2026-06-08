package com.service.register.service;

import com.service.register.dto.CreateUserRequest;
import com.service.register.dto.UserResponse;
import com.service.register.entity.Role;
import com.service.register.entity.User;
import com.service.register.repository.RoleRepository;
import com.service.register.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public UserResponse create(CreateUserRequest request) {

        if (repository.existsByEmail(((request.getEmail())))) {
            throw new IllegalArgumentException("Email already registered");
        }

        Role userRole = roleRepository
                .findByName("ROLE_USER")
                .orElseThrow(() ->
                        new RuntimeException("Role not found"));

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Set.of(userRole));

        User saved = repository.save(user);

        return new UserResponse(
                saved.getUsername(),
                saved.getEmail()
                );
    }
}
