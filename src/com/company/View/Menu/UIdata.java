package com.company.View.Menu;

import com.company.Controller.Program;
import com.company.Modules.Person;

public class UIdata {
    private static UIdata uidata = null;
    private Person account;
    private Program program = new Program();

    private UIdata(){

    }
    public Program getProgram() {
        return program;
    }

    public static UIdata getInstance(){
        if (uidata == null){
            uidata = new UIdata();

        }
        return uidata;
    }
    public UIdata setProgram (Program program){
        this.program = program;
        return this;
    }

    public Person getAccount() {
        return account;
    }

    public void setAccount(Person account) {
        this.account = account;
    }
}
