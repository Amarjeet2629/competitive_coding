package org.cp.LLD.library.models;

import java.util.List;

public class Book {
    int bookId;
    String title;
    List<String> authors;
    List<String> publishers;
    String bookCopyId;
    Status status;
    int rackNumber;
    User borrower;
    String dueDate;

    public Book(int bookId, String title, List<String> authors, List<String> publishers, String bookCopyId, Status status, int rackNumber) {
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.publishers = publishers;
        this.bookCopyId = bookCopyId;
        this.status = status;
        this.rackNumber = rackNumber;
        this.borrower = null;
        this.dueDate = null;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }

    public Status getStatus() {
        return status;
    }

    public int getRackNumber() {
        return rackNumber;
    }

    public User getBorrower(){
        return this.borrower;
    }

    public void setRackNumber(int rackNumber) {
        this.rackNumber = rackNumber;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setBorrower(User borrower){
        this.borrower = borrower;
    }

    public String getDueDate(){
        return this.dueDate;
    }

    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }
}
