package com.bibhu.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String displayWelcomeMessage() {
        return "Welcome to Spring boot app with Spring Security.";
    }
}
