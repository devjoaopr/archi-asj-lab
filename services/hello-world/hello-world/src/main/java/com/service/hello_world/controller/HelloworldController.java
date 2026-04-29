package com.service.hello_world.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloworldController {
    private static final Logger log = LoggerFactory.getLogger(HelloworldController.class);

    @GetMapping("/hello")
    public String hello(@RequestHeader("X-Correlation-Id") String correlationId) {
        log.info("Received request with correlationId={}", correlationId);
        return "Hello World !";
    }
}