package org.cp.LLD.library.service;

import org.cp.LLD.library.models.Book;
import org.cp.LLD.library.models.User;
import org.cp.LLD.library.repository.IRepository;
import org.cp.LLD.library.repository.impl.UserRepository;

public class UserService {
    IRepository<User, String> userRepository;
    IObservable eventNotifier;

    public UserService(IObservable eventNotifier){
        userRepository = new UserRepository();
        this.eventNotifier = eventNotifier;
    }

    public void createUser(String userId, String name){
        userRepository.add(new User(userId, name));
    }

    public void createUser(String userId){
        userRepository.add(new User(userId));
    }

    public void updateBookListForUser(String userId, Book book){
        User user = userRepository.getById(userId);
        user.addBorrowedBook(book);
        userRepository.update(user);
    }

    public void getBorrowedBooksForUser(String userId){
        User user  = userRepository.getById(userId);
        if(user == null) return;

        for(Book book: userRepository.getById(userId).getBorrowedBooks()){
            eventNotifier.informationMessage("Book Copy: " + book.getBookCopyId() + " due date: " + book.getDueDate());
        }

        userRepository.getById(userId);
    }

    public void removeBookFromBorrowedList(String userId, Book book){
        User user = userRepository.getById(userId);
        user.getBorrowedBooks().remove(book);
        userRepository.update(user);
    }

    public boolean isBorrowLimitExhausted(String userId){
        User user = userRepository.getById(userId);

        if(user.getBorrowedBooks().size() == 5){
            System.out.println("Overlimit");

            return true;
        }

        return false;
    }
}
