package com.psview;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PharmacyView extends JFrame {
    
    private final int WIDTH = 800;
    private final int HEIGHT = 600; 
    private LoginPanel loginPanel;
    private MainMenuPanel mainMenuPanel;
    
    public PharmacyView()
    {
        loginPanel = new LoginPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);        
        this.add(loginPanel);
    }

    //Login Panel
    
   public String getUsername(){
        return loginPanel.getUsernameTxt();
    }
    
    public String getPassword(){
        return loginPanel.getPassword();
    }
    
    public void addLoginListener(ActionListener listenerForLoginBtn){
        loginPanel.addLoginListener(listenerForLoginBtn);
    }
    
    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }  
    
    public void clearPanel(){
        this.removeAll();
    }
    
    public JPanel getLoginPanel()
    {
        return loginPanel;
    }
    
    public void displayMainMenu()
    {
        mainMenuPanel = new MainMenuPanel();
        loginPanel.setVisible(false);        
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
    }   
    
    //Main Menu Panel    
    public void addModifyListener(ActionListener listenerForModifyBtn){
        mainMenuPanel.addModifyListener(listenerForModifyBtn);
    }
    
    public void addOrderProcessListener(ActionListener listenerForOrderProcessBtn){
        mainMenuPanel.addOrderProcessListener(listenerForOrderProcessBtn);
    }
    
    public void addLogoutListener(ActionListener listenerForLogoutBtn){
        mainMenuPanel.addLogoutListener(listenerForLogoutBtn);
    }
    
    public void displayLoginPanel()
    {
        //loginPanel = new LoginPanel();
        mainMenuPanel.setVisible(false);
        this.add(loginPanel);
        loginPanel.setVisible(true);
        loginPanel.clearPanel();
    }
    
}
