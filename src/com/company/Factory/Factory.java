package com.company.Factory;

import com.company.Modules.*;

public class Factory {

    public Factory() {

    }

    public Person buildPerson(String className){
        if(className == null){
            return null;
        }
        if (className.equalsIgnoreCase("PERSON")){
            return new Person();
        }
        if (className.equalsIgnoreCase("USER")){
            return new User();
        }
        if (className.equalsIgnoreCase(("LIBRARIAN"))){
            return new Librarian();
        }
        return null;
    }
    public Book buildBook(){
        return new Book();
    }
    public Library buildLibrary(){ return  new Library(); }
}
