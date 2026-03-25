package com.paylet.paylet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paylet.paylet.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

}
