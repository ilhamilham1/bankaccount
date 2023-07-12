package com.bank.bankaccount.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction implements Serializable {
    private Date date;
    private double amount;
    private double balance;
    private String operation;

    public Transaction(Date date, double amount, double balance, String operation) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.operation = operation;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getOperation() {
        return operation;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
