package com.company.Modules;

public class Librarian extends Person {

    public Librarian(String name, String username, String password, int age, int id) {
        super(name, username, password, age, id);
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
