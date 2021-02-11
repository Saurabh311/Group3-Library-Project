package com.company.Modules.Library;

import com.company.Modules.Book;
import com.company.Modules.Librarian;
import com.company.Modules.Person;
import com.company.Modules.User;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Library {


    UserMethods userMethods = new UserMethods();
    LibrarianMethods librarianMethods = new LibrarianMethods();
    Prints prints = new Prints();
    LibraryData libraryData = LibraryData.getInstance();

    //----PRINTS
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    //----

    public Library() {
    }


    public UserMethods getUserMethods() {
        return userMethods;
    }

    public LibrarianMethods getLibrarianMethods() {
        return librarianMethods;
    }


    public List<Book> getAvailableBooks() {
        return LibraryData.getInstance().getAvailableBooks();
    }

    public Prints getPrints() {
        return prints;
    }

    public void setAvailableBooks() {
        if (libraryData.getBorrowedBooks().size() > 0) {
            for (Book book : libraryData.getBookList()) {
                List<Book> tempArray1 = libraryData.getBorrowedBooks()
                        .stream()
                        .filter(borrowedBook -> book.getTitle().equals(borrowedBook.getTitle()))
                        .collect(Collectors.toList());
                if (tempArray1.size() <= 0) { //if no borrowed book was equal to a book in booklist
                    libraryData.getAvailableBooks().add(book);
                }
            }
        } else libraryData.setAvailableBooks(libraryData.getBookList());
    }


    public List<Person> getAllPersonsToList() {
        List<Person> persons = new ArrayList<>();
        persons.addAll(libraryData.getUsers());
        persons.addAll(libraryData.getLibrarians());

        return persons;
    }

    public void addPerson(Object person) {
        if (person instanceof User) {
            libraryData.getUsers().add((User) person);
            System.out.println(GREEN + "\n [ Added user ] \n" + RESET);
        } else {
            libraryData.getLibrarians().add((Librarian) person);
            System.out.println(GREEN + "\n [ Added librarian ] \n" + RESET);
        }

    }


}





