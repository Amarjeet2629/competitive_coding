package org.cp.LLD.cursorPagination.service.impl;

import org.cp.LLD.cursorPagination.entity.SortingOrder;
import org.cp.LLD.cursorPagination.entity.Transaction;
import org.cp.LLD.cursorPagination.service.ITransactionSortingStrategy;

import java.math.BigDecimal;
import java.util.List;

public class FeeSortedStrategy implements ITransactionSortingStrategy {
    @Override
    public List<Transaction> getSortedTransactionData(List<Transaction> transactions, SortingOrder sortingOrder) {
        if(sortingOrder == SortingOrder.ASC){
            transactions.sort((Transaction a, Transaction b) -> a.getFee().compareTo(b.getFee()));
        } else {
            transactions.sort((Transaction a, Transaction b) -> b.getFee().compareTo(a.getFee()));
        }

        return transactions;
    }
}
