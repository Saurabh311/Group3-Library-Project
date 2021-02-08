package com.company.Modules;

import java.io.Serializable;

public class Person implements Serializable {


    protected String username;
    protected String password;
    private static final long serialVersionUID = -3065225084601467319L;


    public Person() { }

    public Person username(String username) {
        this.username = username;
        return this;
    }

    public Person password(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
