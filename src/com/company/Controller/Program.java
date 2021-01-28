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

    public Program() {
    }

    public void run() {


        library.addData();


    }

    public Person login() {
        String username;
        String password;
        Person account = null;

        Scanner input = new Scanner(System.in);

        System.out.print("Username:");
        username = input.nextLine();

        System.out.print("Password:");
        password = input.nextLine();

        account = userValidator(username, password);

        if (account != null) {
            System.out.println("login succesful");

        } else {
            System.out.println("login failed");
        }


        return account;
    }

    public void register() {
        System.out.print("plese");
    }

    public Person userValidator(String username, String password) {
        Person account = null;


        List<Person> persons = new ArrayList<>();
        library.addData();//will remove this later jsut used to add data

        persons.addAll(library.getLibrarians());
        persons.addAll(library.getUsers());

        for (Person user : persons) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                account = user;
            }
        }


        return account;
    }
    //call teh ui for register or login then call the chosen function
    //login making a list of both user and librarians to compare against
    //if stament that says if the found object is an librarian or user1


}
