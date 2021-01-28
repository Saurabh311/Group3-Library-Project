package com.company.Modules;

import java.io.Serializable;

public class User extends Person implements Serializable {
    //  List<Object> borrowedBooks = ArrayList;
    String email;

    public User(String name, String email, String username, String password, int age, int id) {
        super(name, username, password, age, id);
        this.email = email;

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", email=" + email +
                '}';
    }
}
