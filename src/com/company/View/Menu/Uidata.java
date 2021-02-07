package com.company.View.Menu;

import com.company.Controller.Program;
import com.company.Modules.Person;

public class Uidata {
    private static Uidata uidata = null;
    private Person account;
    public Program program = new Program();

    private Uidata(){

    }

    public static Uidata getInstance(){
        if (uidata == null){
            uidata = new Uidata();

        }
        return uidata;
    }
    public void buildProgramData(){
        program.buildProgram();
    }
    public Person getAccount() {
        return account;
    }

    public void setAccount(Person account) {
        this.account = account;
    }
}
