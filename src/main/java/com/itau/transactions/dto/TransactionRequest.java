package com.itau.transactions.dto;

import java.math.BigDecimal;

public class TransactionRequest {
    private BigDecimal amount;
    private String timestamp;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

