package com.gateway.boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
    @GetMapping("/test")
    public ResponseEntity<String> fallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("this service is unavailable temporarily, try again later");
    }
}
