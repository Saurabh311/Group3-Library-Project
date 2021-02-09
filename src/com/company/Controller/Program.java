package com.company.Controller;

import com.company.Controller.LoginAndRegister.LoginOrRegister;
import com.company.Factory.Factory;
import com.company.Modules.*;

import java.util.List;
import java.util.stream.Collectors;

public class Program {

    Library library;

    LoginOrRegister loginOrRegister;

    //----PRINTS
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    //----

    public Program() { }

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
     library.setUsers((List<User>) HandleData.readObject("Users.ser"));
     library.setLibrarians((List<Librarian>) HandleData.readObject("Librarians.ser"));
     library.setBookList((List<Book>) HandleData.readObject("Books.ser"));
     library.setBorrowedBooks((List<Book>) HandleData.readObject("BorrowedBooks.ser"));
    }

    public void saveData(){

        HandleData.writeObject(library.getUsers(),"Users.ser");
        HandleData.writeObject(library.getLibrarians(),"Librarians.ser");
        HandleData.writeObject(library.getBookList(),"Books.ser");
        HandleData.writeObject(library.getBorrowedBooks(),"BorrowedBooks.ser");
        System.out.println(GREEN + "\n[ Data saved ]\n" + RESET);

    }

    public void pAllBooksOfUser(String username){

        List<User> userCheck;
           userCheck = library.getUsers()
                    .stream()
                    .filter(user -> username.equals(user.getUsername()))
                    .collect(Collectors.toList());
        if ( userCheck.size() > 0){
            System.out.println(userCheck.get(0).getMyBorrowedBooks());
        }
        else {
            System.out.println("Username does not exist.");
        }

    }



    //call teh ui for register or login then call the chosen function
    //login making a list of both user and librarians to compare against
    //if stament that says if the found object is an librarian or user1


}
