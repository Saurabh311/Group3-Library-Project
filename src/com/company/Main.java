package com.company;

import com.company.Controller.Program;
import com.company.View.Menu.RunUi;
import com.company.View.Menu.UIdata;

public class Main {

    public static void main(String[] args) {

        Program program = new Program();
        program.buildProgram();
        UIdata.getInstance().setProgram(program);
        new RunUi().startUi();



    }
}
