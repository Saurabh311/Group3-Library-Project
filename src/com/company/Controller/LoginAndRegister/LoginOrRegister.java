package com.company.Controller.LoginAndRegister;

import com.company.Factory.Factory;
import com.company.Modules.*;

import java.util.List;
import java.util.Scanner;

public class LoginOrRegister {
    Scanner input = new Scanner(System.in);
    Library library;

    //----PRINTS
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    //----

    public LoginOrRegister(Library library) {
        this.library = library;
    }

    public Person login() {
        String username;
        String password;
        Person account;


        System.out.print("Username:");
        username = input.next();

        System.out.print("Password:");
        password = input.next();

        account = loginValidator(username, password);

        if (account != null) {
            System.out.println(GREEN + "\n[ Login successful ]\n" + RESET);

        } else {
            System.out.println(RED + "\n[ Login failed ]\n" + RESET);
        }


        return account;
    }
    public void register() {
        LoginOrRegisterValidator loginOrRegisterValidator = new LoginOrRegisterValidator(library);
        String newUsername;
        String newPassWord;

        boolean sentinel = false;

        while (!sentinel){

            System.out.print("Choose your username:");
            newUsername = input.next();
            if(loginOrRegisterValidator.usernameValidation(newUsername)){
                System.out.print("Choose your password:");
                newPassWord = input.next();
                if (loginOrRegisterValidator.passwordValidation(newPassWord)){
                    String choice;
                    //int choiceToInt = 0;

                    System.out.println("[1] Register as a user\n[2] Register as a librarian");
                    choice = input.next();
                    if (choice.matches("[12]")){

                        if (Integer.parseInt(choice) ==1){


                            library.addPerson(Factory.buildPerson("user")
                                    .username(newUsername).password(newPassWord));
                            sentinel = true;
                        }
                        if (Integer.parseInt(choice) ==2){

                            //  old way:  Librarian librarian = new Librarian(newUsername,newPassWord);
                            library.addPerson(Factory.buildPerson("librarian")
                                    .username(newUsername).password(newPassWord));
                            sentinel = true;



                        }
                    }else {
                        System.out.println("Wrong input.\nPress 1 for user and 2 for librarian.\n");
                    }


                }else {
                    System.out.println("Your password doesn't meet the requirements.\nPlease try again.");
                }
            }else {
                System.out.println("Your username is already in use or it doesn't meet the requirements.\n" +
                        "Please use any letter or number while keeping it between 5 and 20 characters in total.");
            }

        }



    }

    public Person loginValidator(String username, String password) {
        Person account = null;


        List<Person> persons = library.getAllPersonsToList();


        for (Person user : persons) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                account = user;
            }
        }


        return account;
    }


}
