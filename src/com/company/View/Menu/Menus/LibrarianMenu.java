package com.company.View.Menu.Menus;

import com.company.View.Menu.UiChoicesEnums;
import com.company.View.Menu.UIdata;

import java.util.Scanner;

public class LibrarianMenu {
    UIdata data = UIdata.getInstance();
    EditLibraryBooksMenu editLibraryBooksMenu = new EditLibraryBooksMenu();
    AfterShowAllBooks afterShowAllBooks = new AfterShowAllBooks();

    //----PRINTS
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    //----

    public LibrarianMenu(){ }

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
                case SHOW_ALL_BOOKS ->
                        { data.getProgram().getLibrary().showAllBook();
                        afterShowAllBooks.afterShowAllBooks(); }

                case SEARCH_BY_TITLE ->
                        { System.out.println("Input book title: ");
                        data.getProgram().getLibrary().searchByTitle(input.nextLine()); }

                case SEARCH_BY_AUTHOR ->
                        { System.out.println("Input book author: ");
                        data.getProgram().getLibrary().searchByAuthor(input.nextLine()); }

                case EDIT_LIBRARY_BOOKS -> editLibraryBooksMenu.editLibraryBooks();

                case SEE_ALL_BOOKS_OF_USER ->
                        { System.out.println("Input username: ");
                        data.getProgram().pAllBooksOfUser(input.nextLine()); }

                case SHOW_ALL_USERS -> data.getProgram().getLibrary().printUsers();

                case FIND_USER -> data.getProgram().getLibrary().findUser();

                case SEE_ALL_LENT_OUT_BOOKS -> data.getProgram().getLibrary().showAllLentBooks();

                case QUIT -> {}

                default -> System.out.println(RED + "[ Wrong input ]" + RESET);
            }
        }

    }
}
