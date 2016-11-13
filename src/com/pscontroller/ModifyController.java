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
        
        this.modifyView.addAddListener(new AddListener());
        this.modifyView.addDeleteListener1(new DeleteListener1());
        //this.modifyView.addUpdateListener(new UpdateListener());
        this.modifyView.addAddListenerForEmployee(new AddListenerForEmployee());
        this.modifyView.addDeleteListenerForEmployee(new DeleteListenerForEmployee());
        //this.modifyView.addUpdateListenerForEmployee(new UpdateListenerForEmployee());
        
        this.modifyView.addTextFieldListener(new addTextField());
        this.modifyView.deleteTextFieldListener(new deleteTextField());
        //this.modifyView.updateTextFieldListener(new updateTextField());
        this.modifyView.employeeAddTextFieldListener(new employeeAddTextField());
        this.modifyView.employeeDeleteTextFieldListener(new employeeDeleteTextField());
        //this.modifyView.employeeUpdateTextFieldListener(new employeeUpdateTextField());
        
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
            modifyView.UpdateButtons();
            modifyView.dontShowJLabel();
            modifyView.dontShowEmployeeUpdateButtons();     

            
        }             
    }
    
    class ManagerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("manager clicked");
            modifyView.DontShowUpdateButtonsForManager();
            modifyView.dontShowEmployeeUpdateButtons();
            modifyView.setTableInvisible();
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
            modifyView.employeeUpdateButtons();
            modifyView.dontShowDeleteOptions();
            modifyView.dontShowAddOptions();
            //modifyView.dontShowUpdateOptions();
            modifyView.UButtonInvisible();
            modifyView.dontShowJLabel();
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
            modifyView.dontShowForProduct();
            //modifyView.dontShowEmployeeUpdateButtons();
        }             
    }
    /*
    class BackToMenuListener implements ActionListener{
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
    */
    
    class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

            System.out.println("add button clicked");
           modifyView.addOptionsForCustomer();
           modifyView.dontShowDeleteOptions();
           //modifyView.dontShowUpdateOptions();
        }
    }
    
    class DeleteListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("delete button clicked");
            modifyView.dontShowAddOptions();
            //modifyView.dontShowUpdateOptions();
            modifyView.deleteOptionsForCustomer();
        }
    }
    
    class AddListenerForEmployee implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("employee add clicked");
            modifyView.addOptionsForEmployee();
        }             
    }
    
    class DeleteListenerForEmployee implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("employee delete clicked");
            modifyView.deleteOptionsForEmployee();
        }             
    }

    class addTextField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Text Field - Entry added to customer table");
            modifyModel.customerWriteIntoDataBase(modifyView.TextFieldToFile());
            System.out.println(modifyModel.getCustomers().size());
        }
    } 

    class deleteTextField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Text Field - Entry deleted from customer table"); 
             modifyModel.deleteFromDataBaseForCustomers(modifyView.customerDeleteTextFieldToFile());
        }
    }
   
    class employeeAddTextField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Text Field - Entry added to employee table"); 
            modifyModel.employeeWriteToDataBase(modifyView.employeeAddTextFieldToFile());
            System.out.println(modifyModel.getUsers().size());
        }
    }
    
    class employeeDeleteTextField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Text Field - Entry deleted from employee table");  
            modifyModel.deleteFromDataBaseForEmployees(modifyView.employeeDeleteTextFieldToFile());
        }
    }
       /*
    class customerDeleteTextField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Text Field - Entry deleted from customer table");
            modifyModel.deleteFromDataBaseForCustomers(modifyView.customerDeleteTextFieldToFile());
    }
    }*/


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
