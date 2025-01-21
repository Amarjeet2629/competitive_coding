package org.cp.LLD.fractionalKnapscak.service.impl;

import org.cp.LLD.fractionalKnapscak.models.Transaction;
import org.cp.LLD.fractionalKnapscak.service.IFeeCalculator;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ParentChildTransactionManager implements IFeeCalculator {
    @Override
    public double getFee(List<Transaction> transactionList, double blockSize) {
        HashMap<Integer, Integer> nodeVsInDeg = new HashMap<>();
        HashMap<Integer, Transaction> idVsTransaction = new HashMap<>();

        for(Transaction transaction: transactionList){
            idVsTransaction.put(transaction.getId(), transaction);
            if(nodeVsInDeg.containsKey(transaction.getId())){
                nodeVsInDeg.put(transaction.getId(), 0);
            }

            for(Transaction childTransaction: transaction.getChildTransaction()){
                nodeVsInDeg.put(childTransaction.getId(), nodeVsInDeg.getOrDefault(childTransaction.getId(), 0) + 1);
            }
        }

        PriorityQueue<Transaction> transactionPriorityQueue = new PriorityQueue<>(
                (Transaction a, Transaction b) -> Double.compare(b.getFee() * a.getSize(), a.getFee() * b.getSize())
        );

        for(Integer key: nodeVsInDeg.keySet()){
            if(nodeVsInDeg.get(key) == 0){
                transactionPriorityQueue.add(idVsTransaction.get(key));
            }
        }

        double amount = 0;

        while(!transactionPriorityQueue.isEmpty() && blockSize > 0){
            Transaction transaction = transactionPriorityQueue.poll();
            double canTake = Math.min(blockSize, transaction.getSize());
            blockSize -= canTake;

            amount += (transaction.getFee() * canTake) / transaction.getSize();
            for(Transaction childTransaction: transaction.getChildTransaction()){
                int val = nodeVsInDeg.get(childTransaction.getId());
                val--;
                if(val == 0){
                    transactionPriorityQueue.add(idVsTransaction.get(childTransaction.getId()));
                }
            }
        }

        return amount;
    }
}
