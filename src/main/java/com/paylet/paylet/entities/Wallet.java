package com.paylet.paylet.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @SuppressWarnings("FieldMayBeFinal")
    @OneToMany(mappedBy = "senderWallet")
    private List<Transaction> outgoingTransactions = new ArrayList<Transaction>();

    @SuppressWarnings("FieldMayBeFinal")
    @OneToMany(mappedBy = "receiverWallet")
    private List<Transaction> incomingTransactions = new ArrayList<Transaction>();

    public Wallet() {
    }

    public Wallet(BigDecimal balance, Currency currency, User user) {
        this.balance = balance;
        this.currency = currency;
        this.user = user;
    }

    public List<Transaction> getOutgoingTransactions() {
        return outgoingTransactions;
    }

    public List<Transaction> getIncomingTransactions() {
        return incomingTransactions;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public User getUser() {
        return user;
    }
}
