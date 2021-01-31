package com.company.Controller;

import com.company.Controller.LoginAndRegister.LoginOrRegister;
import com.company.Modules.Library;
import com.company.Modules.User;

import java.util.List;
import java.util.stream.Collectors;

public class Program {
    Library library = new Library();
    LoginOrRegister loginOrRegister = new LoginOrRegister(library);

    public Program() {
    }

    public void run() {


        library.addData();



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
