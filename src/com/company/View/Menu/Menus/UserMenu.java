package com.company.View.Menu.Menus;

import com.company.Modules.User;
import com.company.View.Menu.UiChoicesEnums;
import com.company.View.Menu.Uidata;

import java.util.Scanner;

public class UserMenu {
    Uidata data = Uidata.getInstance();
    EnterLibraryMenu enterLibraryMenu = new EnterLibraryMenu();

    public UserMenu() {

    }

    public void userMenu(){
    data.getProgram().getLibrary().sendReminder((User) data.getAccount());
    String choiceInput;
    Scanner input = new Scanner(System.in);
    UiChoicesEnums.userSwitchChoices choice = UiChoicesEnums.userSwitchChoices.DEFAULT;

        while (!choice.toString().equals("QUIT")) {


        for (UiChoicesEnums.userSwitchChoices choices : UiChoicesEnums.userSwitchChoices.values()) {

            if (!choices.toString().equals("DEFAULT")){
                System.out.printf("Write:%d to:%s%n%n", choices.ordinal()+1, choices);
            }

        }
        choiceInput = input.nextLine();
        try{

            choice = UiChoicesEnums.userSwitchChoices.values()[(Integer.parseInt(choiceInput) -1)];

        }catch (Exception ignored){ }


        switch (choice) {
            case ENTER_LIBRARY:
                enterLibraryMenu.enterLibrary();
                break;


            case SEE_MY_BORROWED_BOOKS:

                ((User) data.getAccount()).printBorrowedBooks();
                break;

            case QUIT:
                break;

            default:
                System.out.println("Wrong input");
        }
    }
    }

}

