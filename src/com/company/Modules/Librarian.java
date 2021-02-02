package com.company.Modules;

public class Librarian extends Person {

    public Librarian( String username, String password) {
        super( username, password);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


