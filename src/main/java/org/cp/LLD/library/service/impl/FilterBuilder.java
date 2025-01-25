package org.cp.LLD.library.service.impl;

import org.cp.LLD.library.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterBuilder {
    List<Predicate<Book>> filters;

    public FilterBuilder(){
        this.filters = new ArrayList<>();
    }

    public void filterByBookId(int bookId){
        filters.add((book) -> book.getBookId() == bookId);
    }

    public void filterByAuthor(String author){
        filters.add((book -> book.getAuthors().contains(author)));
    }

    public void filterByPublisher(String publisher){
        filters.add((book -> book.getPublishers().contains(publisher)));
    }

    public List<Predicate<Book>> build(){
        return this.filters;
    }
}
