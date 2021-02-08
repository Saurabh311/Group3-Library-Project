package com.company.View.Menu.Menus;

import com.company.View.Menu.UiChoicesEnums;
import com.company.View.Menu.Uidata;

import java.util.Scanner;

public class LibrarianMenu {
    Uidata data = Uidata.getInstance();
    EditLibraryBooksMenu editLibraryBooksMenu = new EditLibraryBooksMenu();


    public LibrarianMenu(){

    }
    public void librarianMenu(){
        Scanner input = new Scanner(System.in);
        String choiceInput;
        UiChoicesEnums.librarianSwitchChoices choice = UiChoicesEnums.librarianSwitchChoices.DEFAULT;

        while (!choice.toString().equals("QUIT")) {


            for (UiChoicesEnums.librarianSwitchChoices choices : UiChoicesEnums.librarianSwitchChoices.values()) {

                if (!choices.toString().equals("DEFAULT")){
                    System.out.printf("Write: [%d] to: %s%n%n", choices.ordinal()+1, choices);
                }

            }

            choiceInput = input.nextLine();
            try{

                choice = UiChoicesEnums.librarianSwitchChoices.values()[(Integer.parseInt(choiceInput) -1)];
            }catch (Exception ignored){ }

            switch (choice) {
                case SHOW_ALL_BOOKS:
                    data.getProgram().getLibrary().showAllBook();
                    break;

                case SEARCH_BY_TITLE:
                    System.out.println("Input book title: ");
                    data.getProgram().getLibrary().searchByTitle(input.nextLine());
                    break;

                case SEARCH_BY_AUTHOR:
                    System.out.println("Input book author: ");
                    data.getProgram().getLibrary().searchByAuthor(input.nextLine());
                    break;
                case EDIT_LIBRARY_BOOKS:
                    editLibraryBooksMenu.editLibraryBooks();

                    break;


                case SEE_ALL_BOOKS_OF_USER:
                    System.out.println("Input username: ");
                    data.getProgram().pAllBooksOfUser(input.nextLine());
                    break;

                case SHOW_ALL_USERS:
                    data.getProgram().getLibrary().printUsers();
                    break;

                case FIND_USER:
                    data.getProgram().getLibrary().findUser();
                    break;

                case SEE_ALL_LENT_OUT_BOOKS:
                    data.getProgram().getLibrary().showAllLentBooks();
                    break;

                case QUIT:
                    break;

                default:
                    System.out.println("Wrong input");
            }
        }

    }
}
