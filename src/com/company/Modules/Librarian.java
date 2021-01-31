package com.company.Modules;

public class Librarian extends Person {

    public Librarian( String username, String password) {
        super( username, password);
    }


    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

}
