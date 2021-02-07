package com.company.Modules;

import com.company.Factory.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Library {

    List<Book> bookList = new ArrayList<>();
    List<Book> availibleBooks = new ArrayList<>();
    List<Book> borrowedBooks = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<Librarian> librarians = new ArrayList<>();
    Scanner input = new Scanner(System.in);


    public Library() {

    }
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Book> getAvailibleBooks() {
        return availibleBooks;
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
            if (user.getUsername().toUpperCase().equals(input.nextLine().toUpperCase())) {
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

    public void setAvailibleBooks (){
        if(borrowedBooks.size()>0){
            availibleBooks = bookList
                    .stream()
                    .filter(book -> {
                        boolean check = true;
                        for (int i = 0;i < borrowedBooks.size();i++){
                            if (borrowedBooks.get(i).getTitle().equals(book.getTitle())){
                                check = false;
                                i = borrowedBooks.size();

                            } }return check;
                    })
                    .collect(Collectors.toList());
        }else availibleBooks = new ArrayList<>(bookList);
    }
    public void borrowBook(User user){
        System.out.println("please write the title of the book you want to borrow");
        String title = input.nextLine();
        List<Book> bookToBorrow = availibleBooks
                .stream()
                .filter(book -> title.toUpperCase().equals(book.getTitle().toUpperCase()))
                .collect(Collectors.toList());
        if ( bookToBorrow.size() > 0){
            changeFromAvailibleToBorrowed(bookToBorrow.get(0));
            bookToBorrow.get(0).setCurrentLender(user.getUsername());
            user.addToBorrowedBooks(bookToBorrow.get(0));

            bookToBorrow.get(0).setBorrowDate(LocalDate.now());
            System.out.println("Date borrowed: " + bookToBorrow.get(0).borrowDate);
            System.out.println("Return Date: " + bookToBorrow.get(0).returnDate);
        } else {
            System.out.println("book is not availible");
        }
    }

    public void returnBook(User user){
        System.out.println("please write the title of the book you want to return");
        String title = input.nextLine();
        List<Book> returnToBook = borrowedBooks.stream()
                .filter(book -> title.toUpperCase().equals(book.getTitle().toUpperCase()))
                .collect(Collectors.toList());
        if (returnToBook.size() > 0){
            changeFromBorrowedToAvailible(returnToBook.get(0));
            returnToBook.get(0).setCurrentLender(null);
            user.removeFromBorrowedBooks(returnToBook.get(0));
        }
        else{
            System.out.println("Book is not available");
        }

    }
    public void changeFromBorrowedToAvailible(Book book){
        for (int i =0; borrowedBooks.size()>i; i++) {
            if (book.getTitle().equals(borrowedBooks.get(i).getTitle())) {
                borrowedBooks.remove(i);
                availibleBooks.add(book);

            }
        }
    }
    public void changeFromAvailibleToBorrowed(Book book){
        int index=0;
        for (int i =0;i< availibleBooks.size();i++){
            if (availibleBooks.get(i).getTitle().equals(book.getTitle())){
                index = i;
            }
        }availibleBooks.remove(index);
        borrowedBooks.add(book);
    }

    public boolean searchByTitle(String title) {
        for (Book book : bookList) {
            if (book.title.toUpperCase().equals(title.toUpperCase())) {
                System.out.println(book.toString());
                return true;
            }
        }
        System.out.println("Book is not exist");
        return false;
    }

    public void searchByAuthor(String author) {
        for (Book book : bookList) {
            if (book.author.toUpperCase().equals(author.toUpperCase())) {
                System.out.println(book.toString());
                return;
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
        boolean intInput = true;
        while(intInput) {
            String userInputYear = input.nextLine();

            try {
                int year = Integer.parseInt(userInputYear);
                intInput = false;
                Book book = Factory.buildBook().title(title).description(description).author(author).year(year);
                bookList.add(book);////using factory for book
                availibleBooks.add(book);
                System.out.println("New Book added");
            } catch (NumberFormatException e) {
                System.out.println("Please insert year of book in numbers");
            }
        }
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
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }

    public void sortByAuthor() {
        Comparator<Book> compareByAuthor = Comparator.comparing(Book::getAuthor);
        Collections.sort(bookList, compareByAuthor);
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }


    public void showAllBook(){
        if (!(bookList ==null)) {
            bookList.stream()
                    .forEach(book -> System.out.println(book.toString()));
        }
        else{
            System.out.println("There is no books in the library");
        }
    }

    public void removeBookByTitle(String title){
        List <Book> removeBook = bookList.stream()
                .filter(book -> book.title.toUpperCase().equals(title.toUpperCase()))
                .collect(Collectors.toList());
        if (!(removeBook == null)) {
            bookList.remove(removeBook.get(0));
            System.out.println("Book removed from library database");
        }
        else{
            System.out.println("Book is not in library");
        }


    }

    public void showAllLentBooks() {
        if (borrowedBooks.size() > 0) {

            borrowedBooks
                    .forEach(book -> System.out.printf("%s is borrowed by user:%s Return date:%s%n", book.getTitle(), book.getCurrentLender(), book.getReturnDate()));
        } else {
            System.out.println("No books are lent out");

        }
    }

    public void sendReminder(User user) {

        user.getMyBorrowedBooks().stream().
                filter(book -> book.getReturnDate().isBefore(LocalDate.now())).
                forEach(book -> System.out.println("Return overdue: " + book.getTitle()));

    }
    public void saveListOfBooks(){
        List<String> BooksSplit;


        try {
            int ammountOfBooksAdded = 0;
            BooksSplit = Files.readAllLines(Paths.get("C:\\Users\\klosa\\Desktop\\java\\Group 3 Project\\BooksToAdd.txt"));

            for (String bookLine: BooksSplit){


                String[] splitRow = bookLine.split("#");
                Book bookToAdd = new Book().title(splitRow[0]).author(splitRow[1])
                        .description(splitRow[2]).year(Integer.parseInt(splitRow[3]) );

                List<Book> temparray = bookList
                        .stream()
                        .filter(book -> book.getTitle().equals(bookToAdd.getTitle()))
                        .collect(Collectors.toList());
                if (temparray.size()<=0){
                    bookList.add(bookToAdd);
                    availibleBooks.add(bookToAdd);
                    ammountOfBooksAdded++;

                }


            }
            System.out.printf("(%d) books added%n",ammountOfBooksAdded);

        }catch (Exception e){
            System.out.println("file not found");
        }
    }
}





