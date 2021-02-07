package com.company.Controller;

import com.company.Controller.LoginAndRegister.LoginOrRegister;
import com.company.Factory.Factory;
import com.company.Modules.*;

import java.util.List;
import java.util.stream.Collectors;

public class Program {
    Library library;
    LoginOrRegister loginOrRegister ;

    public Program() {
    }

    public void buildProgram() {
        library = Factory.buildLibrary();
        loginOrRegister = new LoginOrRegister(library);
        getDataOnLoad();
        library.setAvailibleBooks();
<<<<<<< HEAD
=======



>>>>>>> c711b5abdf21a7018391a37298279189a4d453ea
    }

    private void getDataOnLoad() {
        System.out.println("data loaded");
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

    }

    public void pAllBooksOfUser(String username){

        List<User> userChek;
           userChek = library.getUsers()
                    .stream()
                    .filter(user -> username.equals(user.getUsername()))
                    .collect(Collectors.toList());
        if ( userChek.size() > 0){
            System.out.println(userChek.get(0).getMyBorrowedBooks());
        }
        else {
            System.out.println("User dose not exist");
        }

    }



    //call teh ui for register or login then call the chosen function
    //login making a list of both user and librarians to compare against
    //if stament that says if the found object is an librarian or user1


}
