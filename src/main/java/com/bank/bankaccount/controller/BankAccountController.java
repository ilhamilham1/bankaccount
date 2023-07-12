package com.bank.bankaccount.controller;

import com.bank.bankaccount.model.Transaction;
import com.bank.bankaccount.service.BankAccount;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-account")
public class BankAccountController {
    private BankAccount bankAccount;

    public BankAccountController() {
        this.bankAccount = new BankAccount();
    }

    @PostMapping("/deposit")
    public void deposit(@RequestParam double amount) {
        bankAccount.deposit(amount);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestParam double amount) {
        bankAccount.withdraw(amount);
    }

    @GetMapping("/history")
    public List<Transaction> getTransactionHistory() {
        return bankAccount.getTransactionHistory();
    }
}
