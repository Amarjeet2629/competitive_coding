package org.cp.LLD.cursorPagination.service;

import org.cp.LLD.cursorPagination.entity.Filter;
import org.cp.LLD.cursorPagination.entity.FilterType;
import org.cp.LLD.cursorPagination.entity.ResponseData;
import org.cp.LLD.cursorPagination.entity.Transaction;
import org.cp.LLD.cursorPagination.interfaces.IPagination;
import org.cp.LLD.cursorPagination.repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CursorPagination implements IPagination<Transaction> {
    IRepository<Transaction> transactionRepository = null;

    public CursorPagination(IRepository<Transaction> transactionRepository){
        this.transactionRepository = transactionRepository;
    }


    //no filter for now
    private ResponseData<Transaction> fetchPage(int limit, Long cursor){
        List<Transaction> data = new ArrayList<>();

        if(cursor == null){
            data.addAll(this.transactionRepository.getAllData().stream().limit(limit + 1).toList());
        } else {
            data.addAll(transactionRepository.getDataAfterCursor(cursor, limit));
        }

        if(data.size() <= limit){
            return new ResponseData<>(data, data.get(data.size() - 1).getTimestamp(), false);
        } else {
            return new ResponseData<>(data.subList(0, data.size() - 1), data.get(data.size() - 1).getTimestamp(), true);
        }
    }

    public ResponseData<Transaction> fetchPage(int limit, Long cursor, Filter<Transaction> filters){
        if(filters == null) return fetchPage(limit, cursor);

        ResponseData<Transaction> transactionResponseData = fetchPage(limit, cursor);

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

    private ResponseData<Transaction> constructDTO(List<Transaction> transactions, Long cursor, int limit){
        if(cursor == null){
            transactions.addAll(this.transactionRepository.getAllData().stream().limit(limit + 1).toList());
        } else {
            transactions.addAll(transactionRepository.getDataAfterCursor(cursor, limit));
        }

        if(transactions.size() <= limit){
            return new ResponseData<>(transactions, transactions.get(transactions.size() - 1).getTimestamp(), false);
        } else {
            return new ResponseData<>(
                    transactions.subList(0, transactions.size() - 1),
                    transactions.get(transactions.size() - 1).getTimestamp(),
                    true);
        }
    }
}
