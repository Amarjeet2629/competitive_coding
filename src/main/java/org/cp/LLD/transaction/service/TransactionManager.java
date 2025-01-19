package org.cp.LLD.transaction.service;

import org.cp.LLD.transaction.entity.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TransactionManager {
    List<Transaction> transactionList;

    public TransactionManager(List<Transaction> transactionList){
        this.transactionList = transactionList;
    }

    public int getMaxFee(int blockSize){
        PriorityQueue<Transaction> transactions = new PriorityQueue<>(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return (int) (-(1.0 * o1.getFee()) / o1.getSize() + (1.0 * o2.getFee() / o2.getSize()));
            }
        });


        transactions.addAll(transactionList);

        int feeValue = 0;
        int accumulatedBlockSize = 0;
        while(accumulatedBlockSize < blockSize){
            if(transactions.isEmpty()) break;

            if(transactions.peek().getSize() + accumulatedBlockSize > blockSize) break;
            Transaction transaction = transactions.poll();
            assert transaction != null;
            accumulatedBlockSize += transaction.getSize();
            feeValue +=  transaction.getFee();
        }

        return feeValue;
    }

    public int getMaxFeeDP(int blockSize){
        int m = transactionList.size();
        int[][] dp = new int[m][blockSize + 1];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < blockSize + 1; j++){
                dp[i][j] = 0;
            }
        }

        if(transactionList.get(0).getSize() <= blockSize)
            dp[0][transactionList.get(0).getSize()] = transactionList.get(0).getFee();

        for(int i = 1; i < m; i++){
            for(int j = 0; j < blockSize + 1; j++){
                if(j - transactionList.get(i).getSize() >= 0){
                    dp[i][j] = Math.max(dp[i-1][j - transactionList.get(i).getSize()] + transactionList.get(i).getFee(), dp[i-1][j]);
                }
            }
        }

        return dp[m - 1][blockSize];
    }
}
