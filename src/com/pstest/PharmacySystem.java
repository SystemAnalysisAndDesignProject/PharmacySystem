package com.pstest;

import com.pscontroller.LoginController;
import com.psmodel.LoginModel;
import com.psview.PharmacyView;

public class PharmacySystem {
    
    public static void main(String[] args)
    {
        PharmacyView pharmacyView = new PharmacyView();
        LoginModel loginModel = new LoginModel();
        
        LoginController loginController = new LoginController(pharmacyView,loginModel);     
        pharmacyView.setVisible(true);
       
    }
}
