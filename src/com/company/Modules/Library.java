package com.company.Modules;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> bookList = new ArrayList<>();


    List<User> users = new ArrayList<>();
    List<Librarian> librarians = new ArrayList<>();


    public Library() {
    }

    public void addData() {

        Book book = new Book("Red Rising", "Adventure", "Peter Brown", 1998);
        Book book1 = new Book("Blue Rising", "Action", "Fredrik Granath", 1998);
        Book book2 = new Book("Green Rising", "Romance", "Saurabh Chauhan", 1998);
        Book book3 = new Book("Pink Rising", "Comedy", "Dan Stevenson", 1998);
        Book book4 = new Book("Yellow Rising", "Thriller", "Hamoodi", 1998);

        bookList.add(book);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        User user = new User("Fredrik", "klosansa1@hot.se", "klosansa1", "test", 8, 65);
        User user1 = new User("Saurabh", "asdasd@dasd", "saura1", "cake", 7, 58);

        users.add(user);
        users.add(user1);

        Librarian librarian = new Librarian("Marcel", "marcelly", "java1", 7, 97);

        librarians.add(librarian);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public boolean searchByTitle(String title) {
        for (Book book : bookList) {
            if (book.title == title) {
                return true;
            }

        }
        return false;
    }

    public boolean searchByAuthor(String author) {
        for (Book book : bookList) {
            if (book.author == author) {
                return true;
            }

        }
        return false;
    }

    public void addBook(String title, String description, String author, int year) {


        bookList.add(new Book(title, description, author, year));
        System.out.println("New Book added");


    }

}




