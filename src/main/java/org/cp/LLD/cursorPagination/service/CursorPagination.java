package org.cp.LLD.cursorPagination.service;

import org.cp.LLD.cursorPagination.entity.*;
import org.cp.LLD.cursorPagination.interfaces.IPagination;
import org.cp.LLD.cursorPagination.repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class CursorPagination implements IPagination<Transaction> {
    IRepository<Transaction> transactionRepository = null;
    ITransactionSortingStrategy transactionSortingStrategy;

    public CursorPagination(IRepository<Transaction> transactionRepository, ITransactionSortingStrategy transactionSortingStrategy){
        this.transactionRepository = transactionRepository;
        this.transactionSortingStrategy = transactionSortingStrategy;
    }


    private ResponseData<Transaction> fetchPage(int limit, Long cursor){
        List<Transaction> data = new ArrayList<>(transactionRepository.getDataAfterCursor(cursor, limit));
        if(data.size() <= limit){
            return new ResponseData<>(data, data.get(data.size() - 1).getTimestamp(), false, cursor);
        } else {
            return new ResponseData<>(data.subList(0, data.size() - 1), data.get(data.size() - 1).getTimestamp(), true, cursor);
        }


    }

    public ResponseData<Transaction> fetchPage(int limit, Long cursor, Filter<Transaction> filters){
        ResponseData<Transaction> transactionResponseData = fetchPage(limit, cursor);
        transactionResponseData.setData(transactionSortingStrategy.getSortedTransactionData(transactionResponseData.getData(), SortingOrder.DESC));

        if(filters == null) return transactionResponseData;

        List<Transaction> filteredData = transactionResponseData.
                getData()
                .stream()
                .filter(
                        (transaction -> filters.getFilterType() == FilterType.AND ?
                                filters.getFilters().stream().allMatch((filter) -> filter.test(transaction)) :
                                filters.getFilters().stream().anyMatch((filter -> filter.test(transaction))))
        ).toList();

        transactionResponseData.setData(filteredData);
        return transactionResponseData;
    }
}
