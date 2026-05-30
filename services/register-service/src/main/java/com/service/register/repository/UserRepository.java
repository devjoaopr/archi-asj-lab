package com.service.register.repository;

import com.service.register.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    boolean existsByEmail(String email);
}
