package com.company.Modules;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends Person implements Serializable {


    @Serial
    private static final long serialVersionUID = 6897230677316227865L;
    List<Book> myBorrowedBooks = new ArrayList();

    public User() {
    }

    //----PRINTS
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    //----

    public List<Book> getMyBorrowedBooks() {
        return myBorrowedBooks;
    }

    public void addToBorrowedBooks(Book book) {
        myBorrowedBooks.add(book);
        System.out.println(book);
    }

    public void removeFromBorrowedBooks(Book book) {
        int index = -1;
        for (Book borrowedBook : myBorrowedBooks) {
            if (book.getTitle().equals(borrowedBook.getTitle())) {
                index = myBorrowedBooks.indexOf(borrowedBook);
            }
        }
        if (index != -1) {

            myBorrowedBooks.remove(index);
            System.out.println(GREEN + "[ Book returned ]" + RESET);
            System.out.println(" ");
        } else {
            System.out.println(RED + "[ Book not found ]" + RESET);
            System.out.println(" ");
        }

    }

    public void printBorrowedBooks() {
        if (myBorrowedBooks.size() > 0) {
            myBorrowedBooks.forEach(book -> System.out.printf(YELLOW + "Title: " + RESET + "%s  " + YELLOW + "Return date: " + RESET + "%s  " + YELLOW + "Pending days to return: "
                    + RESET + "%s%n", book.getTitle(), book.getReturnDate(), book.pendingReturndays(book)));
            System.out.println(" ");
        } else {
            System.out.println("You haven't borrowed any books yet.");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
