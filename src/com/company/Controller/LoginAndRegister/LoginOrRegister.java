package com.company.Controller.LoginAndRegister;

import com.company.Factory.Factory;
import com.company.Modules.*;

import java.util.List;
import java.util.Scanner;

public class LoginOrRegister {
    Scanner input = new Scanner(System.in);


    Library library;

    public LoginOrRegister(Library library) {
        this.library = library;
    }

    public Person login() {
        String username;
        String password;
        Person account = null;


        System.out.print("Username:");
        username = input.next();

        System.out.print("Password:");
        password = input.next();

        account = loginValidator(username, password);

        if (account != null) {
            System.out.println("login succesful");

        } else {
            System.out.println("login failed");
        }


        return account;
    }
    public void register() {
        LoginOrRegisterValidator loginOrRegisterValidator = new LoginOrRegisterValidator(library);
        String newUsername;
        String newPassWord;

        boolean sentinel = false;

        while (!sentinel){

            System.out.print("Enter your new username:");
            newUsername = input.next();
            if(loginOrRegisterValidator.usernameValidation(newUsername)==true){
                System.out.print("Password:");
                newPassWord = input.next();
                if (loginOrRegisterValidator.passwordValidation(newPassWord)==true){
                    String choice;
                    //int choiceToInt = 0;

                    System.out.println("if you are a user write[1] librarian[2]");
                    choice = input.next();
                    if (choice.matches("1|2")){

                        if (Integer.valueOf(choice) ==1){


                            library.addPerson(Factory.buildPerson("user")
                                    .username(newUsername).password(newPassWord));
                            sentinel = true;
                        }
                        if (Integer.valueOf(choice) ==2){

                            //  old way:  Librarian librarian = new Librarian(newUsername,newPassWord);
                            library.addPerson(Factory.buildPerson("librarian")
                                    .username(newUsername).password(newPassWord));
                            sentinel = true;



                        }
                    }else {
                        System.out.println("Wrong input");
                    }


                }else {
                    System.out.println("password format was wrong");
                }
            }else {
                System.out.println("username is wrong or allredy exists try again");
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
