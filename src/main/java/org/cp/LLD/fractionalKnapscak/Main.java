package org.cp.LLD.fractionalKnapscak;

import org.cp.LLD.fractionalKnapscak.models.Transaction;
import org.cp.LLD.fractionalKnapscak.service.IFeeCalculator;
import org.cp.LLD.fractionalKnapscak.service.impl.FractionalTransactionManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String ...args){
        //<1, 50.5, 200>, <2, 25.5, 100>, <3, 30.5, 120>, <4, 10.5, 50>, <5, 40.0, 150>
        List<Transaction> transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction(1, 50, 200),
                        new Transaction(2, 25, 100),
                        new Transaction(4, 30, 120),
                        new Transaction(3, 10, 50),
                        new Transaction(4, 40, 150)
        ));

        IFeeCalculator fractionFeeCal = new FractionalTransactionManager();
        System.out.println(fractionFeeCal.getFee(transactionList, 100.00));
    }
}
