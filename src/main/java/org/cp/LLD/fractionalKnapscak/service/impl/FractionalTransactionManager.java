package org.cp.LLD.fractionalKnapscak.service.impl;

import org.cp.LLD.fractionalKnapscak.models.Transaction;
import org.cp.LLD.fractionalKnapscak.service.IFeeCalculator;

import java.util.List;
import java.util.PriorityQueue;

public class FractionalTransactionManager implements IFeeCalculator {
    @Override
    public double getFee(List<Transaction> transactionList, double blockSize) {
        PriorityQueue<Transaction> orderPQ  = new PriorityQueue<>((transaction1, transaction2) ->
                (int) (transaction2.getFee() * transaction1.getSize() - transaction1.getFee() * transaction2.getSize()));

        orderPQ.addAll(transactionList);
        double amount = 0;

        while(blockSize > 0 && !orderPQ.isEmpty()){
            Transaction transaction = orderPQ.poll();
            double valueCanTake = Math.min(transaction.getSize(), blockSize);
            blockSize -= valueCanTake;
            amount += (transaction.getFee() * valueCanTake) / transaction.getSize();
        }

        return amount;
    }
}
