package com.company;

import com.company.Controller.Program;
import com.company.Controller.Ui;

public class Main {

    public static void main(String[] args) {
        Program program = new Program();
        program.run();
        Ui ui = new Ui(program);
        ui.loginOrRegisterUi();
    }
}
