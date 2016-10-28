package com.psview;

import com.psmodel.product.Drug;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PharmacyView extends JFrame {
    
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    
    private LoginPanel loginPanel;
    private MainMenuPanel mainMenuPanel;
    private ModifyPanel modifyPanel;
    private SalesReportPanel salesReportPanel;
    private boolean customerBtnClicked = true;
    
    
    public PharmacyView()
    {
        super("Pharmacy System");
        loginPanel = new LoginPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);        
        this.setLocationRelativeTo(null);
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
    
    public void displayMainMenuManager(){
        
        mainMenuPanel = new MainMenuPanel();
        loginPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(Color.red);
        mainMenuPanel.setWelcomeLbl("Welcome Manager");
        mainMenuPanel.salesReportBtnVisibility(true);
    }
    
    public void displayMainMenuEmployee(){
        mainMenuPanel = new MainMenuPanel();
        loginPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(Color.blue);
        mainMenuPanel.setWelcomeLbl("Welcome Employee");
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
    
    public void displayLoginPanel(){
        mainMenuPanel.setVisible(false);
        this.add(loginPanel);
        loginPanel.setVisible(true);
        loginPanel.clearPanel();
    }
        
    public void displayTable(String[] columns, Object [][] drugs){
        modifyPanel.displayTable(columns,drugs);        
    }
    
    public void displayMainMenuManagerFromModify(){
        modifyPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(Color.red);
        mainMenuPanel.setWelcomeLbl("Welcome Manager");
    }
    
    public void displayMainMenuEmployeeFromModify(){
        modifyPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(Color.blue);
        mainMenuPanel.setWelcomeLbl("Welcome Employee");
    }
    
    //Modify Panel
    
    public void displayModifyManager(){
        modifyPanel = new ModifyPanel();
        mainMenuPanel.setVisible(false);        
        this.add(modifyPanel);        
        modifyPanel.setVisible(true);
        modifyPanel.setBackground(Color.red);
    }
    
    public void displayModifyEmployee(){
        modifyPanel = new ModifyPanel();
        modifyPanel.setVisibilityForEmployee();
        mainMenuPanel.setVisible(false);        
        this.add(modifyPanel);        
        modifyPanel.setVisible(true);
        modifyPanel.setBackground(Color.blue);
    }
    
    public void displaySalesReport(){
       salesReportPanel = new SalesReportPanel();
       mainMenuPanel.setVisible(false);
       this.add(salesReportPanel);
       salesReportPanel.setVisible(true);
       salesReportPanel.setBackground(Color.red);
    }
    
    public void setVisibilityForCustomer(){
        modifyPanel.setVisibilityForCustomerDetails(customerBtnClicked);
        customerBtnClicked = !customerBtnClicked;
    }
    
    public void addCustomerListener(ActionListener listenerForCustomerBtn){
        modifyPanel.addCustomerListener(listenerForCustomerBtn);
    }
    
    public void addManagerListener(ActionListener listenerForManagerBtn){
        modifyPanel.addManagerListener(listenerForManagerBtn);
    }
    
    public void addEmployeeListener(ActionListener listenerForEmployeeBtn){
        modifyPanel.addEmployeeListener(listenerForEmployeeBtn);
    }
    
    public void addProductListener(ActionListener listenerForProductBtn){
        modifyPanel.addProductListener(listenerForProductBtn);
    }
    
    public void addBackToMenuListener(ActionListener listenerForBackToMenuBtn){
        modifyPanel.addBackToMenuListener(listenerForBackToMenuBtn);
    }
    
    public void addSalesReportsListener(ActionListener listenerForSalesReportBtn){
        mainMenuPanel.addSalesReportsListener(listenerForSalesReportBtn);
    }

}
