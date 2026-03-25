package com.paylet.paylet.services;

import org.springframework.stereotype.Service;

import com.paylet.paylet.repository.WalletRepository;

@Service
public class WalletService {

    @SuppressWarnings("unused")
    private final WalletRepository repo;

    public WalletService(WalletRepository repo) {
        this.repo = repo;
    }

}
