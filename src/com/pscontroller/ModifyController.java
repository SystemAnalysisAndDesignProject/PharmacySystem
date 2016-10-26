package com.pscontroller;

import com.psmodel.ModifyModel;
import com.psmodel.product.Drug;
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

                modifyView.setVisibilityForCustomer();

            
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
            System.out.println("employee clicked");
        }             
    }
    
    class ProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            ArrayList<Drug> drugs = modifyModel.getDrugs();
            
            String message = "";
            
            for(Drug drug : drugs){
                message += drug.getDescription();
            }
            
            modifyView.displayDrugs(message);
            
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
