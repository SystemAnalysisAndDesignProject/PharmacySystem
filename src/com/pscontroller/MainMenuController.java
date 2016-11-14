
package com.pscontroller;

import com.psmodel.MainMenuModel;
import com.psmodel.ModifyModel;
import com.psmodel.OrderModel;
import com.psmodel.SalesReportModel;
import com.psmodel.customer.Customer;
import com.psmodel.perscription.Prescription;
import com.psview.PharmacyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenuController {
    
    private PharmacyView mainMenuView;
    private MainMenuModel mainMenuModel;
    
    
    public MainMenuController(PharmacyView mainMenuView, MainMenuModel mainMenuModel){
        this.mainMenuView = mainMenuView;
        this.mainMenuModel = mainMenuModel;     
        
        if(this.mainMenuModel.getUser().getRole().equals("M"))
        {
            this.mainMenuView.displayMainMenuManager();
        }else{
            this.mainMenuView.displayMainMenuEmployee();
        }       
        
        this.mainMenuView.addModifyListener(new ModifyListener());
        this.mainMenuView.addOrderProcessListener(new OrderProcessListener());
        this.mainMenuView.addLogoutListener(new LogoutListener());     
        this.mainMenuView.addSalesReportsListener(new SalesReportListener());
    }
    
    class ModifyListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            ModifyModel modifyModel = new ModifyModel(mainMenuModel.getDataBase(),mainMenuModel.getUser());                    
            ModifyController mainMenuController = new ModifyController(mainMenuView,modifyModel);   
        }             
    }
    
    class OrderProcessListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("order process clicked");
            OrderModel orderModel = new OrderModel(mainMenuModel.getDataBase(),mainMenuModel.getUser());
            OrderController control = new OrderController(mainMenuView, orderModel);            
        }        
    } 
    
    class LogoutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           mainMenuView.displayLoginPanel();
           System.out.println("Logged Out");
        }        
    }
    
    class SalesReportListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           System.out.println("sales report clicked");
           SalesReportModel salesReportModel = new SalesReportModel(mainMenuModel.getDataBase());                    
            try {
                SalesReportController salesReportController = new SalesReportController(mainMenuView,salesReportModel);
                
            } catch (IOException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        }        
    }
}
