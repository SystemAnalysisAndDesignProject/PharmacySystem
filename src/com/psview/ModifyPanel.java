package com.psview;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModifyPanel extends JPanel{
    
    private JButton customerBtn;
    private JButton managerBtn;
    private JButton employeeBtn;
    private JButton productBtn;
    private JButton backToMenuBtn;
    private JTextField firstNameTxt;
    private JTextField lastNameTxt;
    //private JTextField nameTxt;
   // private JTextField nameTxt;
    
    public ModifyPanel()
    {
        customerBtn = new JButton("Customer");
        managerBtn = new JButton("Manager");
        employeeBtn = new JButton("Employee");
        productBtn = new JButton("Product");
        backToMenuBtn = new JButton("Back To Main Menu");
        
        customerBtn.setBounds(20, 20, 150, 20);
        managerBtn.setBounds(200, 20, 150, 20);
        employeeBtn.setBounds(380, 20, 150, 20);
        productBtn.setBounds(510, 20, 150, 20);
        backToMenuBtn.setBounds(510, 500, 150, 20);
        
        this.add(customerBtn);
        this.add(managerBtn);
        this.add(employeeBtn);
        this.add(productBtn);
        this.add(backToMenuBtn);
    }
    
    public void setVisibilityForEmployee(){
        managerBtn.setVisible(false);
        employeeBtn.setVisible(false);
        productBtn.setVisible(false);        
    }
    
    public void setVisibilityForCustomerDetails(boolean vis){
        firstNameTxt = new JTextField(20);
        lastNameTxt = new JTextField(20);
        
        firstNameTxt.setBounds(20,40,150,20);
        lastNameTxt.setBounds(20,60,150,20);
        this.add(firstNameTxt);
        this.add(lastNameTxt);
        
        firstNameTxt.setVisible(vis);        
        lastNameTxt.setVisible(vis);
    }
    
    public void addCustomerListener(ActionListener listenerForCustomerBtn){
        customerBtn.addActionListener(listenerForCustomerBtn);
    }
    
    public void addManagerListener(ActionListener listenerForManagerBtn){
        managerBtn.addActionListener(listenerForManagerBtn);
    }
    
    public void addEmployeeListener(ActionListener listenerForEmployeeBtn){
        employeeBtn.addActionListener(listenerForEmployeeBtn);
    }
    
    public void addProductListener(ActionListener listenerForProductBtn){
        productBtn.addActionListener(listenerForProductBtn);
    }
    
    public void addBackToMenuListener(ActionListener listenerForBackToMenuBtn){
        backToMenuBtn.addActionListener(listenerForBackToMenuBtn);
    }
    
}
