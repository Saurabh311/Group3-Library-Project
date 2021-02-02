package com.company.Controller.LoginAndRegister;

import com.company.Modules.Librarian;
import com.company.Modules.Library;
import com.company.Modules.Person;
import com.company.Modules.User;

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
        RegisterValidator registerValidator = new RegisterValidator(library);
        String newUsername;
        String newPassWord;

        boolean sentinel = false;

        while (!sentinel){

            System.out.print("Enter your new username:");
            newUsername = input.next();
            if(registerValidator.usernameValidation(newUsername)==true){
                System.out.print("Password:");
                newPassWord = input.next();
                if (registerValidator.passwordValidation(newPassWord)==true){
                    String choice;
                    int choiceToInt = 0;

                    System.out.println("if you are a user write[1] librarian[2]");
                    choice = input.next();
                    if (choice.matches("1|2")){
                       choiceToInt = Integer.valueOf(choice);
                    }else {
                        System.out.println("Wrong input");
                    }

                    if (choiceToInt ==1){
                        User user = new User(newUsername,newPassWord);
                        library.addPerson(user);
                        sentinel = true;
                    }
                     if (choiceToInt ==2){
                         Librarian librarian = new Librarian(newUsername,newPassWord);
                         library.addPerson(librarian);
                         sentinel = true;


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
