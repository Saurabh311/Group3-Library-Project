package com.company.View.Menu.Menus;
import com.company.Modules.User;
import com.company.View.Menu.UiChoicesEnums;
import com.company.View.Menu.UIdata;

import java.util.Scanner;
public class EnterLibraryMenu {
    UIdata data = UIdata.getInstance();
    AfterShowAllBooks afterShowAllBooks = new AfterShowAllBooks();

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

                case SHOW_ALL_BOOKS ->
                        { data.getProgram().getLibrary().showAllBook();
                        afterShowAllBooks.afterShowAllBooks(); }

                case SHOW_AVAILABLE_BOOKS ->
                        {data.getProgram().getLibrary().getAvailableBooks().forEach(book -> System.out.println(book.toString()));
                            System.out.println(" ");}

                case SEARCH_BY_TITLE ->
                        {System.out.println("Enter the title of the book: ");
                        data.getProgram().getLibrary().searchByTitle(input.nextLine()); }

                case SEARCH_BY_AUTHOR ->
                        { System.out.println("Enter the name of the author: ");
                        data.getProgram().getLibrary().searchByAuthor(input.nextLine()); }

                case BORROW_THE_BOOK -> data.getProgram().getLibrary().borrowBook((User) data.getAccount());

                case RETURN_THE_BORROWED_BOOK -> data.getProgram().getLibrary().returnBook((User) data.getAccount());

                case GO_BACK -> {}

                default -> System.out.println("Wrong input");

            }
        }
    }
}
