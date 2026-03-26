package com.paylet.paylet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paylet.paylet.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
