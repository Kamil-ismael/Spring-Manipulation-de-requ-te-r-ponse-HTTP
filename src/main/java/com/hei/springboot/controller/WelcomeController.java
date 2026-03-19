package com.hei.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeName(@RequestParam(required = false) String name) {
        if (name == null || name.isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("code 400 : name is required");
        }
        return ResponseEntity
                .ok("Welcome " + name + " !");
    }
}
