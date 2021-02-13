package com.company.Modules.Library;

import com.company.Modules.Book;
import com.company.Modules.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class UserMethods {
    Scanner input = new Scanner(System.in);
    LibraryData libraryData = LibraryData.getInstance();
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public UserMethods() {
    }

    public void borrowBook(User user) {

        System.out.println("Which book would you like to borrow?\nInput the title.\n");
        String title = input.nextLine();
        List<Book> bookToBorrow = libraryData.getAvailableBooks()
                .stream()
                .filter(book -> title.equalsIgnoreCase(book.getTitle()))
                .collect(Collectors.toList());
        if (bookToBorrow.size() > 0) {
            libraryData.changeFromAvailableToBorrowed(bookToBorrow.get(0));
            bookToBorrow.get(0).setCurrentLender(user.getUsername());
            user.addToBorrowedBooks(bookToBorrow.get(0));

            bookToBorrow.get(0).setBorrowDate(LocalDate.now());
            bookToBorrow.get(0).setReturnDate();
            System.out.println("Date borrowed: " + bookToBorrow.get(0).getBorrowDate());
            System.out.println("Return Date: " + bookToBorrow.get(0).getReturnDate());
        } else {
            System.out.println("The book isn't available.\n");
        }
    }

    public void returnBook(User user) {

        System.out.println("Which book would you like to return?\nInput the title.\n");
        String title = input.nextLine();
        List<Book> returnToBook = libraryData.getBorrowedBooks().stream()
                .filter(book -> title.equalsIgnoreCase(book.getTitle()))
                .collect(Collectors.toList());
        if (returnToBook.size() > 0) {
            libraryData.changeFromBorrowedToAvailable(returnToBook.get(0));
            returnToBook.get(0).setCurrentLender(null);
            user.removeFromBorrowedBooks(returnToBook.get(0));
        } else {
            System.out.println("The book isn't available.\n");
        }

    }

    public void sendReminder(User user) {

        user.getMyBorrowedBooks().stream().
                filter(book -> book.getReturnDate().isBefore(LocalDate.now())).
                forEach(book -> System.out.printf(RED + "Return overdue: %s%n", book.getTitle() + RESET));
        System.out.println(" ");

    }


}
