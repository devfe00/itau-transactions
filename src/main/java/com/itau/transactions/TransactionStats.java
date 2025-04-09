package com.itau.transactions;

public class TransactionStats {

    private double totalAmount;
    private long transactionCount;

    public TransactionStats(double totalAmount, long transactionCount) {
        this.totalAmount = totalAmount;
        this.transactionCount = transactionCount;
    }


    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(long transactionCount) {
        this.transactionCount = transactionCount;
    }
}
