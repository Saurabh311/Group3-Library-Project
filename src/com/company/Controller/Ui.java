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
        
        String choiceInput;
        UiChoicesEnums.loginOrRegister choice = UiChoicesEnums.loginOrRegister.DEFAULT;

        while (!choice.toString().equals("TERMINATE_PROGRAM")) {


            for (UiChoicesEnums.loginOrRegister choices : UiChoicesEnums.loginOrRegister.values()) {
                if (!choices.toString().equals("DEFAULT")){
                    System.out.printf("Write:%d to:%s%n%n", choices.ordinal(), choices);
                }


            }
            choiceInput = input.nextLine();
            try{

                choice = UiChoicesEnums.loginOrRegister.values()[Integer.valueOf(choiceInput)];
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
                    program.saveData();
                    System.out.println("data saved");
                    break;

                default:
                    System.out.println("Wrong input");
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
        String choiceInput;

        UiChoicesEnums.userSwitchChoices choice = UiChoicesEnums.userSwitchChoices.DEFAULT;

        while (!choice.toString().equals("QUIT")) {


            for (UiChoicesEnums.userSwitchChoices choices : UiChoicesEnums.userSwitchChoices.values()) {

                if (!choices.toString().equals("DEFAULT")){
                    System.out.printf("Write:%d to:%s%n%n", choices.ordinal(), choices);
                }

            }
            choiceInput = input.nextLine();

            try{

                choice = UiChoicesEnums.userSwitchChoices.values()[Integer.valueOf(choiceInput)];
            }catch (Exception e){


            }


            switch (choice) {
                case SHOW_ALL_BOOKS:
                    program.library.showAllBook();
                    break;

                case SEARCH_BY_TITLE:
                    System.out.println("Write title of book");
                    program.library.searchByTitle(input.nextLine());
                    break;

                case SEARCH_BY_AUTHOR:
                    System.out.println("Write the name of author ");
                    program.library.searchByAuthor(input.nextLine());
                    break;

                case QUIT:
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }


    public void librarianUi() {

        String choiceInput;
        UiChoicesEnums.librarianSwitchChoices choice = UiChoicesEnums.librarianSwitchChoices.DEFAULT;

        while (!choice.toString().equals("QUIT")) {


            for (UiChoicesEnums.librarianSwitchChoices choices : UiChoicesEnums.librarianSwitchChoices.values()) {

                if (!choices.toString().equals("DEFAULT")){
                    System.out.printf("Write:%d to:%s%n%n", choices.ordinal(), choices);
                }

            }

            choiceInput = input.nextLine();
            try{

                choice = UiChoicesEnums.librarianSwitchChoices.values()[Integer.valueOf(choiceInput)];
            }catch (Exception e){


            }




            switch (choice) {
                case SHOW_ALL_BOOKS:
                    program.library.showAllBook();
                    break;

                case SEARCH_BY_TITLE:
                    System.out.println("Write title of book");
                    program.library.searchByTitle(input.nextLine());
                    break;

                case SEARCH_BY_AUTHOR:
                    System.out.println("Write the name of author ");
                    program.library.searchByAuthor(input.nextLine());
                    break;

                case ADD_BOOK:
                    program.library.addBook();
                    break;

                case REMOVE_BOOK:
                    //program.library.addBook("test","a tester book","brown",1992);
                    break;

                case SEE_ALL_BOOKS_OF_USER:
                    System.out.println("Write username of user");
                    program.pAllBooksOfUser(input.nextLine());
                    break;

                case SHOW_ALL_USERS:
                    program.library.printUsers();
                    break;

                case QUIT:
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }


}


