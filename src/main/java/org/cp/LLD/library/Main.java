package org.cp.LLD.library;

import org.cp.LLD.library.models.Book;
import org.cp.LLD.library.service.FilterBuilder;
import org.cp.LLD.library.service.IObservable;
import org.cp.LLD.library.service.IObserver;
import org.cp.LLD.library.service.LibraryManager;
import org.cp.LLD.library.service.impl.EventNotifier;
import org.cp.LLD.library.service.impl.UiLogger;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String ...args){
        LibraryManager libraryManager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        IObservable eventNotifier = new EventNotifier();
        IObserver uiLogger = new UiLogger();

        eventNotifier.addObserver(uiLogger);

        while(true){
            String cmd = scanner.next();

            switch (cmd){
                case "create_library": {
                    int numberOfRacks = scanner.nextInt();

                    libraryManager.createLibrary(numberOfRacks, eventNotifier);
                    break;
                }

                case "add_book": {
                    int bookId = scanner.nextInt();
                    String title = scanner.next();
                    String authors = scanner.next();
                    String publishers = scanner.next();
                    String bookCopyIds = scanner.next();

                    libraryManager.addBook(bookId, title, authors, publishers, bookCopyIds);
                    break;
                }

                case "remove_book_copy": {
                    String bookCopyId = scanner.next();
                    libraryManager.removeBookCopy(bookCopyId);

                    break;
                }

                case "borrow_book": {
                    int bookId = scanner.nextInt();
                    String userId = scanner.next();
                    String dueDate = scanner.next();

                    libraryManager.borrowBook(bookId, userId, dueDate);
                    break;
                }

                case "borrow_book_copy": {
                    String bookCopyId = scanner.next();
                    String userId = scanner.next();
                    String dueDate = scanner.next();

                    libraryManager.borrowBook(bookCopyId, userId, dueDate);
                    break;
                }

                case "return_book_copy": {
                    libraryManager.returnBookCopy(scanner.next());
                    break;
                }

                case "print_borrowed":{
                    libraryManager.printBorrowed(scanner.next());
                    break;
                }

                case "search": {
                    String filterOn = scanner.next();
                    FilterBuilder filterBuilder = new FilterBuilder();

                    if(Objects.equals(filterOn, "book_id")){
                        filterBuilder.filterByBookId(scanner.nextInt());
                    } else if(Objects.equals(filterOn, "author_id")){
                        filterBuilder.filterByAuthor(scanner.next());
                    } else {
                        filterBuilder.filterByPublisher(scanner.next());
                    }

                    List<Predicate<Book>> filters = filterBuilder.build();
                    libraryManager.search(filters);

                    break;
                }

                case "exit":
                    return;

                default:
                    break;
            }
        }
    }
}
