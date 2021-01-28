package com.company.Controller;

import com.company.Modules.Person;
import com.company.Modules.User;

import java.util.Scanner;

public class Ui {

    Scanner input = new Scanner(System.in);
    Program program;

    public Ui(Program program) {
        this.program = program;
    }

    //login will be called first and when login is registered it will call uicheck on user

    public void loginOrRegisterUi() { // had problem with an infinite loop in our try catch when inputing a character
        

        UiChoicesEnums.loginOrRegister choice = UiChoicesEnums.loginOrRegister.DEFAULT;

        while (!choice.toString().equals("TERMINATE_PROGRAM")) {


            for (UiChoicesEnums.loginOrRegister choices : UiChoicesEnums.loginOrRegister.values()) {
                if (!choices.toString().equals("DEFAULT")){
                    System.out.printf("Write:%d to:%s%n%n", choices.ordinal(), choices);
                }


            }
            try{

                choice = UiChoicesEnums.loginOrRegister.values()[input.nextInt()];
            }catch (Exception e){


            }



            switch (choice) {

                case LOGIN:

                    Person account = program.loginOrRegister.login();
                    if (account != null) {
                        UiCheck(account);
                    }
                    break;

                case REGISTER:

                    program.loginOrRegister.register();
                    break;


                case TERMINATE_PROGRAM:

                    break;

                default:
                    System.out.println("wrong input");
            }
        }
    }

    public void UiCheck(Object person) {

        if (person instanceof User) {
            userUi();
        } else {
            librarianUi();
        }

    }


    public void userUi() {

        UiChoicesEnums.userSwitchChoices sentinel = UiChoicesEnums.userSwitchChoices.values()[0];

        while (!sentinel.toString().equals("QUIT")) {


            for (UiChoicesEnums.userSwitchChoices choices : UiChoicesEnums.userSwitchChoices.values()) {

                System.out.printf("Write:%d to:%s%n%n", choices.ordinal(), choices);

            }

            sentinel = UiChoicesEnums.userSwitchChoices.values()[input.nextInt()];


            switch (sentinel) {

                case ADD_BOOK:
                    System.out.println("add book");
                    break;

                case REMOVE_BOOK:
                    System.out.println("remove book");

                case QUIT:
                    break;
            }
        }
    }


    public void librarianUi() {

        UiChoicesEnums.librarianSwitchChoices sentinel = UiChoicesEnums.librarianSwitchChoices.values()[0];

        while (!sentinel.toString().equals("QUIT")) {


            for (UiChoicesEnums.librarianSwitchChoices choices : UiChoicesEnums.librarianSwitchChoices.values()) {

                System.out.printf("Write:%d to:%s%n%n", choices.ordinal(), choices);

            }

            sentinel = UiChoicesEnums.librarianSwitchChoices.values()[input.nextInt()];


            switch (sentinel) {

                case SEARCH_BY_TITLE:
                    program.library.searchByTitle("Red Rising");
                    break;

                case SEARCH_BY_AUTHOR:
                    program.library.searchByAuthor("Hamoodi");
                    break;

                case ADD_BOOK:
                    program.library.addBook("test","a tester book","brown",1992);
                    break;


                case QUIT:
                    break;
            }
        }
    }


}


