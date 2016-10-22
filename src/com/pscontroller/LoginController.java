package com.pscontroller;

import com.psmodel.LoginModel;
import com.psmodel.MainMenuModel;
import com.psview.LoginView;
import com.psview.MainMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    
    private LoginView loginView;
    private LoginModel loginModel;
    
    public LoginController(LoginView loginView,LoginModel loginModel){
        this.loginView = loginView;
        this.loginModel = loginModel;
        
        this.loginView.addLoginListener(new LoginListener());
    }   
    
    class LoginListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username, password;
            
            try{
                username = loginView.getUsername();
                password = loginView.getPassword();
            
                boolean userExists = loginModel.Validate(username, password);
                
                if(!userExists)
                {
                    loginView.displayErrorMessage("Invalid Username or Password");
                }else{
                    MainMenuView mainMenuView = new MainMenuView();
                    MainMenuModel mainMenuModel = new MainMenuModel();
                    
                    MainMenuController mainMenuController = new MainMenuController(mainMenuView,mainMenuModel);
                    
                    loginView.clearPanel();
                    mainMenuView.setVisible(true);
                    
                }
            }catch(Exception ex){
                loginView.displayErrorMessage("Invalid Username or Password");
            }
            
        }
        
    }
}
