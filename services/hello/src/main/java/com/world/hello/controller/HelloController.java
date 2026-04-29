package com.service.hello_world.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/world-hello")
    public String hello(@RequestHeader("X-Correlation-Id") String correlationId) {
        log.info("received request with correlationId={}", correlationId)
        return "World, Hello!!";
    }
}