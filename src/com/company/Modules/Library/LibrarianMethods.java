package com.company.Modules.Library;

import com.company.Factory.Factory;
import com.company.Modules.Book;
import com.company.Modules.User;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibrarianMethods {
    Scanner input = new Scanner(System.in);
    LibraryData libraryData = LibraryData.getInstance();
    //----PRINTS
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    //----

    public LibrarianMethods() {
    }

    public void printUsers() {
        for (User user : libraryData.getUsers()) {
            System.out.println(user);
        }
    }

    public void findUser() {

        System.out.println("Input username: \n");
        for (User user : libraryData.getUsers()) {
            if (user.getUsername().equalsIgnoreCase(input.nextLine())) {
                System.out.println(user.getUsername());
            } else {
                System.out.println("Username not found.\n");
            }
        }
    }

    public void showAllLentBooks() {
        if (libraryData.getBorrowedBooks().size() > 0) {

            libraryData.getBorrowedBooks()
                    .forEach(book -> System.out.printf("%s is borrowed by user:%s%n Return date:%s%n",
                            book.getTitle(), book.getCurrentLender(), book.getReturnDate()));
        } else {
            System.out.println("No books are lent out.\n");

        }
    }

    public void addBook() {

        System.out.println("Input book title:\n");
        String title = input.nextLine();


        List<Book> checkExisting = libraryData.getBookList()
                .stream()
                .filter(existingBook -> existingBook.getTitle().equals(title))
                .collect(Collectors.toList());
        if (checkExisting.size() <= 0) {
            System.out.println("Input book description:\n");
            String description = input.nextLine();

            System.out.println("Input book author:\n");
            String author = input.nextLine();

            System.out.println("Input book release year:\n");
            boolean intInput = true;
            while (intInput) {
                String userInputYear = input.nextLine();

                try {
                    int year = Integer.parseInt(userInputYear);
                    intInput = false;
                    Book book = Factory.buildBook().title(title).description(description).author(author).year(year);
                    libraryData.getBookList().add(book);
                    libraryData.getAvailableBooks().add(book);
                    System.out.println("[ Book added ]\n");
                } catch (NumberFormatException e) {
                    System.out.println("Input book release year using numbers.\n");
                }
            }
        } else {
            System.out.println("book already exists");
        }


    }

    public void removeBookByTitle(String title) {

        List<Book> removeBook = libraryData.getAvailableBooks().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
        if (removeBook.size() > 0) {
            libraryData.getAvailableBooks().remove(removeBook.get(0));
            libraryData.getBookList().remove(removeBook.get(0));
            System.out.println(GREEN + "\n [ Book removed ] \n" + RESET);
            System.out.println(" ");
        } else {
            System.out.println("The book isn't in the library.\n");
        }
    }

    public void saveListOfBooks() {
        List<String> BooksSplit;


        try {
            int amountOfBooksAdded = 0;
            BooksSplit = Files.readAllLines(Paths.get("BooksToAdd.txt"));

            for (String bookLine : BooksSplit) {


                String[] splitRow = bookLine.split("#");
                Book bookToAdd = new Book().title(splitRow[0]).author(splitRow[1])
                        .description(splitRow[2]).year(Integer.parseInt(splitRow[3]));

                List<Book> temparray = libraryData.getBookList()
                        .stream()
                        .filter(book -> book.getTitle().equals(bookToAdd.getTitle()))
                        .collect(Collectors.toList());
                if (temparray.size() <= 0) {
                    libraryData.getBookList().add(bookToAdd);
                    libraryData.getAvailableBooks().add(bookToAdd);
                    amountOfBooksAdded++;

                }


            }
            System.out.printf(GREEN + "%n [ (%d) books added ] %n" + RESET, amountOfBooksAdded);

        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }
}
