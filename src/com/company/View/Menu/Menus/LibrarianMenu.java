package com.company.View.Menu.Menus;

import com.company.Modules.Library.LibrarianMethods;
import com.company.Modules.Library.Library;
import com.company.View.Menu.UiChoicesEnums;
import com.company.View.Menu.UIdata;

import java.util.Scanner;

public class LibrarianMenu {
    UIdata data = UIdata.getInstance();
    EditLibraryBooksMenu editLibraryBooksMenu = new EditLibraryBooksMenu();
    AfterShowAllBooks afterShowAllBooks = new AfterShowAllBooks();
    Library library = data.getProgram().getLibrary();

    //----PRINTS
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    //----

    public LibrarianMenu() {
    }

    public void librarianMenu() {
        Scanner input = new Scanner(System.in);
        String choiceInput;
        UiChoicesEnums.librarianSwitchChoices choice = UiChoicesEnums.librarianSwitchChoices.DEFAULT;

        while (!choice.toString().equals("QUIT")) {


            for (UiChoicesEnums.librarianSwitchChoices choices : UiChoicesEnums.librarianSwitchChoices.values()) {

                if (!choices.toString().equals("DEFAULT")) {
                    System.out.printf("Write: [%d] to: %s%n%n", choices.ordinal() + 1, choices);
                }

            }

            choiceInput = input.nextLine();
            try {

                choice = UiChoicesEnums.librarianSwitchChoices.values()[(Integer.parseInt(choiceInput) - 1)];
            } catch (Exception ignored) {
            }

            switch (choice) {
                case SHOW_ALL_BOOKS -> {
                    library.getPrints().showAllBook();
                    afterShowAllBooks.afterShowAllBooks();
                }

                case SEARCH_BY_TITLE -> {
                    System.out.println("Input book title: ");
                    library.getPrints().searchByTitle(input.nextLine());
                }

                case SEARCH_BY_AUTHOR -> {
                    System.out.println("Input book author: ");
                    library.getPrints().searchByAuthor(input.nextLine());
                }

                case EDIT_LIBRARY_BOOKS -> editLibraryBooksMenu.editLibraryBooks();

                case SEE_ALL_BOOKS_OF_USER -> {
                    System.out.println("Input username: ");
                    library.getPrints().pAllBooksOfUser(input.nextLine());
                }

                case SHOW_ALL_USERS -> library.getLibrarianMethods().printUsers();  //finished

                case FIND_USER -> library.getLibrarianMethods().findUser(); //finished

                case SEE_ALL_LENT_OUT_BOOKS -> library.getLibrarianMethods().showAllLentBooks();  //finished

                case QUIT -> {
                }

                default -> System.out.println(RED + "[ Wrong input ]" + RESET);
            }
        }

    }
}
