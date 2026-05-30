package com.service.register.controller;

import com.service.register.dto.CreateUserRequest;
import com.service.register.dto.UserResponse;
import com.service.register.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserResponse create(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

}
