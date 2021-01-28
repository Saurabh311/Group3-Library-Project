package com.company.Controller;

import com.company.Modules.Librarian;
import com.company.Modules.Library;
import com.company.Modules.Person;
import com.company.Modules.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
