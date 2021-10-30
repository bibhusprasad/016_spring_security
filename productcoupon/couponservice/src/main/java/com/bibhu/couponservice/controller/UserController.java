package com.bibhu.couponservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bibhu.couponservice.model.Users;
import com.bibhu.couponservice.repos.UsersRepo;
import com.bibhu.couponservice.security.SecurityService;

@Controller
public class UserController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(final String email, final String password){
        final boolean loginResponse = this.securityService.login(email, password);
        if(loginResponse){
            return "index";
        }else{
            return "login";
        }
    }

    @GetMapping("/showRegistration")
    public String showRegistrationPage(){
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String register(final Users users){
        users.setPassword(this.passwordEncoder.encode(users.getPassword()));
        this.usersRepo.save(users);
        return "login";
    }
}
