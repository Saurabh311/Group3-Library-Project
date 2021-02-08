package com.company.View.Menu.Menus;
import com.company.Modules.User;
import com.company.View.Menu.UiChoicesEnums;
import com.company.View.Menu.Uidata;

import java.util.Scanner;
public class EnterLibraryMenu {
    Uidata data = Uidata.getInstance();

    public EnterLibraryMenu() {

    }

    public void enterLibrary() {
        Scanner input = new Scanner(System.in);
        String choiceInput;

        UiChoicesEnums.userEnterLibraryChoices choice = UiChoicesEnums.userEnterLibraryChoices.DEFAULT;

        while (!choice.toString().equals("GO_BACK")) {


            for (UiChoicesEnums.userEnterLibraryChoices choices : UiChoicesEnums.userEnterLibraryChoices.values()) {

                if (!choices.toString().equals("DEFAULT")) {
                    System.out.printf("Write: [%d] to: %s%n%n", choices.ordinal() + 1, choices);
                }

            }
            choiceInput = input.nextLine();

            try {

                choice = UiChoicesEnums.userEnterLibraryChoices.values()[(Integer.parseInt(choiceInput) - 1)];

            } catch (Exception ignored) {
            }


            switch (choice) {

                case SHOW_ALL_BOOKS:
                    data.getProgram().getLibrary().showAllBook();
                    break;
                case SHOW_AVAILIBLE_BOOKS:
                    data.getProgram().getLibrary().getAvailableBooks().forEach(book -> System.out.println(book.getTitle()));
                    break;

                case SEARCH_BY_TITLE:
                    System.out.println("Enter the title of the book: ");
                    data.getProgram().getLibrary().searchByTitle(input.nextLine());
                    break;

                case SEARCH_BY_AUTHOR:
                    System.out.println("Enter the name of the author: ");
                    data.getProgram().getLibrary().searchByAuthor(input.nextLine());
                    break;

                case BORROW_THE_BOOK:
                    data.getProgram().getLibrary().borrowBook((User) data.getAccount());
                    break;

                case RETURN_THE_BORROWED_BOOK:
                    data.getProgram().getLibrary().returnBook((User) data.getAccount());
                    break;

                case SORT_BY_TITLE:
                    data.getProgram().getLibrary().sortByTitle();
                    break;

                case SORT_BY_AUTHOR:
                    data.getProgram().getLibrary().sortByAuthor();
                    break;

                case GO_BACK:
                    break;

                default:
                    System.out.println("Wrong input");

            }
        }
    }
}
