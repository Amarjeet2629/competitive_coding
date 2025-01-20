package org.cp.LLD.cursorPagination.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Transaction {
    int id;
    BigDecimal amount;
    BigDecimal fee;
    TransactionType transactionType;
    LocalDateTime timestamp;

    public Transaction(int id, BigDecimal amount, BigDecimal fee, TransactionType transactionType, LocalDateTime timestamp) {
        this.id = id;
        this.amount = amount;
        this.fee = fee;
        this.transactionType = transactionType;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Long getTimestamp() {
        Instant instant = timestamp.atZone(ZoneId.systemDefault()).toInstant();
        return instant.getEpochSecond();
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", fee=" + fee +
                ", transactionType='" + transactionType + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
