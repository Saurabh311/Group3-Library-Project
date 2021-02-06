package com.company.Controller;

public class UiChoicesEnums {

    public static enum librarianSwitchChoices {
        SHOW_ALL_BOOKS,
        SEARCH_BY_TITLE,
        SEARCH_BY_AUTHOR,
        EDIT_LIBRARY_BOOKS,
        SEE_ALL_BOOKS_OF_USER,
        SHOW_ALL_USERS,
        FIND_USER,
        SEE_ALL_LENT_OUT_BOOKS,
        QUIT,
        DEFAULT

    }
    public static enum editLibraryBooksChoices {
        ADD_BOOK,
        ADD_LIST_OF_BOOKS,
        REMOVE_BOOK,
        GO_BACK,
        DEFAULT
    }
    public static enum userSwitchChoices {

        ENTER_LIBRARY,
        SEE_MY_BORROWED_BOOKS,
        QUIT,
        DEFAULT

    }
    public static enum userEnterLibraryChoices{
        SHOW_ALL_BOOKS,
        SHOW_AVAILIBLE_BOOKS,
        SEARCH_BY_TITLE,
        SEARCH_BY_AUTHOR,
        BORROW_THE_BOOK,
        GO_BACK,
        DEFAULT
    }
    public static enum loginOrRegister{
        LOGIN,
        REGISTER,
        TERMINATE_PROGRAM,
        DEFAULT
    }
}
