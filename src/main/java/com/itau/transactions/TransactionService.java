package com.itau.transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();

    public void processTransaction(Transaction transaction) {

        transactions.add(transaction);
    }

    public TransactionStats calculateStatistics() {
        double totalAmount = 0;
        long transactionCount = transactions.size();

        for (Transaction transaction : transactions) {
            totalAmount += transaction.getAmount();
        }

        return new TransactionStats(totalAmount, transactionCount);
    }
}
