package com.company.View.Menu.Menus;

import com.company.Modules.Library.Library;
import com.company.View.Menu.UiChoicesEnums;
import com.company.View.Menu.UIdata;

import java.util.Scanner;

public class EditLibraryBooksMenu {
    UIdata data = UIdata.getInstance();
    Library library = data.getProgram().getLibrary();

    //----PRINTS
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    //----

    public EditLibraryBooksMenu() {
    }

    public void editLibraryBooks() {
        Scanner input = new Scanner(System.in);
        String choiceInput;
        UiChoicesEnums.editLibraryBooksChoices choice = UiChoicesEnums.editLibraryBooksChoices.DEFAULT;

        while (!choice.toString().equals("GO_BACK")) {


            for (UiChoicesEnums.editLibraryBooksChoices choices : UiChoicesEnums.editLibraryBooksChoices.values()) {

                if (!choices.toString().equals("DEFAULT")) {
                    System.out.printf("Write: [%d] to: %s%n%n", choices.ordinal() + 1, choices);
                }

            }

            choiceInput = input.nextLine();
            try {

                choice = UiChoicesEnums.editLibraryBooksChoices.values()[(Integer.parseInt(choiceInput) - 1)];
            } catch (Exception ignored) {
            }

            switch (choice) {


                case ADD_BOOK -> library.getLibrarianMethods().addBook();

                case ADD_LIST_OF_BOOKS -> library.getLibrarianMethods().saveListOfBooks();

                case REMOVE_BOOK -> {
                    System.out.println("Input book title: ");
                    library.getLibrarianMethods().removeBookByTitle(input.nextLine());
                }

                case GO_BACK -> {
                }

                default -> System.out.println(RED + "[ Wrong input ]" + RESET);
            }
        }

    }

}
