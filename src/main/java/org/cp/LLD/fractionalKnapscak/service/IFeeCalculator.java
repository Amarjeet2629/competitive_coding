package org.cp.LLD.fractionalKnapscak.service;

import org.cp.LLD.fractionalKnapscak.models.Transaction;

import java.util.List;

public interface IFeeCalculator {
    public double getFee(List<Transaction> transactionList, double blockSize);
}
