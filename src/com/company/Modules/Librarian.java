package com.company.Modules;

import java.io.Serial;

public class Librarian extends Person {
    @Serial
    private static final long serialVersionUID = 196915972624694118L;

    public Librarian() {

    }

    @Override
    public String toString() {
        return "Librarian{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


