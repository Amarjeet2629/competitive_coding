package org.cp.LLD.library.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    String userId;
    String name;
    List<Book> borrowedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public User(String userId){
        this.userId = userId;
        borrowedBooks = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        this.borrowedBooks.add(book);
    }
}
