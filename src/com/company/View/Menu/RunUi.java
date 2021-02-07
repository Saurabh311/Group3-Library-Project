package com.company.View.Menu;

import com.company.View.Menu.Menus.LoginOrRegisterMenu;

public class RunUi {

    LoginOrRegisterMenu loginOrRegisterMenu = new LoginOrRegisterMenu();

    public RunUi() {
    }

    public void startUi(){
        Uidata.getInstance().buildProgramData();
        loginOrRegisterMenu.loginOrRegisterUi();
    }
}
