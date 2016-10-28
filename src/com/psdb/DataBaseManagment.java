package com.psdb;

import com.psmodel.user.Permission;
import com.psmodel.PharmacyConstants;
import com.psmodel.customer.Customer;
import com.psmodel.user.User;
import com.psmodel.user.UserFactory;
import com.psmodel.product.Drug;
import com.psmodel.product.DrugFactory;
import com.psmodel.sales.SalesDetails;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataBaseManagment {
    
    private ArrayList<User> users;
    private ArrayList<Drug> drugs;
    private ArrayList<Customer> customers;
    private int [] salesDetailsArray;
    
    
    public DataBaseManagment(){
        readUsers();
        readDrugs();
        readCustomers();
        readSalesDetails();
    }
    
    private void readUsers(){ 
        BufferedReader br = null;        
        try{
            String currentLine;
            users = new ArrayList<User>();
            
            br = new BufferedReader(new FileReader(PharmacyConstants.usersFilePath));
            
            while((currentLine = br.readLine()) != null){
                
                String [] tempUser = currentLine.split(",");
                UserFactory userFactory = new UserFactory();
                
                User user = userFactory.makeUser(tempUser[2]);
                user.setUsername(tempUser[0]);
                user.setPassword(tempUser[1]);
                user.setRole(tempUser[2]);
                user.setPermission(new Permission(Boolean.parseBoolean(tempUser[3]),
                                                  Boolean.parseBoolean(tempUser[4]),
                                                  Boolean.parseBoolean(tempUser[5]),
                                                  Boolean.parseBoolean(tempUser[6])));
               
                users.add(user);
            }            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void readDrugs(){
        
        BufferedReader br = null;        
        try{
            String currentLine;
            drugs = new ArrayList<Drug>();
            
            br = new BufferedReader(new FileReader(PharmacyConstants.drugsFilePath));
            
            while((currentLine = br.readLine()) != null){
                
                String [] tempDrug = currentLine.split(",");
                DrugFactory drugFactory = new DrugFactory();
                
                Drug drug = drugFactory.makeDrug(Integer.parseInt(tempDrug[0]),tempDrug[1],
                                          Integer.parseInt(tempDrug[2]),Double.parseDouble(tempDrug[3]),
                                          Boolean.parseBoolean(tempDrug[4]));
                
                System.out.println(drug.getDescription());
               
                drugs.add(drug);
            }            
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    
    private void readCustomers(){
        BufferedReader br = null;        
        try{
            String currentLine;
            customers = new ArrayList<Customer>();
            
            br = new BufferedReader(new FileReader(PharmacyConstants.customersFilePath));
            
            while((currentLine = br.readLine()) != null){
                
                String [] tempCustomer = currentLine.split(",");
                Customer customer = new Customer(Integer.parseInt(tempCustomer[0]),tempCustomer[1],tempCustomer[2],
                                                tempCustomer[3],
                                                Integer.parseInt(tempCustomer[4]),
                                                Boolean.parseBoolean(tempCustomer[5]),
                                                Boolean.parseBoolean(tempCustomer[6]));
                
                System.out.println(customer.getCustomerID());
                
               
                customers.add(customer);
            }            
        }catch(IOException e){
            e.printStackTrace();
        }
    }   
    
    private void readSalesDetails(){ 
        BufferedReader br = null;        
        SalesDetails salesDetails = new SalesDetails();
        try{
            String currentLine;
            salesDetailsArray = new int[3];            
            br = new BufferedReader(new FileReader(PharmacyConstants.salesDetailsFilePath));
            
            while((currentLine = br.readLine()) != null){
                
                String [] tempSalesDetails = currentLine.split(",");
                for(int i = 0; i < tempSalesDetails.length; i++)
                {
                    salesDetailsArray[i] = Integer.parseInt(tempSalesDetails[i]);
                }
         
            }
            
            salesDetails.setMedicalCardSales(salesDetailsArray[0]);
            salesDetails.setDrugSchemeSales(salesDetailsArray[1]);
            salesDetails.setRegularSales(salesDetailsArray[2]);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<User> getUsers(){     
        return users;
    }
    
    public ArrayList<Drug> getDrugs(){
        return drugs;
    }
    
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    
    public int [] getSalesDetailsArray(){
        return salesDetailsArray;
    }
}
