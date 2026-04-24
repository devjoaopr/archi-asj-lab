package com.archi.tests.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class testController {
    @GetMapping("/hello")
    public String SayHello() {
        return "Hello World";
    }
}