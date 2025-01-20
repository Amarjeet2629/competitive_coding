package org.cp.LLD.cursorPagination.service;

import org.cp.LLD.cursorPagination.entity.ResponseData;
import org.cp.LLD.cursorPagination.entity.Transaction;
import org.cp.LLD.cursorPagination.repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class CursorPagination {
    IRepository<Transaction> transactionRepository = null;

    public CursorPagination(IRepository<Transaction> transactionRepository){
        this.transactionRepository = transactionRepository;
    }


    //no filter for now
    public ResponseData<Transaction> fetchPage(int limit, Long cursor){
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
}
