package com.itau.transactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionServiceTest {

    private TransactionService transactionService;

    @BeforeEach
    public void setUp() {
        transactionService = new TransactionService();
    }

    @Test
    public void testProcessTransaction() {

        Transaction transaction = new Transaction(1, 100.0);

        transactionService.processTransaction(transaction);

        TransactionStats stats = transactionService.calculateStatistics();
        assertEquals(100.0, stats.getTotalAmount());
        assertEquals(1, stats.getTransactionCount());
    }
}
