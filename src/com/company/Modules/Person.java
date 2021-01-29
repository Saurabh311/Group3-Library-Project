package com.company.Modules;

import java.io.Serializable;

public class Person implements Serializable {


    String name = null;
    String username;
    String password;
    int age =0 ;
    int id =0;


    public Person( String username, String password) {

        this.username =username;
        this.password = password;


    }

    public Person() {
    }


    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

}
