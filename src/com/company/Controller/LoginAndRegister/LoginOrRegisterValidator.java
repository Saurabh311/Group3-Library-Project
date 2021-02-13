package com.company.Controller.LoginAndRegister;

import com.company.Modules.Library.Library;
import com.company.Modules.Person;

import java.util.List;

public class LoginOrRegisterValidator {



    Library library;

    public LoginOrRegisterValidator(Library library) {
        this.library = library;
    }


    public boolean usernameValidation(String username){
        boolean usernameValidated = true;

        List<Person> persons = library.getAllPersonsToList();

        for (Person user : persons) {
            if (username.equals(user.getUsername())) {

                usernameValidated = false;
                break;
            }
        }
        if(usernameValidated){
            String validateUsernameForm = "[a-zA-Z0-9]{5,20}";
            if (!username.matches(validateUsernameForm)){
                usernameValidated = false;
            }

        }
        return usernameValidated;
    }

     public boolean passwordValidation(String password){
        boolean passwordValidated = true;

        String validatePassForm = "";
        //if (!password.matches(validatePassForm)){
          //  passwordValidated = false;
       // }
        return passwordValidated;
    }
}
