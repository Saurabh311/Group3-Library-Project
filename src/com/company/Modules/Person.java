package com.company.Modules;

import java.io.Serializable;

public class Person implements Serializable {



    protected String username;
    protected String password;
    private static final long serialVersionUID = -3065225084601467319L;//ställ fråga här


    public Person( String username, String password) {

        this.username =username;
        this.password = password;


    }

    public Person() {
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }






}
