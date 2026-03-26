package com.paylet.paylet.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.paylet.paylet.entities.User;
import com.paylet.paylet.exceptions.UserAlreadyExistsException;
import com.paylet.paylet.models.RegisterUserRequest;
import com.paylet.paylet.models.RegisterUserResponse;
import com.paylet.paylet.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        if (repo.findByUsername(request.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException(request.getUsername());
        }

        User registeringUser = new User(request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getName());

        User registeredUser = repo.save(registeringUser);

        return new RegisterUserResponse(registeredUser.getId(),
                registeredUser.getUsername(),
                registeredUser.getName());
    }
}
