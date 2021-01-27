package com.company.Modules;

public class Librarian extends Person {

    public Librarian(String name, int age, int id) {
        super(name, age, id);
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
