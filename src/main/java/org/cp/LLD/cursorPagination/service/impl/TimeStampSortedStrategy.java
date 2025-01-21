package org.cp.LLD.cursorPagination.service.impl;

import org.cp.LLD.cursorPagination.entity.SortingOrder;
import org.cp.LLD.cursorPagination.entity.Transaction;
import org.cp.LLD.cursorPagination.service.ITransactionSortingStrategy;

import java.util.List;

public class TimeStampSortedStrategy implements ITransactionSortingStrategy {
    @Override
    public List<Transaction> getSortedTransactionData(List<Transaction> transactionList, SortingOrder sortingOrder) {
        if(sortingOrder == SortingOrder.ASC){
            transactionList.sort((Transaction a, Transaction b) -> Long.compare(a.getTimestamp(),  b.getTimestamp()));
        } else {
            transactionList.sort((Transaction a, Transaction b) -> Long.compare(b.getTimestamp(),  a.getTimestamp()));

        }

        return transactionList;
    }
}
