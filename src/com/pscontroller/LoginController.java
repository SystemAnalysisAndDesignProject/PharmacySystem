package com.pscontroller;

import com.psmodel.LoginModel;
import com.psmodel.MainMenuModel;
import com.psview.MainMenuPanel;
import com.psview.PharmacyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    
    private PharmacyView loginView;
    private LoginModel loginModel;
    
    public LoginController(PharmacyView loginView,LoginModel loginModel){
        this.loginView = loginView;
        this.loginModel = loginModel;

        this.loginView.addLoginListener(new LoginListener());
    }   
    
    class LoginListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
                String username, password;    
                
                username = loginView.getUsername();
                password = loginView.getPassword();            
                boolean userExists = loginModel.Validate(username, password);
                
                if(!userExists)
                {
                    loginView.displayErrorMessage("Invalid Username or Password");
                }else{                     
                    MainMenuModel mainMenuModel = new MainMenuModel(loginModel.getDataBase());                    
                    MainMenuController mainMenuController = new MainMenuController(loginView,mainMenuModel);                  
                }          
        }
        
    }
}
