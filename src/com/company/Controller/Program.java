package com.company.Controller;

import com.company.Controller.LoginAndRegister.LoginOrRegister;
import com.company.Modules.Library;

public class Program {
    Library library = new Library();
    LoginOrRegister loginOrRegister = new LoginOrRegister(library);

    public Program() {
    }

    public void run() {


        library.addData();


    }



    //call teh ui for register or login then call the chosen function
    //login making a list of both user and librarians to compare against
    //if stament that says if the found object is an librarian or user1


}
