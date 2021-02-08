package com.company.View.Menu.Menus;

import com.company.View.Menu.UiChoicesEnums;
import com.company.View.Menu.Uidata;
import java.util.Scanner;
public class EditLibraryBooksMenu {
    Uidata data = Uidata.getInstance();

    public EditLibraryBooksMenu() {
    }
    public void editLibraryBooks() {
        Scanner input = new Scanner(System.in);
        String choiceInput;
        UiChoicesEnums.editLibraryBooksChoices choice = UiChoicesEnums.editLibraryBooksChoices.DEFAULT;

        while (!choice.toString().equals("GO_BACK")) {


            for (UiChoicesEnums.editLibraryBooksChoices choices : UiChoicesEnums.editLibraryBooksChoices.values()) {

                if (!choices.toString().equals("DEFAULT")) {
                    System.out.printf("Write:%d to:%s%n%n", choices.ordinal() + 1, choices);
                }

            }

            choiceInput = input.nextLine();
            try {

                choice = UiChoicesEnums.editLibraryBooksChoices.values()[(Integer.parseInt(choiceInput) - 1)];
            } catch (Exception ignored) {
            }

            switch (choice) {


                case ADD_BOOK:
                    data.getProgram().getLibrary().addBook();
                    break;
                case ADD_LIST_OF_BOOKS:
                    data.getProgram().getLibrary().saveListOfBooks();
                    break;

                case REMOVE_BOOK:
                    System.out.println("Please insert the title of Book");
                    data.getProgram().getLibrary().removeBookByTitle(input.nextLine());
                    break;

                case GO_BACK:
                    break;

                default:
                    System.out.println("Wrong input");
            }
        }

    }

}
