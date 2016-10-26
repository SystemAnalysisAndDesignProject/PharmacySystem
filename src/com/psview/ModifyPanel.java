package com.psview;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ModifyPanel extends JPanel{
    
    private JButton customerBtn;
    private JButton managerBtn;
    private JButton employeeBtn;
    private JButton productBtn;
    private JButton backToMenuBtn;
    private JTextField firstNameTxt;
    private JTextField lastNameTxt;
    private JLabel productsTxt;
    //private JTextField nameTxt;
   // private JTextField nameTxt;
    
    public ModifyPanel()
    {
        this.setLayout(null);
        customerBtn = new JButton("Customer");
        managerBtn = new JButton("Manager");
        employeeBtn = new JButton("Employee");
        productBtn = new JButton("Product");
        backToMenuBtn = new JButton("Back To Main Menu");
        productsTxt = new JLabel();

        
        productsTxt.setBounds(20,100,600,600);

        
        customerBtn.setBounds(20, 20, 150, 20);
        managerBtn.setBounds(200, 20, 150, 20);
        employeeBtn.setBounds(380, 20, 150, 20);
        productBtn.setBounds(510, 20, 150, 20);
        backToMenuBtn.setBounds(510, 500, 150, 20);
         productsTxt.setVisible(false);
        
        this.add(customerBtn);
        this.add(managerBtn);
        this.add(employeeBtn);
        this.add(productBtn);
        this.add(backToMenuBtn);  
        this.add(productsTxt);
               
               
        
    }
    
    public void setVisibilityForEmployee(){
        managerBtn.setVisible(false);
        employeeBtn.setVisible(false);
        productBtn.setVisible(false);        
    }
    
    
    public void setTextDrugs(String message){
        productsTxt.setText(message);
        productsTxt.setVisible(true);
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
