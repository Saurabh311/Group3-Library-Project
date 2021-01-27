package com.company.Modules;

import java.io.Serializable;

public class User extends Person implements Serializable {
  //  List<Object> borrowedBooks = ArrayList;
    String email;

    public User(String name,String email, int age, int id) {
        super(name, age, id);
        this.email = email;

    }





}
