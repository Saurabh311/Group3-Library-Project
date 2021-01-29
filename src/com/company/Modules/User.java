package com.company.Modules;

import java.io.Serializable;

public class User extends Person implements Serializable {
    //  List<Object> borrowedBooks = ArrayList;
    String email = null;

    public User( String username, String password) {
        super( username, password);


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
