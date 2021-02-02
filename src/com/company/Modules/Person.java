package com.company.Modules;

import java.io.Serializable;

public class Person implements Serializable {



    protected String username;
    protected String password;



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
