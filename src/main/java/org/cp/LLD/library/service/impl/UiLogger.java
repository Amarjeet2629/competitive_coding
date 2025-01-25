package org.cp.LLD.library.service.impl;

import org.cp.LLD.library.models.Book;
import org.cp.LLD.library.service.IObserver;

public class UiLogger implements IObserver {
    @Override
    public void emitFilterResult(Book book) {
        System.out.print("Book Copy: " + book.getBookCopyId() + " "
                + book.getBookId() + " " + book.getTitle() + " " + String.join(",", book.getAuthors())
                + " " + String.join(",", book.getPublishers()));

        if(book.getRackNumber() == -1){
            System.out.print(" borrowed by: " + book.getBorrower().getUserId() + " dueDate: " + book.getDueDate());
        }

        System.out.println();
    }

    @Override
    public void invalidSearch(String message) {
        System.out.println(message);
    }

    @Override
    public void informationMessage(String message) {
        System.out.println(message);
    }
}
