package org.cp.LLD.cursorPagination;

import org.cp.LLD.cursorPagination.entity.ResponseData;
import org.cp.LLD.cursorPagination.entity.Transaction;
import org.cp.LLD.cursorPagination.entity.TransactionType;
import org.cp.LLD.cursorPagination.repository.IRepository;
import org.cp.LLD.cursorPagination.repository.TransactionRepository;
import org.cp.LLD.cursorPagination.service.CursorPagination;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class APIDriver {
    public static void main(String ...args){
        IRepository<Transaction> transactionIRepository = TransactionRepository.getInstance();
        CursorPagination cursorPagination = new CursorPagination(transactionIRepository);

        //Populate Data for 100000 entries
        for(int i = 0; i < 100; i++){
            transactionIRepository.addData(new Transaction(0,
                    new BigDecimal(String.valueOf(Math.random() * 100)),
                    new BigDecimal(String.valueOf(Math.random() * 10)),
                    Math.random() >= 0.5 ? TransactionType.CREDIT : TransactionType.DEBIT,
                    LocalDateTime.now().minusHours(100000 - i)));
        }

        ResponseData<Transaction> responseData = null;

        while(responseData == null || responseData.isHasMore()){
            responseData = cursorPagination.fetchPage(7, responseData == null ? null : responseData.getCursor());
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
