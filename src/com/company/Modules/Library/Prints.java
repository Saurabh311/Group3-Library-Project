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
        String isfound = "Not Available";
        if (searchByTitle.size() > 0) {
            for (Book book : searchByTitle) {
                String found = "Not Availble";
                for (Book tempBook : libraryData.getAvailableBooks()) {
                    if (tempBook.getTitle().equals(book.getTitle())) {
                        found = "Available";
                    }
                }
                System.out.printf(YELLOW + "Title: " + RESET + "%s " + YELLOW + "Author: " + RESET + "%s " +
                                YELLOW + "Year: " + RESET + "%d " + YELLOW + "Description: " + RESET + "%s " + YELLOW + "Book Status: " + RESET +"%s%n",
                        book.getTitle(), book.getAuthor(), book.getYear(), book.getDescription(), found);
                System.out.println(" ");
            }
            System.out.println("I---------------------------------------------------------------I");
            return;
        }
        System.out.println(RED +"Book with this name is not exist in library " + RESET);
        System.out.println("I---------------------------------------------------------------I");
    }

    public void searchByAuthor(String author) {
        List<Book> searchByAuthor = libraryData.getBookList().stream()
                .filter(book -> book.getAuthor().toUpperCase().contains(author.toUpperCase()))
                .collect(Collectors.toList());
        String isfound = "Not Available";
        if (searchByAuthor.size() > 0) {
            for (Book book : searchByAuthor) {
                String found = "Not Availble";
                for (Book tempBook : libraryData.getAvailableBooks()) {
                    if (tempBook.getTitle().equals(book.getTitle())) {
                        found = "Available";
                    }
                }
                System.out.printf(YELLOW + "Title: " + RESET + "%s " + YELLOW + "Author: " + RESET + "%s " +
                                YELLOW + "Year: " + RESET + "%d " + YELLOW + "Description: " + RESET + "%s " + YELLOW + "Book Status: " + RESET +"%s%n",
                        book.getTitle(), book.getAuthor(), book.getYear(), book.getDescription(), found);
                System.out.println(" ");
                return;
            }
            System.out.println("I---------------------------------------------------------------I");
            return;
        }
        System.out.println(RED +"Book with this author name is not exist in library " + RESET);
        System.out.println("I---------------------------------------------------------------I");
    }

    public void sortByTitle() {
        Comparator<Book> compareByTitle = Comparator.comparing(Book::getTitle);
        libraryData.getBookList().sort(compareByTitle);
        for (Book book : libraryData.getBookList()) {
            String found = "Not Availble";
            for (Book tempBook : libraryData.getAvailableBooks()) {
                if(tempBook.getTitle().equals(book.getTitle())){
                    found = "Available";
                }
            }
            System.out.printf(YELLOW + "Title: " + RESET + "%s " + YELLOW + "Author: " + RESET + "%s " +
                            YELLOW + "Year: " + RESET + "%d " +  YELLOW + "Book Status: " + RESET +"%s%n",
                    book.getTitle(), book.getAuthor(), book.getYear(), found);
        }
        System.out.println("I------------------------------------------------------------------I");
    }

    public void sortByAuthor() {
        Comparator<Book> compareByAuthor = Comparator.comparing(Book::getAuthor);
        libraryData.getBookList().sort(compareByAuthor);
        for (Book book : libraryData.getBookList()) {
            String found = "Not Availble";
            for (Book tempBook : libraryData.getAvailableBooks()) {
                if(tempBook.getTitle().equals(book.getTitle())){
                    found = "Available";
                }
            }
            System.out.printf(YELLOW + "Title: " + RESET + "%s " + YELLOW + "Author: " + RESET + "%s " +
                            YELLOW + "Year: " + RESET + "%d " +  YELLOW + "Book Status: " + RESET +"%s%n",
                    book.getTitle(), book.getAuthor(), book.getYear(), found);
        }
        System.out.println("I------------------------------------------------------------------I");
    }

    public void showAllBook() {
        if (libraryData.getBookList().size() > 0) {
            for (Book book : libraryData.getBookList()) {
                String found = "Not Availble";
                for (Book tempBook : libraryData.getAvailableBooks()) {
                    if(tempBook.getTitle().equals(book.getTitle())){
                        found = "Available";
                    }
                }
                System.out.printf(YELLOW + "Title: " + RESET + "%s " + YELLOW + "Author: " + RESET + "%s " +
                                YELLOW + "Year: " + RESET + "%d " +  YELLOW + "Book Status: " + RESET +"%s%n",
                        book.getTitle(), book.getAuthor(), book.getYear(), found);

            }
            System.out.println("I------------------------------------------------------------------I");
            return;
        }
        System.out.println(RED +"There is no book exist in library database" + RESET);
        System.out.println("I------------------------------------------------------------------I");
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
