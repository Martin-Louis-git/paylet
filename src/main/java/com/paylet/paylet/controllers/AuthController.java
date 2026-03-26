package com.paylet.paylet.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paylet.paylet.models.RegisterUserRequest;
import com.paylet.paylet.models.RegisterUserResponse;
import com.paylet.paylet.services.AuthService;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/register")
    public RegisterUserResponse registerUser(@RequestBody RegisterUserRequest user) {
        return authService.registerUser(user);
    }
}
