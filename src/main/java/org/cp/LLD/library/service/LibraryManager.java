package org.cp.LLD.library.service;

import org.cp.LLD.library.models.Book;
import org.cp.LLD.library.models.Status;
import org.cp.LLD.library.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LibraryManager {
    UserService userService;
    BookService bookService;
    List<Book> racks;
    IObservable eventNotifier;


    public LibraryManager(){

    }

    public void createLibrary(int numberOfRacks, IObservable eventNotifier){
        this.racks = new ArrayList<>();
        userService = new UserService(eventNotifier);
        bookService = new BookService(eventNotifier);
        this.eventNotifier = eventNotifier;

        racks.add(null);
        for(int i = 1; i <= numberOfRacks; i++){
            racks.add(null);
        }

        eventNotifier.informationMessage("Created library with " + numberOfRacks +  " racks");
    }

    public void addBook(int bookId, String title, String authors, String publishers, String bookCopyIds){
        boolean isRacksAvailable = isRackAvailable(bookCopyIds.split(",").length);

        if(!isRacksAvailable){
            eventNotifier.informationMessage("Rack not available");
        } else {
            List<String> rackIds = new ArrayList<>();
            for(String bookCopyId: bookCopyIds.split(",")){
                for(int i = 1; i < racks.size(); i++){
                    if(racks.get(i) == null){
                        racks.set(i, bookService.addBook(bookId, title, authors, publishers, bookCopyId, i));
                        rackIds.add(String.valueOf(i));
                        break;
                    }
                }
            }

            eventNotifier.informationMessage("Added Book to racks: " + String.join(",", rackIds));
        }
    }

    public void removeBookCopy(String bookCopyId){
        Book book = bookService.getAvailableBookByBookCopyId(bookCopyId);

        if(book != null){
            racks.set(book.getRackNumber(), null);
            bookService.deleteBook(book);
        }
    }

    public void returnBookCopy(String bookCopyId){
       boolean isValidBookCopyId = bookService.isValidBookCopyId(bookCopyId);

       if(isValidBookCopyId){
           Book book = bookService.getBookByBookCopyId(bookCopyId);
           //remove book from user borrowed book
           userService.removeBookFromBorrowedList(book.getBorrower().getUserId(), book);
           //add book to rack
           int newRackNumber = getFirstAvailableRack();
           bookService.updateBookStatusAndRackNumber(bookCopyId, Status.AVAILABLE, newRackNumber, null, null);

           racks.set(newRackNumber, book);
           eventNotifier.informationMessage("Returned book copy " + bookCopyId + " and added to rack :" + newRackNumber);
       }
    }

    public void printBorrowed(String userId){
        userService.getBorrowedBooksForUser(userId);
    }

    public void borrowBook(String bookCopyId, String userId, String dueDate){
        userService.createUser(userId);

        if(!bookService.isValidBookCopyId(bookCopyId)
                || userService.isBorrowLimitExhausted(userId) ||
                !bookService.isBookCopyIdAvailableForBorrow(bookCopyId)){
            return;
        }

        Book book = bookService.getBookByBookCopyId(bookCopyId);
        int rackNumber = updateBookAndUserAfterBorrowing(userId, book, dueDate);

        System.out.println("Borrowed Book Copy from rack: " + rackNumber);
    }

    public void borrowBook(int bookId, String userId, String dueDate){
        userService.createUser(userId);

        if(!bookService.isValidBookId(bookId) ||
                bookService.getAvailableBooksById(bookId) == null){
            return;
        }

        if(userService.isBorrowLimitExhausted(userId)){
            return;
        }

        Book book = bookService.getAvailableBooksById(bookId);
        int rackNumber = updateBookAndUserAfterBorrowing(userId, book, dueDate);

        System.out.println("Borrowed Book from rack: " + rackNumber);
    }

    private int updateBookAndUserAfterBorrowing(String userId, Book book, String dueDate){
        User user = userService.userRepository.getById(userId);

        int rackNumber = book.getRackNumber();
        bookService.updateBookStatusAndRackNumber(book.getBookCopyId(), Status.BORROWED, -1, user, dueDate);
        racks.set(rackNumber, null);

        book = bookService.getBookByBookCopyId(book.getBookCopyId());
        user.addBorrowedBook(book);
        return rackNumber;
    }


    private Integer getFirstAvailableRack(){
        for(int i = 1; i < this.racks.size(); i++){
            if(racks.get(i) == null) return i;
        }

        return -1;
    }

    private boolean isRackAvailable(int bookCount){
        return racks.stream().mapToInt(rack -> rack == null ? 1 : 0).sum() - 1 >= bookCount;
    }


    public void search(List<Predicate<Book>> filters){
        bookService.search(filters);

    }
}
