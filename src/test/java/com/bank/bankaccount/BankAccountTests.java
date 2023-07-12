package com.bank.bankaccount;

import com.bank.bankaccount.model.Transaction;
import com.bank.bankaccount.service.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BankAccountTests {

    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount() ;
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(100.0);
        assertEquals(100.0, bankAccount.getBalance());

        List<Transaction> transactionHistory = bankAccount.getTransactionHistory();
        assertEquals(1, transactionHistory.size());

        Transaction transaction = transactionHistory.get(0);
        assertEquals(100.0, transaction.getAmount());
        assertEquals("DEPOSIT", transaction.getOperation());
    }

    @Test
    public void testWithdraw() {
        bankAccount.deposit(100.0);
        bankAccount.withdraw(50.0);
        assertEquals(50.0, bankAccount.getBalance());

        List<Transaction> transactionHistory = bankAccount.getTransactionHistory();
        assertEquals(2, transactionHistory.size());

        Transaction withdrawalTransaction = transactionHistory.get(1);
        assertEquals(-50.0, withdrawalTransaction.getAmount());
        assertEquals("WITHDRAWAL", withdrawalTransaction.getOperation());
    }
}
