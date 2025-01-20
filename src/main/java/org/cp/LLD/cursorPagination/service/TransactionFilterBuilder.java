package org.cp.LLD.cursorPagination.service;

import org.cp.LLD.cursorPagination.entity.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TransactionFilterBuilder {
    private final List<Predicate<Transaction>> listOfFilters = new ArrayList<>();

    public TransactionFilterBuilder filterById(int id){
        listOfFilters.add((transaction -> transaction.getId() == id));
        return this;
    }

    public TransactionFilterBuilder filterByAmountLessThan(BigDecimal bigDecimal){
        listOfFilters.add((transaction -> transaction.getAmount().compareTo(bigDecimal) < 0));

        return this;
    }

    public TransactionFilterBuilder filterByAmountGreaterThan(BigDecimal bigDecimal){
        listOfFilters.add((transaction -> transaction.getAmount().compareTo(bigDecimal) > 0));

        return this;
    }

    public TransactionFilterBuilder filterByTimestampLessThan(Long timestamp){
        listOfFilters.add((transaction -> transaction.getTimestamp() < timestamp));

        return this;
    }

    public TransactionFilterBuilder filterByTimestampGreaterThan(Long timestamp){
        listOfFilters.add((transaction -> transaction.getTimestamp() > timestamp));
        return this;
    }

    public List<Predicate<Transaction>> build(){
        return listOfFilters;
    }


}
