package com.company.View.Menu.Menus;

import com.company.Modules.Person;
import com.company.Modules.User;
import com.company.View.Menu.UiChoicesEnums;
import com.company.View.Menu.UIdata;

import java.util.Scanner;

public class LoginOrRegisterMenu {
    UserMenu userMenu = new UserMenu();
    LibrarianMenu librarianMenu = new LibrarianMenu();
    UIdata data = UIdata.getInstance();
    Scanner input = new Scanner(System.in);

    //----PRINTS
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    //----

    public void loginOrRegisterUi() {
        String choiceInput;

        UiChoicesEnums.loginOrRegister choice = UiChoicesEnums.loginOrRegister.DEFAULT;

        while (!choice.toString().equals("TERMINATE_PROGRAM")) {


            for (UiChoicesEnums.loginOrRegister choices : UiChoicesEnums.loginOrRegister.values()) {
                if (!choices.toString().equals("DEFAULT")) {
                    System.out.printf("Write: [%d] to: %s%n%n", choices.ordinal() + 1, choices);
                }

            }

            choiceInput = input.nextLine();
            try {

                choice = UiChoicesEnums.loginOrRegister.values()[(Integer.parseInt(choiceInput) - 1)];
            } catch (Exception ignored) {
            }


            switch (choice) {
                case LOGIN -> {
                    Person account = data.getProgram().getLoginOrRegister().login();
                    if (account != null) {
                        data.setAccount(account);
                        menuChoice(data.getAccount());
                    }
                }
                case REGISTER -> data.getProgram().getLoginOrRegister().register();

                case TERMINATE_PROGRAM -> data.getProgram().saveData();

                default -> System.out.println(RED + "[ Wrong input ]" + RESET);
            }
        }


    }

    public void menuChoice(Object person) {

        if (person instanceof User) {
            userMenu.userMenu();

        } else {
            librarianMenu.librarianMenu();
        }

    }
}
