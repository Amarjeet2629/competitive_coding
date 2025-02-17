package org.cp.LLD.cursorPagination.repository;

import org.cp.LLD.cursorPagination.entity.Transaction;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository implements IRepository<Transaction> {
    private final List<Transaction> transactions = new ArrayList<>();
    private static int id = 0;
    private static volatile IRepository<Transaction> transactionRepository = null;

    private TransactionRepository(){ }

    public static IRepository<Transaction> getInstance(){
        if(transactionRepository == null){
            synchronized (TransactionRepository.class){
                if(transactionRepository == null){
                    transactionRepository = new TransactionRepository();
                }
            }
        }

        return transactionRepository;
    }


    @Override
    public void addData(Transaction data) {
        data.setId(id);
        id++;
        transactions.add(data);
    }

    @Override
    public void updateDate(Transaction data) {
        int id = data.getId();
        for(int i = 0; i < transactions.size(); i++){
            if(transactions.get(i).getId() == id){
                transactions.set(i, data);
                break;
            }
        }
    }

    @Override
    public Transaction findById(int id) {
        for(Transaction transaction : transactions){
            if(transaction.getId() == id) return transaction;
        }

        return null;
    }

    @Override
    public List<Transaction> getAllData() {
        return this.transactions.stream().toList();
    }

    @Override
    public List<Transaction> getDataAfterCursor(Long cursor, int limit) {
        if(cursor == null){
            return this.transactions.stream().limit(limit + 1).toList();
        }

        int entriesToSkip = findCursor(cursor);
        return this.transactions.stream().skip(entriesToSkip).limit(limit + 1).toList();
    }

    private int findCursor(Long cursor){
        for(int i = 0; i < transactions.size(); i++){
            if(transactions.get(i).getTimestamp() >= cursor){
                return i;
            }
        }

        return -1;
    }
}
