package com.paylet.paylet.models;

import jakarta.validation.constraints.NotBlank;

public class RegisterUserRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
