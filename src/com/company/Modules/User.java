package com.company.Modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends Person implements Serializable {
    //  List<Object> borrowedBooks = ArrayList;

    private static final long serialVersionUID = 6897230677316227865L;
    List<Book> myBorrowedBooks = new ArrayList();

    public User() { }

    public List<Book> getMyBorrowedBooks() {
        return myBorrowedBooks;
    }

    public void addToBorrowedBooks(Book book){
        myBorrowedBooks.add(book);
        System.out.println(book);
    }

    public void removeFromBorrowedBooks(Book book){
        myBorrowedBooks.remove(book);
        System.out.println("Book returned");
    }

    public void printBorrowedBooks(){
        if (myBorrowedBooks.size()>0){
            myBorrowedBooks
                    .stream()
                    .forEach(book -> System.out.printf("%s Return date:%s%n",book.getTitle(),book.getBorrowDate()));
        }else {
            System.out.println("You haven't borrowed any books yet.");

        }
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
