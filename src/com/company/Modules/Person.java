package com.company.Modules;

import java.io.Serializable;

public class Person implements Serializable {


    String name;
    String username;
    String password;
    int age;
    int id;


    public Person(String name, String username, String password, int age, int id) {
        this.name = name;
        this.username =username;
        this.password = password;
        this.age = age;
        this.id = id;

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
