package com.psmodel;

import com.psmodel.user.User;
import com.psdb.DataBaseManagment;
import com.psmodel.customer.Customer;
import com.psmodel.product.Drug;
import java.util.ArrayList;

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
    
}
