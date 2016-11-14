package com.pscontroller;

import com.psmodel.ModifyModel;
import com.psview.PharmacyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ModifyController {
    
    private PharmacyView modifyView;
    private ModifyModel modifyModel;
    
    public ModifyController(PharmacyView modifyView,ModifyModel modifyModel){
        this.modifyView = modifyView;
        this.modifyModel = modifyModel;
        
        if(modifyModel.getUser().getRole().equals("M")){
            this.modifyView.displayModifyManager();
        }else{
            this.modifyView.displayModifyEmployee();
        }
             
        this.modifyView.addCustomerListener(new CustomerListener());
        this.modifyView.addEmployeeListener(new EmployeeListener());
        this.modifyView.addProductListener(new ProductListener());
        this.modifyView.addBackToMenuListener(new BackToMainMenuListener());       
        this.modifyView.addAddListener(new AddListener());
        this.modifyView.addDeleteListener1(new DeleteListener1());
        this.modifyView.addAddListenerForEmployee(new AddListenerForEmployee());
        this.modifyView.addDeleteListenerForEmployee(new DeleteListenerForEmployee());        
        this.modifyView.addTextFieldListener(new addTextField());
        this.modifyView.deleteTextFieldListener(new deleteTextField());
        this.modifyView.employeeAddTextFieldListener(new employeeAddTextField());
        this.modifyView.employeeDeleteTextFieldListener(new employeeDeleteTextField());    
    }
    
    class CustomerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String [] columns = modifyModel.getCustomersColumns();                                    
            Object [][] customerArray = modifyModel.generateArrayForCustomers(modifyModel.getCustomers());                                 
            modifyView.displayTable(columns,customerArray);
            modifyView.UpdateButtons();
            modifyView.dontShowJLabel();
            modifyView.dontShowEmployeeUpdateButtons();               
        }             
    }
    
    class ManagerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            modifyView.DontShowUpdateButtonsForManager();
            modifyView.dontShowEmployeeUpdateButtons();
            modifyView.setTableInvisible();
        }             
    }
    
    class EmployeeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){              
            String [] columns = modifyModel.getUsersColumns();
            Object [][] usersArray = modifyModel.generateArrayForEmployees(modifyModel.getUsers());
           
            modifyView.displayTable(columns,usersArray);
            modifyView.employeeUpdateButtons();
            modifyView.dontShowDeleteOptions();
            modifyView.dontShowAddOptions();
            modifyView.UButtonInvisible();
            modifyView.dontShowJLabel();
        }             
    }
    
    class ProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){              
            String [] columns = modifyModel.getDrugsColumns();
            Object [][] drugsArray = modifyModel.generateArrayForDrugs(modifyModel.getDrugs());
            
            modifyView.displayTable(columns,drugsArray);
            modifyView.dontShowForProduct();
        }             
    }
    
    class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           modifyView.addOptionsForCustomer();
           modifyView.dontShowDeleteOptions();             
        }
    }
    
    class DeleteListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            modifyView.dontShowAddOptions();
            modifyView.deleteOptionsForCustomer();
        }
    }
    
    class AddListenerForEmployee implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            modifyView.addOptionsForEmployee();
        }             
    }
    
    class DeleteListenerForEmployee implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            modifyView.deleteOptionsForEmployee();
        }             
    }

    class addTextField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(modifyView.TextFieldToFile().split(",").length == 7 && !modifyView.TextFieldToFile().isEmpty()){
                modifyModel.customerWriteIntoDataBase(modifyView.TextFieldToFile());
                modifyView.displayTable(modifyModel.getCustomersColumns(), modifyModel.generateArrayForCustomers(modifyModel.getCustomers()));
                System.out.println(modifyModel.getCustomers().size());
            }else{
                modifyView.displayErrorMessage("Wrong Format");
            }
            
        }
    } 

    class deleteTextField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){ 
            if(!modifyView.customerDeleteTextFieldToFile().isEmpty() && modifyView.customerDeleteTextFieldToFile().matches(".*\\d+.*")){
             modifyModel.deleteFromDataBaseForCustomers(modifyView.customerDeleteTextFieldToFile());
             modifyView.displayTable(modifyModel.getCustomersColumns(), modifyModel.generateArrayForCustomers(modifyModel.getCustomers()));
            }else{
                 modifyView.displayErrorMessage("Wrong Input");
            }
        }
    }
   
    class employeeAddTextField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(modifyView.employeeAddTextFieldToFile().split(",").length == 7 && !modifyView.employeeAddTextFieldToFile().isEmpty()){
                modifyModel.employeeWriteToDataBase(modifyView.employeeAddTextFieldToFile());
                modifyView.displayTable(modifyModel.getUsersColumns(), modifyModel.generateArrayForEmployees(modifyModel.getUsers()));
            }else{
                modifyView.displayErrorMessage("Wrong Input");
            }
        }
    }
    
    class employeeDeleteTextField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(!modifyView.employeeDeleteTextFieldToFile().isEmpty() && modifyView.employeeDeleteTextFieldToFile().matches(".*\\d+.*")){
                modifyModel.deleteFromDataBaseForEmployees(modifyView.employeeDeleteTextFieldToFile());
                modifyView.displayTable(modifyModel.getUsersColumns(), modifyModel.generateArrayForEmployees(modifyModel.getUsers()));
            }else{
                modifyView.displayErrorMessage("Wrong Input");
            }           
        }
    }
    
    class BackToMainMenuListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
            if(modifyModel.getUser().getRole().equals("M")){
                modifyView.displayMainMenuManagerFromModify();
            }else{
                modifyView.displayMainMenuEmployeeFromModify();
            }
        }             
    }
}
