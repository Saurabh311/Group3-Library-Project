package com.company.Controller;
import com.company.Modules.Librarian;
import com.company.Modules.Library;
import com.company.Modules.User;

import java.util.Scanner;

public class Program {

    public Program() { }

    public void run() {

        Library library = new Library();
        library.addData();
        User test  = new User("fg","g",12,4);
        Librarian test2 = new Librarian("g",4,5);





    }

    public static void login(){
        Scanner input = new Scanner(System.in);

        String username;
        System.out.print("Username:");
        username= input.nextLine();
        //check username make try catch if true return true and continue to password
        //after password check return the object that matches
        //will go to uicheck and continue from there
    }

    public static void register(){
        System.out.println("in register");
    }
    //call teh ui for register or login then call the chosen function
    //login making a list of both user and librarians to compare against
    //if stament that says if the found object is an librarian or user1





}
