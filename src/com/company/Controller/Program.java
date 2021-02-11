package com.company.Controller;

import com.company.Controller.LoginAndRegister.LoginOrRegister;
import com.company.Factory.Factory;
import com.company.Modules.*;
import com.company.Modules.Library.Library;
import com.company.Modules.Library.LibraryData;

import java.util.List;
import java.util.stream.Collectors;

public class Program {

    Library library;

    LoginOrRegister loginOrRegister;

    //----PRINTS
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    //----

    public Program() {
    }

    public void buildProgram() {
        library = Factory.buildLibrary();
        loginOrRegister = new LoginOrRegister(library);
        getDataOnLoad();
        library.setAvailableBooks();

    }

    public Library getLibrary() {
        return library;
    }

    public LoginOrRegister getLoginOrRegister() {
        return loginOrRegister;
    }


    private void getDataOnLoad() {
        System.out.println(GREEN + "\n[ Data loaded ]\n" + RESET);
        LibraryData.getInstance().setUsers((List<User>) HandleData.readObject("Users.ser"));
        LibraryData.getInstance().setLibrarians((List<Librarian>) HandleData.readObject("Librarians.ser"));
        LibraryData.getInstance().setBookList((List<Book>) HandleData.readObject("Books.ser"));
        LibraryData.getInstance().setBorrowedBooks((List<Book>) HandleData.readObject("BorrowedBooks.ser"));

    }

    public void saveData() {

        HandleData.writeObject(LibraryData.getInstance().getUsers(), "Users.ser");
        HandleData.writeObject(LibraryData.getInstance().getLibrarians(), "Librarians.ser");
        HandleData.writeObject(LibraryData.getInstance().getBookList(), "Books.ser");
        HandleData.writeObject(LibraryData.getInstance().getBorrowedBooks(), "BorrowedBooks.ser");
        System.out.println(GREEN + "\n[ Data saved ]\n" + RESET);

    }

}
