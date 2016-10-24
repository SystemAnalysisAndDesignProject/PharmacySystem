
package com.pscontroller;

import com.psmodel.LoginModel;
import com.psmodel.MainMenuModel;
import com.psview.PharmacyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {
    
    private PharmacyView mainMenuView;
    private MainMenuModel mainMenuModel;
    
    
    public MainMenuController(PharmacyView mainMenuView, MainMenuModel mainMenuModel){
        this.mainMenuView = mainMenuView;
        this.mainMenuModel = mainMenuModel;     
        
        mainMenuView.displayMainMenu();
        
        this.mainMenuView.addModifyListener(new ModifyListener());
        this.mainMenuView.addOrderProcessListener(new OrderProcessListener());
        this.mainMenuView.addLogoutListener(new LogoutListener());
    }
    
    class ModifyListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("modify clicked");
        }             
    }
    
    class OrderProcessListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("order process clicked");
        }        
    } 
    
    class LogoutListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
           mainMenuView.displayLoginPanel();
           System.out.println("Logged Out");
        }
        
    }
}
