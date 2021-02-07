package com.company.Controller;

public class UiChoicesEnums {

    public static enum librarianSwitchChoices {
        SHOW_ALL_BOOKS,
        SEARCH_BY_TITLE,
        SEARCH_BY_AUTHOR,
        ADD_BOOK,
        REMOVE_BOOK,
        SEE_ALL_BOOKS_OF_USER,
        SHOW_ALL_USERS,
        FIND_USER,
        SEE_ALL_LENT_OUT_BOOKS,
        QUIT,
        DEFAULT

    }
    public static enum userSwitchChoices {
        SHOW_ALL_BOOKS,
        SHOW_AVAILIBLE_BOOKS,
        SEARCH_BY_TITLE,
        SEARCH_BY_AUTHOR,
        BORROW_THE_BOOK,
        SEE_MY_BORROWED_BOOKS,
        RETURN_THE_BORROWED_BOOK,
        SORT_BY_TITLE,
        SORT_BY_AUTHOR,
        QUIT,
        DEFAULT

    }
    public static enum loginOrRegister{
        LOGIN,
        REGISTER,
        TERMINATE_PROGRAM,
        DEFAULT
    }

}
