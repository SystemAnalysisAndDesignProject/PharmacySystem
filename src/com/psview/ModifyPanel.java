package com.psview;

import com.psmodel.PharmacyConstants;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

public class ModifyPanel extends JPanel{
    
    private JButton customerBtn;
    //private JButton managerBtn;
    private JButton employeeBtn;
    private JButton productBtn;
    private JButton addButton;
    private JButton deleteButton;
    //private JButton updateButton;
    private JButton addButtonForEmployee;
    private JButton deleteButtonForEmployee;
    //private JButton updateButtonForEmployee;
    private JLabel addInfoLabel;
    private JButton backToMenuBtn;
    private JTextField firstNameTxt;
    private JTextField lastNameTxt;
    private JTable table;
    private JScrollPane scrollPane;
    private JTextField addTextField;
    private JTextField deleteTextField;
    //private JTextField updateTextField;
    private JTextField employeeAddTextField;
    private JTextField employeeDeleteTextField;
    //private JTextField employeeUpdateTextField;
    private ImageIcon img;
    private JLabel logo;
    
    public ModifyPanel()
    {
        this.setLayout(null);        
        //Initializing
        customerBtn = new JButton("Customer");
       // managerBtn = new JButton("Manager");
        employeeBtn = new JButton("Employee");
        productBtn = new JButton("Product");
        backToMenuBtn = new JButton("Back To Main Menu");
        table = new JTable();
        scrollPane = new JScrollPane(table);      
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        //updateButton = new JButton("Update");
        addButtonForEmployee = new JButton("Add");
        deleteButtonForEmployee = new JButton("Delete");
        //updateButtonForEmployee = new JButton("Update");
        addInfoLabel = new JLabel("");
        addTextField = new JTextField("");
        deleteTextField = new JTextField("");
        //updateTextField = new JTextField("");
        employeeAddTextField = new JTextField("");
        employeeDeleteTextField = new JTextField("");
         img = new ImageIcon(PharmacyConstants.pharmacyIconFilePath);
        logo = new JLabel();
       
       logo.setIcon(img);
       
        //employeeUpdateTextField = new JTextField("");   
        
        //Setting Position      
        customerBtn.setBounds(120, 20, 150, 20);
        //managerBtn.setBounds(210, 20, 150, 20);
        employeeBtn.setBounds(320, 20, 150, 20);
        productBtn.setBounds(520, 20, 150, 20);
        backToMenuBtn.setBounds(510, 500, 150, 20);
        scrollPane.setBounds(10, 250, 200, 300);
        addButton.setBounds(30, 100, 150, 20);
        deleteButton.setBounds(30, 140, 150, 20);
        //updateButton.setBounds(30, 140, 150, 20);
        addButtonForEmployee.setBounds(30, 100, 150, 20);
        deleteButtonForEmployee.setBounds(30, 140, 150, 20);
        //updateButtonForEmployee.setBounds(30, 140, 150, 20);
        addInfoLabel.setBounds(210, 120, 510, 20);
        addTextField.setBounds(210, 140, 510, 20);
        deleteTextField.setBounds(210, 140, 510, 20);
        //updateTextField.setBounds(210, 140, 510, 20);
        employeeAddTextField.setBounds(210, 140, 510, 20);
        employeeDeleteTextField.setBounds(210, 140, 510, 20);
        //employeeUpdateTextField.setBounds(210, 140, 510, 20);
        logo.setBounds(20,450,100,100); 
        //Adding to components to Panel
        this.add(customerBtn);
        //this.add(managerBtn);
        this.add(employeeBtn);
        this.add(productBtn);
        this.add(backToMenuBtn);      
        this.add(scrollPane);
        this.add(addButton);
        this.add(deleteButton);
        //this.add(updateButton);
        this.add(addButtonForEmployee);
        this.add(deleteButtonForEmployee);
        //this.add(updateButtonForEmployee);
        this.add(addInfoLabel);
        this.add(addTextField);
        this.add(deleteTextField);
        //this.add(updateTextField);
        this.add(employeeAddTextField);
        this.add(employeeDeleteTextField);
        //this.add(employeeUpdateTextField);
        this.add(logo);
                
        //Visibility
        addButton.setVisible(false);
        deleteButton.setVisible(false);
        //updateButton.setVisible(false);
        addButtonForEmployee.setVisible(false);
        deleteButtonForEmployee.setVisible(false);
        //updateButtonForEmployee.setVisible(false);
        addInfoLabel.setVisible(false);
        addTextField.setVisible(false);
        deleteTextField.setVisible(false);
        //updateTextField.setVisible(false);
        employeeAddTextField.setVisible(false);
        employeeDeleteTextField.setVisible(false);
        //employeeUpdateTextField.setVisible(false);
        scrollPane.setVisible(false);
        table.setVisible(false);
    }
    
