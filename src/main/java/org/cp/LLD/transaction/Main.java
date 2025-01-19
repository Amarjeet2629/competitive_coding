package org.cp.LLD.transaction;

import org.cp.LLD.transaction.entity.Transaction;
import org.cp.LLD.transaction.service.TransactionManager;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String ...args){
        TransactionManager transactionManager = new TransactionManager(
                new ArrayList<>(
                        Arrays.asList(
                                new Transaction("1", 10, 30),
                                new Transaction("2", 30, 100),
                                new Transaction("3", 70, 200),
                                new Transaction("4", 100, 1)
                        )
                )
        );

        System.out.println(transactionManager.getMaxFee(100));
        System.out.println(transactionManager.getMaxFeeDP(100));
    }
}
