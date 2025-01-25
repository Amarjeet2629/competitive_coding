package org.cp.LLD.library.service;

import org.cp.LLD.library.models.Book;
import org.cp.LLD.library.models.Status;
import org.cp.LLD.library.models.User;
import org.cp.LLD.library.repository.IRepository;
import org.cp.LLD.library.repository.impl.BookRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class BookService {
    private final IRepository<Book, Integer> bookRepository;
    IObservable eventNotifier;

    public BookService(IObservable eventNotifier){
        this.bookRepository = new BookRepository();
        this.eventNotifier = eventNotifier;
    }

    public Book addBook(int bookId, String title, String authors, String publishers, String bookCopyId, int rackNumber){
        List<String> publishersList = Arrays.stream(publishers.split(",")).toList();
        List<String> authorsList = Arrays.stream(authors.split(",")).toList();

        Book book = new Book(bookId, title, authorsList, publishersList, bookCopyId, Status.AVAILABLE, rackNumber);
        bookRepository.add(book);

        return book;
    }

    public void updateBookStatusAndRackNumber(String bookCopyId, Status newStatus, int newRackNumber, User user, String dueDate){
        Book book = ((BookRepository) bookRepository).getBookByCopyId(bookCopyId);

        book.setStatus(newStatus);
        book.setRackNumber(newRackNumber);
        book.setBorrower(user);
        book.setDueDate(dueDate);

        bookRepository.update(book);
    }

    public Book getAvailableBooksById(int bookId){
        List<Book> availableBooks = new ArrayList<>(this.bookRepository.getAll().stream()
                .filter(book -> book.getBookId() == bookId &&
                        book.getStatus() != Status.BORROWED).toList());

        availableBooks.sort((Book book1, Book book2) -> book1.getRackNumber() - book2.getRackNumber());

        if(availableBooks.isEmpty()) {
            eventNotifier.invalidSearch("Not available");
            return null;
        }

        return availableBooks.get(0);
    }

    public Book getAvailableBookByBookCopyId(String bookCopyId){
        Book book =  ((BookRepository) bookRepository).getBookByCopyId(bookCopyId);
        if(book == null){
            eventNotifier.invalidSearch("Invalid Book Copy ID");
        }

        return book;
    }

    public Book getBookByBookCopyId(String bookCopyId){
        return ((BookRepository)bookRepository).getBookByCopyId(bookCopyId);
    }

    public void deleteBook(Book book){
        eventNotifier.informationMessage("Removed book copy: " + book.getBookCopyId() + " from rack :" + book.getRackNumber());
        bookRepository.delete(book);
    }

    public boolean isValidBookId(int bookId){
       List<Book> books =  bookRepository.getAll();

       for(Book book : books){
           if(book.getBookId() == bookId) return true;
       }

       eventNotifier.invalidSearch("Invalid Book ID");
       return false;
    }

    public boolean isValidBookCopyId(String bookCopyId){
        List<Book> books =  bookRepository.getAll();

        for(Book book : books){
            if(book.getBookCopyId().equals(bookCopyId)) return true;
        }

        eventNotifier.invalidSearch("Invalid Book Copy ID");
        return false;
    }

    public boolean isBookCopyIdAvailableForBorrow(String bookCopyId){
        for(Book book: this.bookRepository.getAll()){
            if(book.getBookCopyId().equals(bookCopyId) && book.getStatus().equals(Status.BORROWED)){
                eventNotifier.invalidSearch("Invalid Book Copy ID");

                return false;
            }
        }

        return true;
    }

    public void search(List<Predicate<Book>> filters){
        for(Book book: bookRepository.getAll()){
            boolean isMatch = filters.stream().anyMatch(filter -> filter.test(book));
            if(isMatch){
                eventNotifier.emitFilterResult(book);
            }
        }
    }
}
