package com.company.Modules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {

    List<Book> bookList = new ArrayList<>();


    List<User> users = new ArrayList<>();
    List<Librarian> librarians = new ArrayList<>();


    public Library() {


    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<User> getUsers() {
        return users;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }


    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void setLibrarians(List<Librarian> librarians) {
        this.librarians = librarians;

    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public boolean searchByTitle(String title) {
        for (Book book : bookList) {
            if (book.title == title) {
                System.out.println(book);
                return true;
            }

        }
        return false;
    }

    public boolean searchByAuthor(String author) {
        for (Book book : bookList) {
            if (book.author == author) {
                System.out.println(book);
                return true;
            }

        }
        return false;
    }

    public void addBook(String title, String description, String author, int year) {


        bookList.add(new Book(title, description, author, year));
        System.out.println("New Book added");


    }

    public List<Person> getAllPersonsToList() {
        List<Person> persons = new ArrayList<>();
        persons.addAll(users);
        persons.addAll(librarians);

        return persons;
    }

    public void addPerson(Object person) {
        if (person instanceof User) {
            users.add((User) person);
            System.out.println("added user");
        } else {
            librarians.add((Librarian) person);
            System.out.println("added librarian");
        }

    }

    public void sortByTitle() {
        Comparator<Book> compareByTitle = Comparator.comparing(Book::getTitle);
        Collections.sort(bookList, compareByTitle);
        System.out.println(bookList);
    }

    public void sortByAuthor() {
        Comparator<Book> compareByAuthor = Comparator.comparing(Book::getAuthor);
        Collections.sort(bookList, compareByAuthor);
        System.out.println(bookList);
    }

}




