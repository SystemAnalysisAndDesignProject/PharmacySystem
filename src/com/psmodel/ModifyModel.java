package com.psmodel;

import com.psmodel.user.User;
import com.psdb.DataBaseManagment;
import com.psmodel.customer.Customer;
import com.psmodel.product.Drug;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModifyModel {
    
    private DataBaseManagment dbm;
    private User user;
    private ArrayList<Drug> drugs;
    private ArrayList<Customer> customers;
    
    public ModifyModel(DataBaseManagment dbm,User user){
        this.dbm = dbm;
        this.user = user;        
        drugs = dbm.getDrugs();
        customers = dbm.getCustomers();
    }
    
    public User getUser(){
        return user;
    }
    
    public ArrayList<Drug> getDrugs(){
        return drugs;
    }
    
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    
     public String [] getDrugsColumns(){
        String [] columns = {"Product Id","Name","Quantity","Price"};
        return columns;
    }
     
     public ArrayList<User> getUsers(){
         return dbm.getUsers();
     }
     
     public String [] getUsersColumns(){
         String [] columns = {"Username","Password","Role","Modify Customer","Modify Employee","Modify Products"};
         return columns;
     }

     public String [] getCustomersColumns(){
         String [] columns = {"Customer ID","Full Name", "Date Of Birth", "Address", "Phone Number", "Medical Card", "Drug Scheme"};
         return columns;
     }
    
    public void customerWriteIntoDataBase(String something){
        dbm.writeToCustomerArray(something);
    }
      
    public void employeeWriteToDataBase(String textField){
        dbm.updateEmployeeTable(textField);
    }
      
    public void deleteFromDataBaseForCustomers(String data) {
        try {
            System.out.println(data);
            dbm.deleteCustomerEntry(data);
        } catch (IOException ex) {
            Logger.getLogger(ModifyModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteFromDataBaseForEmployees(String delEmployee){
        try{
            dbm.deleteEmployeeEntry(delEmployee);
        }catch(IOException ex){
            Logger.getLogger(ModifyModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}