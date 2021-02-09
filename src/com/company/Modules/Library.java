package com.company.Modules;

import com.company.Factory.Factory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Library {

    List<Book> bookList = new ArrayList<>();
    List<Book> availableBooks = new ArrayList<>();
    List<Book> borrowedBooks = new ArrayList<>();

    List<User> users = new ArrayList<>();

    List<Librarian> librarians = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    //----PRINTS
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    //----

    public Library() { }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<Book> getBookList() {
        return bookList;
    }
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
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

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks() {
        if (borrowedBooks.size() > 0) {
            for (Book book:bookList){
                List<Book> tempArray1 =borrowedBooks
                        .stream()
                        .filter(borrowedBook -> book.getTitle().equals(borrowedBook.getTitle()) )
                        .collect(Collectors.toList());
                if(tempArray1.size()<=0){ //if no borrowed book was equal to a book in booklist
                    availableBooks.add(book);
                }
            }
        } else availableBooks = new ArrayList<>(bookList);
    }
    // Prints all user objects
    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
    // search User by name
    public void findUser() {
        System.out.println("Input username: \n");
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(input.nextLine())) {
                System.out.println(user.getUsername());
            } else {
                System.out.println("Username not found.\n");
            }
        }
    }

    public void borrowBook(User user){
        System.out.println("Which book would you like to borrow?\nInput the title.\n");
        String title = input.nextLine();
        List<Book> bookToBorrow = availableBooks
                .stream()
                .filter(book -> title.equalsIgnoreCase(book.getTitle()))
                .collect(Collectors.toList());
        if ( bookToBorrow.size() > 0){
            changeFromAvailableToBorrowed(bookToBorrow.get(0));
            bookToBorrow.get(0).setCurrentLender(user.getUsername());
            user.addToBorrowedBooks(bookToBorrow.get(0));

            bookToBorrow.get(0).setBorrowDate(LocalDate.now());
            System.out.println("Date borrowed: " + bookToBorrow.get(0).borrowDate);
            System.out.println("Return Date: " + bookToBorrow.get(0).returnDate);
        } else {
            System.out.println("The book isn't available.\n");
        }
    }

    public void returnBook(User user){
        System.out.println("Which book would you like to return?\nInput the title.\n");
        String title = input.nextLine();
        List<Book> returnToBook = borrowedBooks.stream()
                .filter(book -> title.equalsIgnoreCase(book.getTitle()))
                .collect(Collectors.toList());
        if (returnToBook.size() > 0){
            changeFromBorrowedToAvailable(returnToBook.get(0));
            returnToBook.get(0).setCurrentLender(null);
            user.removeFromBorrowedBooks(returnToBook.get(0));
        }
        else{
            System.out.println("The book isn't available.\n");
        }

    }
    public void changeFromBorrowedToAvailable(Book book){
        for (int i =0; borrowedBooks.size()>i; i++) {
            if (book.getTitle().equals(borrowedBooks.get(i).getTitle())) {
                borrowedBooks.remove(i);
                availableBooks.add(book);

            }
        }
    }


    public void changeFromAvailableToBorrowed(Book book){
        int index=0;
        for (int i = 0; i< availableBooks.size(); i++){
            if (availableBooks.get(i).getTitle().equals(book.getTitle())){
                index = i;
            }
        }
        availableBooks.remove(index);
        borrowedBooks.add(book);
    }

    public void searchByTitle(String title) {
        List<Book> searchByTitle = bookList.stream()
                .filter(book -> book.getTitle().toUpperCase().contains(title.toUpperCase()))
                .collect(Collectors.toList());
        if (searchByTitle.size() > 0){
            searchByTitle.forEach(book -> System.out.printf(
                    "Title: %s Author: %s Description: %s Year: %d%n",book.getTitle(), book.getAuthor(),book.getDescription(), book.getYear()));
            System.out.println("-----------------------------------------");}
        else {
            System.out.println("The book isn't in the library.\n");
        }
    }

    public void searchByAuthor(String author) {
        List<Book> searchByAuthor = bookList.stream()
                .filter(book -> book.getAuthor().toUpperCase().contains(author.toUpperCase()))
                .collect(Collectors.toList());
        if (searchByAuthor.size() > 0){
            searchByAuthor.forEach(book -> System.out.printf(
                    "Title: %s Author: %s Description: %s Year: %d%n",book.getTitle(), book.getAuthor(),book.getDescription(), book.getYear()));
            System.out.println("-----------------------------------------");}
        else {
            System.out.println("The book isn't in the library.\n");
        }
    }

    public void addBook() {
        System.out.println("Input book title:\n");
        String title = input.nextLine();

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
                bookList.add(book);////using factory for book
                availableBooks.add(book);
                System.out.println("[ Book added ]\n");
            } catch (NumberFormatException e) {
                System.out.println("Input book release year using numbers.\n");
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
            System.out.println(GREEN + "\n [ Added user ] \n" + RESET);
        } else {
            librarians.add((Librarian) person);
            System.out.println(GREEN + "\n [ Added librarian ] \n" + RESET);
        }

    }

    public void sortByTitle() {
        Comparator<Book> compareByTitle = Comparator.comparing(Book::getTitle);
        bookList.sort(compareByTitle);
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }

    public void sortByAuthor() {
        Comparator<Book> compareByAuthor = Comparator.comparing(Book::getAuthor);
        bookList.sort(compareByAuthor);
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }


    public void showAllBook(){
        if (bookList.size() > 0) {
            bookList.forEach(book -> System.out.println(book.toString()));
            System.out.println(" ");
        }
        else{
            System.out.println("There are no books in the library.\n");
        }
    }

    public void removeBookByTitle(String title){
        List <Book> removeBook = bookList.stream()
                .filter(book -> book.title.equalsIgnoreCase(title))
                .collect(Collectors.toList());
        if (removeBook.size() > 0) {
            bookList.remove(removeBook.get(0));
            System.out.println(GREEN +"\n [ Book removed ] \n" + RESET);
        }
        else{
            System.out.println("The book isn't in the library.\n");
        }
    }

    public void showAllLentBooks() {
        if (borrowedBooks.size() > 0) {

            borrowedBooks
                    .forEach(book -> System.out.printf("%s is borrowed by user:%s%n Return date:%s%n", book.getTitle(), book.getCurrentLender(), book.getReturnDate()));
        } else {
            System.out.println("No books are lent out.\n");

        }
    }

    public void sendReminder(User user) {

        user.getMyBorrowedBooks().stream().
                filter(book -> book.getReturnDate().isBefore(LocalDate.now())).
                forEach(book -> System.out.printf(RED + "Return overdue: %s%n", book.getTitle() + RESET));
                System.out.println(" ");

    }
    public void saveListOfBooks(){
        List<String> BooksSplit;


        try {
            int amountOfBooksAdded = 0;
            BooksSplit = Files.readAllLines(Paths.get("BooksToAdd.txt"));

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
                    availableBooks.add(bookToAdd);
                    amountOfBooksAdded++;

                }


            }
            System.out.printf(GREEN + "%n [ (%d) books added ] %n" + RESET ,amountOfBooksAdded);

        }catch (Exception e){
            System.out.println("File not found.");
        }
    }
}





