package org.cp.LLD.cursorPagination;

import org.cp.LLD.cursorPagination.entity.*;
import org.cp.LLD.cursorPagination.repository.IRepository;
import org.cp.LLD.cursorPagination.repository.TransactionRepository;
import org.cp.LLD.cursorPagination.service.CursorPagination;
import org.cp.LLD.cursorPagination.service.ITransactionSortingStrategy;
import org.cp.LLD.cursorPagination.service.TransactionFilterBuilder;
import org.cp.LLD.cursorPagination.service.impl.FeeSortedStrategy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class APIDriver {
    public static void main(String ...args){
        IRepository<Transaction> transactionIRepository = TransactionRepository.getInstance();
        ITransactionSortingStrategy transactionSortingStrategy = new FeeSortedStrategy();
        CursorPagination cursorPagination = new CursorPagination(transactionIRepository, transactionSortingStrategy);

        //Populate Data for 100000 entries
        for(int i = 0; i < 100; i++){
            transactionIRepository.addData(new Transaction(0,
                    new BigDecimal(String.valueOf(Math.random() * 100)),
                    new BigDecimal(String.valueOf(Math.random() * 10)),
                    Math.random() >= 0.5 ? TransactionType.CREDIT : TransactionType.DEBIT,
                    LocalDateTime.now().minusHours(100000 - i)));
        }

        //Fetch Data without filter
        ResponseData<Transaction> responseData = null;

        while(responseData == null || responseData.isHasMore()){
            responseData = cursorPagination.fetchPage(7, responseData == null ? null : responseData.getCursor(), null);
            printData(responseData.getData());
        }

        //Fetch data with filters
        System.out.println("Printing Filtered data");
        responseData = null;

        TransactionFilterBuilder transactionFilterBuilder = new TransactionFilterBuilder();
        transactionFilterBuilder
                .filterByAmountGreaterThan(new BigDecimal(10))
                .filterByAmountLessThan(new BigDecimal(50))
                .filterByTimestampLessThan(System.currentTimeMillis() - 100000000000L);

        Filter<Transaction> filter = new Filter<>(FilterType.AND, transactionFilterBuilder.build());

        while(responseData == null || responseData.isHasMore()){
            responseData = cursorPagination.fetchPage(7, responseData == null ? null : responseData.getCursor(), filter);
            printData(responseData.getData());
        }
    }

    private static void printData(List<Transaction> transactions){
        for(Transaction transaction : transactions){
            System.out.println(transaction);
        }

        System.out.println("-------------------------------");
    }
}
