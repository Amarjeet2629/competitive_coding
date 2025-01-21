package org.cp.LLD.cursorPagination.service;


import org.cp.LLD.cursorPagination.entity.SortingOrder;
import org.cp.LLD.cursorPagination.entity.Transaction;

import java.util.List;

public interface ITransactionSortingStrategy {
    public List<Transaction> getSortedTransactionData(List<Transaction> transactions, SortingOrder sortingOrder);
}
