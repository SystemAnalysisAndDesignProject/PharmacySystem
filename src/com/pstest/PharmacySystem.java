package com.pstest;

import com.pscontroller.LoginController;
import com.psmodel.LoginModel;
import com.psview.LoginView;

public class PharmacySystem {
    
    public static void main(String[] args)
    {
        LoginView loginView = new LoginView();
        LoginModel loginModel = new LoginModel();
        
        LoginController loginController = new LoginController(loginView,loginModel);     
        loginView.setVisible(true);
       
    }
}
