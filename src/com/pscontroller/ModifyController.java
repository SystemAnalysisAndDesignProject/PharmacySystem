package com.pscontroller;

import com.psmodel.ModifyModel;
import com.psmodel.customer.Customer;
import com.psmodel.product.Drug;
import com.psmodel.user.User;
import com.psview.PharmacyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModifyController {
    
    private PharmacyView modifyView;
    private ModifyModel modifyModel;
    //private boolean customerClicked = false;
    
    public ModifyController(PharmacyView modifyView,ModifyModel modifyModel){
        this.modifyView = modifyView;
        this.modifyModel = modifyModel;
        
        if(modifyModel.getUser().getRole().equals("M")){
            this.modifyView.displayModifyManager();
        }else{
            this.modifyView.displayModifyEmployee();
        }
             
        this.modifyView.addCustomerListener(new CustomerListener());
        this.modifyView.addManagerListener(new ManagerListener());
        this.modifyView.addEmployeeListener(new EmployeeListener());
        this.modifyView.addProductListener(new ProductListener());
        this.modifyView.addBackToMenuListener(new BackToMainMenuListener());             
    }
    
    class CustomerListener implements ActionListener{
        
        
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("customer clicked");
            
           ArrayList<Customer> customers = modifyModel.getCustomers();
            System.out.println(customers.size());
            Object [][] customerArray = new Object[customers.size()+1] [7];    
             String [] columns = modifyModel.getCustomersColumns();
            
             for(int j = 0; j < columns.length;j++){
                 System.out.println(columns[j]);
             }
            for(int i = 0; i < customers.size();i++){             
                Customer tempCustomer = customers.get(i);
                 customerArray[i][0] = tempCustomer.getCustomerID();
                customerArray[i][1] = tempCustomer.getCustomerName();
                customerArray[i][2] = tempCustomer.getDateOfBirth();
                customerArray[i][3] = tempCustomer.getAddress();
                
                customerArray[i][4] = tempCustomer.getContactNumber();
                
                customerArray[i][5] = tempCustomer.getMedical();
                customerArray[i][6] = tempCustomer.getDrug();
                //System.out.println(drugsArray[i][0] + " " + drugsArray[i][1] + " " + drugsArray[i][2] + " " + drugsArray[i][3]);   
                
            }                     
            modifyView.displayTable(columns,customerArray);
                

            
        }             
    }
    
    class ManagerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("manager clicked");
        }             
    }
    
    class EmployeeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            ArrayList<User> user = modifyModel.getUsers();
            int counter = 0;
            System.out.println(user.size());
               
             String [] columns = modifyModel.getUsersColumns();
            
             for(int i = 0; i < user.size();i++){             
                User tempUser = user.get(i);
                if(tempUser.getRole().toLowerCase().equals("e")){
                    counter++;
                }
             }
             
             Object [][] usersArray = new Object[counter+1] [6]; 
             int j = 0;
                for(int i = 0; i < usersArray.length;i++){             
                    User tempUser = user.get(i);
                
                if(tempUser.getRole().toLowerCase().equals("e")){
                    usersArray[j][0] = tempUser.getUsername();
                    usersArray[j][1] = tempUser.getPassword();
                    usersArray[j][2] = tempUser.getRole();
                    usersArray[j][3] = tempUser.getPermission().getCanModifyCustomer();
                    usersArray[j][4] = tempUser.getPermission().getCanModifyEmployee();
                    usersArray[j][5] = tempUser.getPermission().getCanModifyProducts();
                  j++;
                }
                 
                
                //System.out.println(drugsArray[i][0] + " " + drugsArray[i][1] + " " + drugsArray[i][2] + " " + drugsArray[i][3]);   
                
            }                     
            modifyView.displayTable(columns,usersArray);
        }             
    }
    
    class ProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            ArrayList<Drug> drugs = modifyModel.getDrugs();
            System.out.println(drugs.size());
            Object [][] drugsArray = new Object[drugs.size()+1] [4];    
             String [] columns = modifyModel.getDrugsColumns();
            
             for(int j = 0; j < columns.length;j++){
                 System.out.println(columns[j]);
             }
             
            for(int i = 0; i < drugs.size();i++){             
                Drug tempdrug = drugs.get(i);
                 drugsArray[i][0] = tempdrug.getProductID();
                drugsArray[i][1] = tempdrug.getName();
                drugsArray[i][2] = tempdrug.getQuantity();
                drugsArray[i][3] = tempdrug.getPrice(); 
                System.out.println(drugsArray[i][0] + " " + drugsArray[i][1] + " " + drugsArray[i][2] + " " + drugsArray[i][3]);   
                
            }                     
            modifyView.displayTable(columns,drugsArray);
            
        }             
    }
    
    class BackToMainMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("back to main menu clicked");
            if(modifyModel.getUser().getRole().equals("M")){
                modifyView.displayMainMenuManagerFromModify();
            }else{
                modifyView.displayMainMenuEmployeeFromModify();
            }
        }             
    }
    
}
