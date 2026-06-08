package com.gateway.boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @RequestMapping(value = "/customer", method = {
            RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,
    })
    public ResponseEntity<String> customerFallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Customer service unavailable");
    }

    @RequestMapping(value = "/user", method = {
            RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,
    })
    public ResponseEntity<String> userFallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Customer service unavailable");
    }

    @RequestMapping(value = "/register", method = {
            RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,
    })
    public ResponseEntity<String> registerFallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("register service unavailable");
    }

    @RequestMapping(value = "/case", method = {
            RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,
    })
    public ResponseEntity<String> caseFallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Case service unavailable");
    }
}
