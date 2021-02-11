package com.company.Modules.Library;

import com.company.Modules.Book;
import com.company.Modules.User;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Prints {
    LibraryData libraryData = LibraryData.getInstance();

    //----PRINTS
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    //----

    public Prints() {
    }

    public void searchByTitle(String title) {
        List<Book> searchByTitle = libraryData.getBookList().stream()
                .filter(book -> book.getTitle().toUpperCase().contains(title.toUpperCase()))
                .collect(Collectors.toList());
        if (searchByTitle.size() > 0) {
            searchByTitle.forEach(book -> System.out.printf(
                    YELLOW + "Title: " + RESET + "%s " + YELLOW + "Author: " + RESET + "%s " +
                            YELLOW + "Year: " + RESET + "%d " + YELLOW + "Description: " + RESET + "%s%n",
                    book.getTitle(), book.getAuthor(), book.getYear(), book.getDescription()));
            System.out.println(" ");
        } else {
            System.out.println("The book isn't in the library.\n");
        }
    }

    public void searchByAuthor(String author) {
        List<Book> searchByAuthor = libraryData.getBookList().stream()
                .filter(book -> book.getAuthor().toUpperCase().contains(author.toUpperCase()))
                .collect(Collectors.toList());
        if (searchByAuthor.size() > 0) {
            searchByAuthor.forEach(book -> System.out.printf(
                    YELLOW + "Title: " + RESET + "%s " + YELLOW + "Author: " + RESET + "%s " +
                            YELLOW + "Year: " + RESET + "%d " + YELLOW + "Description: " + RESET + "%s%n",
                    book.getTitle(), book.getAuthor(), book.getYear(), book.getDescription()));
            System.out.println(" ");
        } else {
            System.out.println("The book isn't in the library.\n");
        }
    }

    public void sortByTitle() {
        Comparator<Book> compareByTitle = Comparator.comparing(Book::getTitle);
        libraryData.getBookList().sort(compareByTitle);
        for (Book book : libraryData.getBookList()) {
            System.out.println(book.toString());
            System.out.println(" ");
        }
    }

    public void sortByAuthor() {
        Comparator<Book> compareByAuthor = Comparator.comparing(Book::getAuthor);
        libraryData.getBookList().sort(compareByAuthor);
        for (Book book : libraryData.getBookList()) {
            System.out.println(book.toString());
            System.out.println(" ");
        }
    }

    public void showAllBook() {
        if (libraryData.getBookList().size() > 0) {
            libraryData.getBookList().forEach(book -> System.out.println(book.toString()));
            System.out.println(" ");
        } else {
            System.out.println("There are no books in the library.\n");
        }
    }

    public void pAllBooksOfUser(String username) {

        List<User> userCheck;
        userCheck = libraryData.getUsers()
                .stream()
                .filter(user -> username.equals(user.getUsername()))
                .collect(Collectors.toList());
        if (userCheck.size() > 0) {
            System.out.println(userCheck.get(0).getMyBorrowedBooks());
        } else {
            System.out.println("Username does not exist.");
        }

    }

}
