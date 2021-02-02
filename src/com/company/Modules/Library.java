package com.company.Modules;

import java.util.*;

public class Library {

    List<Book> bookList = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<Librarian> librarians = new ArrayList<>();
    Scanner input = new Scanner(System.in);

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

    // Prints all user objects
    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    // search User by name
    public void findUser() {
        System.out.println("Input username: ");
        for (User user : users) {
            if (user.getUsername().equals(input.nextLine())) {
                System.out.println(user.getUsername());
            } else {
                System.out.println("Username not found.");
            }
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
            if (book.title.equals(title)) {
                System.out.println(book.toString());
                return true;
            }

        }
        System.out.println("Book is not exist");
        return false;
    }

    public void searchByAuthor(String author) {
        for (Book book : bookList) {
            if (book.author.equals(author)) {
                System.out.println(book.toString());
            }

        }
        System.out.println("Book is not exist");

    }

    public void addBook() {
        System.out.println("Insert the title of book");
        String title = input.nextLine();

        System.out.println("Insert the description of book");
        String description = input.nextLine();

        System.out.println("Insert the author of book");
        String author = input.nextLine();

        System.out.println("Insert the year of book release");
        int year = input.nextInt();

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

    public void showAllBook(){
        for (Book book: bookList) {
            System.out.println(book.toString());
        }
    }

}




