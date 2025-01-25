package org.cp.LLD.library.repository.impl;

import org.cp.LLD.library.models.Book;
import org.cp.LLD.library.repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookRepository implements IRepository<Book, Integer> {
    List<Book> bookList;

    public BookRepository(){
        bookList = new ArrayList<>();
    }

    @Override
    public void add(Book book) {
        bookList.add(book);
    }

    @Override
    public Book getById(Integer bookId) {
        List<Book> listOfBooks = bookList.stream().filter(book -> book.getBookId() == bookId).toList();
        if(bookList.isEmpty()) return null;

        return listOfBooks.get(0);
    }


    @Override
    public void update(Book book) {
        for(int i = 0; i < bookList.size(); i++){
            if(Objects.equals(book.getBookCopyId(), bookList.get(i).getBookCopyId())){
                bookList.set(i, book);
                break;
            }
        }
    }

    @Override
    public List<Book> getAll() {
        return this.bookList;
    }

    @Override
    public void delete(Book book) {
        bookList.remove(book);
    }

    public Book getBookByCopyId(String bookCopyId){
        List<Book> books = bookList.stream().filter(book -> book.getBookCopyId().equals(bookCopyId)).toList();

        if(books.isEmpty()) return null;

        return books.get(0);
    }
}
