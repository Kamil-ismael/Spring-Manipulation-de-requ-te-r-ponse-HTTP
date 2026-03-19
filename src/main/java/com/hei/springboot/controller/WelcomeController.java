package com.hei.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcomeName(@RequestParam(required = false) String name) {
        if(name == null || name.isEmpty()){
            return "Welcome spring boot";
        }
        return "Welcome " + name;
    }

}
