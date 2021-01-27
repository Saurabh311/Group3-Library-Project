package com.company.Modules;
import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> bookList = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<Librarian> librarians = new ArrayList<>();


    public Library() { }

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

        User user = new User("Fredrik", "asdasd@dasd", 7, 65);
        User user1 = new User("Saurabh", "asdasd@dasd", 7, 58);

        users.add(user);
        users.add(user1);

        Librarian librarian = new Librarian("Marcel", 7, 97);

        librarians.add(librarian);




    }
}



