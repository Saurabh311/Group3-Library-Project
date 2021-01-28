package com.company.Controller;

import com.company.Modules.User;

import java.util.Scanner;

public class Ui {

    Scanner input = new Scanner(System.in);
    Program program;

    public Ui(Program program) {
        this.program = program;
    }

    //login will be called first and when login is registered it will call uicheck on user
    public void UiCheck(Object person){

        if (person instanceof User){
            userUi();
        }else{
            librarianUi();
        }

    }



    public void userUi(){

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



    public void librarianUi(){

       UiChoicesEnums.librarianSwitchChoices sentinel = UiChoicesEnums.librarianSwitchChoices.values()[0];

        while (!sentinel.toString().equals("QUIT")) {


            for (UiChoicesEnums.librarianSwitchChoices choices : UiChoicesEnums.librarianSwitchChoices.values()) {

                System.out.printf("Write:%d to:%s%n%n", choices.ordinal(), choices);

            }

            sentinel = UiChoicesEnums.librarianSwitchChoices.values()[input.nextInt()];


            switch (sentinel) {

                case SEE_ALL_BOOKS_AVAILIBLE:
                    System.out.println("see all books");
                    break;

                case SEARCH_USER:
                    System.out.println("remove book");

                case QUIT:
                    break;
            }
        }
    }

    public void loginOrRegisterUi(){

        UiChoicesEnums.loginOrRegister sentinel = UiChoicesEnums.loginOrRegister.values()[0];

        while (!sentinel.toString().equals("TERMINATE_PROGRAM")) {


            for (UiChoicesEnums.loginOrRegister choices : UiChoicesEnums.loginOrRegister.values()) {

                System.out.printf("Write:%d to:%s%n%n", choices.ordinal(), choices);

            }

            sentinel = UiChoicesEnums.loginOrRegister.values()[input.nextInt()];


            switch (sentinel) {

                case LOGIN:

                    Program.login();
                    break;

                case REGISTER:

                    Program.register();

                case TERMINATE_PROGRAM:
                    break;
            }
        }
    }
}