    public void setVisibilityForEmployee(){
        //managerBtn.setVisible(false);
        employeeBtn.setVisible(false);
        productBtn.setVisible(false);        
    }   

    public void displayTable(String [] columns,Object[][] drugs){
        dontDisplayTable();
        table = new JTable(drugs,columns);
        table.setEnabled(false);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30,250,700,200);
        this.add(scrollPane);
        table.setVisible(true);        
    }   
    
    public void dontDisplayTable(){
        table.setVisible(false);
        scrollPane.setVisible(false);
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
    
    public void setAddVisible(){
        addTextField.setVisible(true);
        addInfoLabel.setVisible(true);
    }
    
    public void setAddInvisible(){
        addTextField.setVisible(false);
        //addInfoLabel.setVisible(false);
    }
    
    public void setDeleteVisible(){
        deleteTextField.setVisible(true);
        addInfoLabel.setVisible(true);
    }
    
    public void setDeleteInvisible(){
        deleteTextField.setVisible(false);
        //addInfoLabel.setVisible(false);
    }
    
    /*
    public void setUpdateVisible(){
        updateTextField.setVisible(true);
        addInfoLabel.setVisible(true);
    }

    
    public void setUpdateInvisible(){
        updateTextField.setVisible(false);
        //addInfoLabel.setVisible(false);
    }*/

    public void setAddVisibleForEmployee(){
        employeeAddTextField.setVisible(true);
        addInfoLabel.setVisible(true);
    }
    
    public void setAddInvisibleForEmployee(){
        employeeAddTextField.setVisible(false);
        //addInfoLabel.setVisible(false);
    }
    
    public void setDeleteVisibleForEmployee(){
        employeeDeleteTextField.setVisible(true);
        addInfoLabel.setVisible(true);
    }
    
    public void setDeleteInvisibleForEmployee(){
        employeeDeleteTextField.setVisible(false);
        //addInfoLabel.setVisible(false);
    }
    
    /*  
    public void setUpdateVisibleForEmployee(){
        employeeUpdateTextField.setVisible(true);
        addInfoLabel.setVisible(true);
    }
    
    public void setUpdateInvisibleForEmployee(){
        employeeUpdateTextField.setVisible(false);
        //addInfoLabel.setVisible(false);
    }
    */
    
    public void setJLabelInvisible(){
        addInfoLabel.setVisible(false);
    }

    public void setUpdateButtonsVisible(){
        //updateButton.setVisible(true);
        addButton.setVisible(true);
        deleteButton.setVisible(true);
    }
    
    public void setUpdateButtonsInvisible(){
        //updateButton.setVisible(false);
        addButton.setVisible(false);
        deleteButton.setVisible(false);
    }

     public void setUpdateButtonsForEmployeeVisible(){
        //updateButtonForEmployee.setVisible(true);
        addButtonForEmployee.setVisible(true);
        deleteButtonForEmployee.setVisible(true);
    }
    
    public void setUpdateButtonsForEmployeeInvisible(){
        //updateButtonForEmployee.setVisible(false);
        addButtonForEmployee.setVisible(false);
        deleteButtonForEmployee.setVisible(false);
    }
    
    public String addTextFieldToFile(){
        String addTextFieldWriting = addTextField.getText();
        System.out.println(addTextFieldWriting);
        return addTextFieldWriting;  
    }
    
    public String addTextFieldForEmployeeToFile(){
        String empAddTextField = employeeAddTextField.getText();
        System.out.println(employeeAddTextField);
        return empAddTextField;
    }
    
    public String deleteCustomerTextFieldFromFile(){
        String deleteTextFieldForCustomers = deleteTextField.getText();
        System.out.println(deleteTextFieldForCustomers);
        System.out.println("aaaaaaaaaaaaaaaaaaaaa");
        return deleteTextFieldForCustomers;
    }
    
    public String deleteEmployeeTextFieldFromFile(){
        String deleteTextFieldForEmployees = employeeDeleteTextField.getText();
        System.out.println(employeeDeleteTextField);
        return deleteTextFieldForEmployees;
    }
 
    public void changeEmployeeAddJLabel(){
        addInfoLabel.setText("Enter the employees details. e.g. emp,emp1,E,false,true,false,false");
    }
    
    public void changeEmployeeDeleteJLabel(){
        addInfoLabel.setText("Select which row you want to delete. e.g. row 2");
    }
    
    /*
    public void changeEmployeeUpdateJLabel(){
        addInfoLabel.setText("Select which row you want to update. e.g. row 2");
    }
    */
    
    public void changeCustomerAddJLabel(){
        addInfoLabel.setText("Enter the customers details. e.g. 1234,John Doe,21-11-1996,Limerick,0861234567,true,false");
    }
    
    public void changeCustomerDeleteJLabel(){
        addInfoLabel.setText("Select which row you want to delete. e.g. row 1");
    }
    
    /*
    public void changeCustomerUpdateJLabel(){
        addInfoLabel.setText("Select which row you want to update. e.g. row 1");
    }
    */
    
    public void DontDisplayUpdatesForManager(){
        addButton.setVisible(false);
        deleteButton.setVisible(false);
        //updateButton.setVisible(false);
        addButtonForEmployee.setVisible(false);
        deleteButtonForEmployee.setVisible(false);
        //updateButtonForEmployee.setVisible(false);
        addInfoLabel.setVisible(false);
        addTextField.setVisible(false);
        deleteTextField.setVisible(false);
        //updateTextField.setVisible(false);
        employeeAddTextField.setVisible(false);
        employeeDeleteTextField.setVisible(false);
        //employeeUpdateTextField.setVisible(false);
        scrollPane.setVisible(false);
        table.setVisible(false);
    }
    
    public void dontShowButtonForProduct(){
        addButton.setVisible(false);
        deleteButton.setVisible(false);
        addButtonForEmployee.setVisible(false);
        deleteButtonForEmployee.setVisible(false);
        addInfoLabel.setVisible(false);
        addTextField.setVisible(false);
        deleteTextField.setVisible(false);
        employeeAddTextField.setVisible(false);
        employeeDeleteTextField.setVisible(false);
    }

    public void addCustomerListener(ActionListener listenerForCustomerBtn){
        customerBtn.addActionListener(listenerForCustomerBtn);
    }
    
    //public void addManagerListener(ActionListener listenerForManagerBtn){
   //     managerBtn.addActionListener(listenerForManagerBtn);
    //}
    
    public void addEmployeeListener(ActionListener listenerForEmployeeBtn){
        employeeBtn.addActionListener(listenerForEmployeeBtn);
    }
    
    public void addProductListener(ActionListener listenerForProductBtn){
        productBtn.addActionListener(listenerForProductBtn);
    }
    
    public void addBackToMenuListener(ActionListener listenerForBackToMenuBtn){
        backToMenuBtn.addActionListener(listenerForBackToMenuBtn);
    }
    
    public void addAddListener(ActionListener listenerForAddButton){
        addButton.addActionListener(listenerForAddButton);
    }
    
    public void addDeleteListener1(ActionListener listenerForDeleteButton){
        deleteButton.addActionListener(listenerForDeleteButton);
    }
    
    /*
    public void addUpdateListener(ActionListener listenerForUpdateButton){
        updateButton.addActionListener(listenerForUpdateButton);
    }*/
   
    public void addAddListenerForEmployee(ActionListener listenerForAddButtonForEmployee){
        addButtonForEmployee.addActionListener(listenerForAddButtonForEmployee);
    }
    
    public void addDeleteListenerForEmployee(ActionListener listenerForDeleteButtonForEmployee){
        deleteButtonForEmployee.addActionListener(listenerForDeleteButtonForEmployee);
    }
    
    /*
    public void addUpdateListenerForEmployee(ActionListener listenerForUpdateButtonForEmployee){
        updateButtonForEmployee.addActionListener(listenerForUpdateButtonForEmployee);
    }
    */
    
    public void addTextFieldListener(ActionListener listenerForAddTextField){
        addTextField.addActionListener(listenerForAddTextField);
    }
    
    public void deleteTextFieldListener(ActionListener listenerForDeleteTextField){
        deleteTextField.addActionListener(listenerForDeleteTextField);
    }
    
    /*
    public void updateTextFieldListener(ActionListener listenerForUpdateTextField){
        updateTextField.addActionListener(listenerForUpdateTextField);
    }*/
    
    public void employeeAddTextFieldListener(ActionListener listenerForEmployeeAddTextField){
        employeeAddTextField.addActionListener(listenerForEmployeeAddTextField);
    }
    
    public void employeeDeleteTextFieldListener(ActionListener listenerForEmployeeDeleteTextField){
        employeeDeleteTextField.addActionListener(listenerForEmployeeDeleteTextField);
    }
    
    /*
    public void employeeUpdateTextFieldListener(ActionListener listenerForEmployeeUpdateTextField){
        employeeUpdateTextField.addActionListener(listenerForEmployeeUpdateTextField);
    }*/
}