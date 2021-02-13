package com.company.Factory;

import com.company.Modules.*;
import com.company.Modules.Library.Library;

public abstract class Factory {

    public Factory() {

    }

    public static Person buildPerson(String className){
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
    public static Book buildBook(){
        return new Book();
    }
    public static Library buildLibrary(){ return  new Library(); }
}
