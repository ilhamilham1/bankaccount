package com.bank.bankaccount.service;

import com.bank.bankaccount.model.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {
    private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount() {
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            Transaction depositTransaction = new Transaction(new Date(), amount, balance, "DEPOSIT");
            transactionHistory.add(depositTransaction);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            Transaction withdrawalTransaction = new Transaction(new Date(), -amount, balance, "WITHDRAWAL");
            transactionHistory.add(withdrawalTransaction);
        }
    }
}
