package com.company.Modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends Person implements Serializable {
    //  List<Object> borrowedBooks = ArrayList;
    String email = null;
    private static final long serialVersionUID = 6897230677316227865L;//ställ fråga här
    List<Book> myBorrowedBooks = new ArrayList();

    public User( String username, String password) {
        super( username, password);
    }

    public List<Book> getMyBorrowedBooks() {
        return myBorrowedBooks;
    }


    public void addToBorrowedBooks(Book book){
        myBorrowedBooks.add(book);
        System.out.println(myBorrowedBooks);
    }
    public void printBorrowedBooks(){
        if (myBorrowedBooks.size()>0){
            myBorrowedBooks
                    .stream()
                    .forEach(book -> System.out.printf("%s%n",book.getTitle()));
        }else {
            System.out.println("you haven't borrowed any books yet");

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
