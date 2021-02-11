package com.company.Modules.Library;

import com.company.Modules.Book;
import com.company.Modules.Librarian;
import com.company.Modules.User;
import com.company.View.Menu.UIdata;

import java.util.ArrayList;
import java.util.List;

public class LibraryData {
    private static LibraryData libraryData = null;


    List<Book> bookList = new ArrayList<>();
    List<Book> availableBooks = new ArrayList<>();
    List<Book> borrowedBooks = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<Librarian> librarians = new ArrayList<>();

    private LibraryData() {

    }

    public static LibraryData getInstance() {
        if (libraryData == null) {
            libraryData = new LibraryData();

        }
        return libraryData;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(List<Librarian> librarians) {
        this.librarians = librarians;
    }

    public void changeFromBorrowedToAvailable(Book book) {
        for (int i = 0; borrowedBooks.size() > i; i++) {
            if (book.getTitle().equals(borrowedBooks.get(i).getTitle())) {
                borrowedBooks.remove(i);
                availableBooks.add(book);

            }
        }
    }

    public void changeFromAvailableToBorrowed(Book book) {
        int index = 0;
        for (int i = 0; i < availableBooks.size(); i++) {
            if (availableBooks.get(i).getTitle().equals(book.getTitle())) {
                index = i;
            }
        }
        availableBooks.remove(index);
        borrowedBooks.add(book);
    }


}
