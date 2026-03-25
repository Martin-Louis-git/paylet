package com.paylet.paylet.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_wallet_id", nullable = false)
    private Wallet senderWallet;

    @ManyToOne
    @JoinColumn(name = "receiver_wallet_id", nullable = false)
    private Wallet receiverWallet;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime time;

    @NotNull
    @Column(nullable = false)
    private BigDecimal amount;

    public Transaction() {
    }

    public Transaction(Wallet senderWallet, Wallet receiverWallet,
            LocalDateTime time, BigDecimal amount) {
        this.senderWallet = senderWallet;
        this.receiverWallet = receiverWallet;
        this.time = time;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Wallet getSenderWallet() {
        return senderWallet;
    }

    public Wallet getReceiverWallet() {
        return receiverWallet;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
