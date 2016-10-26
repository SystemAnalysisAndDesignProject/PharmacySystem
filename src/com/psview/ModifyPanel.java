package com.psview;

import com.psmodel.product.Drug;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ModifyPanel extends JPanel{
    
    private JButton customerBtn;
    private JButton managerBtn;
    private JButton employeeBtn;
    private JButton productBtn;
    private JButton backToMenuBtn;
    private JTextField firstNameTxt;
    private JTextField lastNameTxt;
    private JTable table;
    private JScrollPane scrollPane;
    
    public ModifyPanel()
    {
        this.setLayout(null);        
        //Initializing
        customerBtn = new JButton("Customer");
        managerBtn = new JButton("Manager");
        employeeBtn = new JButton("Employee");
        productBtn = new JButton("Product");
        backToMenuBtn = new JButton("Back To Main Menu");
        table = new JTable();
        scrollPane = new JScrollPane(table);        
      
        //Setting Position      
        customerBtn.setBounds(30, 20, 150, 20);
        managerBtn.setBounds(210, 20, 150, 20);
        employeeBtn.setBounds(390, 20, 150, 20);
        productBtn.setBounds(570, 20, 150, 20);
        backToMenuBtn.setBounds(510, 500, 150, 20);
        scrollPane.setBounds(10, 250, 200, 300);

        //Adding to components to Panel
        this.add(customerBtn);
        this.add(managerBtn);
        this.add(employeeBtn);
        this.add(productBtn);
        this.add(backToMenuBtn);      
        this.add(scrollPane);
                
        //Visibility
        scrollPane.setVisible(false);
    }
    
    public void setVisibilityForEmployee(){
        managerBtn.setVisible(false);
        employeeBtn.setVisible(false);
        productBtn.setVisible(false);        
    }   

    public void displayTable(String [] columns,Object[][] drugs){
        table = new JTable(drugs,columns);
        table.setEnabled(false);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30,250,700,100);
        this.add(scrollPane);
        table.setVisible(true);        
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
