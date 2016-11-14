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
    
    public Object[][] generateArrayForCustomers(ArrayList<Customer> customers){
        
                Object [][] customerArray = new Object[customers.size()+1] [7];
                for(int i = 0; i < customers.size();i++){             
                Customer tempCustomer = customers.get(i);
                 customerArray[i][0] = tempCustomer.getCustomerID();
                customerArray[i][1] = tempCustomer.getCustomerName();
                customerArray[i][2] = tempCustomer.getDateOfBirth();
                customerArray[i][3] = tempCustomer.getAddress();
                
                customerArray[i][4] = tempCustomer.getContactNumber();
                
                customerArray[i][5] = tempCustomer.getMedical();
                customerArray[i][6] = tempCustomer.getDrug();
                
            }
                return customerArray;
    }
    
    public Object[][] generateArrayForEmployees(ArrayList<User> users){
        int counter = 0;
        for(int i = 0; i < users.size();i++){             
                User tempUser = users.get(i);
                if(tempUser.getRole().toLowerCase().equals("e")){
                    counter++;
                }
             }
        
             Object [][] usersArray = new Object[counter+1] [6]; 
             int j = 0;
                for(int i = 0; i < usersArray.length;i++){             
                    User tempUser = users.get(i);
                
                    if(tempUser.getRole().toLowerCase().equals("e")){
                      usersArray[j][0] = tempUser.getUsername();
                      usersArray[j][1] = tempUser.getPassword();
                      usersArray[j][2] = tempUser.getRole();
                      usersArray[j][3] = tempUser.getPermission().getCanModifyCustomer();
                      usersArray[j][4] = tempUser.getPermission().getCanModifyEmployee();
                      usersArray[j][5] = tempUser.getPermission().getCanModifyProducts();
                      j++;
                }
                  
                }
              return usersArray;  
    }
    
    public Object[][] generateArrayForDrugs(ArrayList<Drug> drugs){
        Object [][] drugsArray = new Object[drugs.size()+1] [4]; 
        for(int i = 0; i < drugs.size();i++){             
                Drug tempdrug = drugs.get(i);
                 drugsArray[i][0] = tempdrug.getProductID();
                drugsArray[i][1] = tempdrug.getName();
                drugsArray[i][2] = tempdrug.getQuantity();
                drugsArray[i][3] = tempdrug.getPrice(); 
                System.out.println(drugsArray[i][0] + " " + drugsArray[i][1] + " " + drugsArray[i][2] + " " + drugsArray[i][3]);   
                
            } 
        return drugsArray;
    }
}
       
    