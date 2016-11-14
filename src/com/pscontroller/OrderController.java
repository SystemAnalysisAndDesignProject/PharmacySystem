package com.pscontroller;

import com.psmodel.MainMenuModel;
import com.psmodel.ModifyModel;
import com.psmodel.OrderModel;
import com.psview.PharmacyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderController {
    private PharmacyView pharmacy;
    private OrderModel order;
    
    public OrderController(PharmacyView pharmacy, OrderModel order) {
        this.pharmacy = pharmacy;
        this.order = order;
        
        if(order.getUser().getRole().equalsIgnoreCase("m")){
            pharmacy.displayOrderProcessManager();
        }else{
            pharmacy.displayOrderProcessEmployee();
        }
    this.pharmacy.addOrderListener(new OrderListener());
    this.pharmacy.addToCartListener(new AddListener());
    this.pharmacy.addDelListener(new DelListener());
    this.pharmacy.addBackToMenu(new BackToMenu());
    this.pharmacy.addCheckoutListener(new Checkout());
    this.pharmacy.addPayListener(new Pay());
    }
    
    class Checkout implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
            order.updateSales(order.getScheme());
            if(order.getFinalPrice(order.getCost(pharmacy.getCartDetails()),order.getScheme()) == 0){
                pharmacy.displayReceipt(pharmacy.getCustomerName(),pharmacy.getCartDetails(),order.getFinalPrice(order.getCost(pharmacy.getCartDetails()),order.getScheme()));

                 MainMenuModel model = new MainMenuModel(order.getDataBase(),order.getUser());
                 MainMenuController control = new MainMenuController(pharmacy,model);
                 pharmacy.setOrderInvisible();
            }
            else{
                pharmacy.displayCheckout(order.getCost(pharmacy.getCartDetails()),order.getFinalPrice(order.getCost(pharmacy.getCartDetails()),order.getScheme()));
            }
    }
    
}
    class Pay implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
       
       if(!pharmacy.checkForSelection()){       
       pharmacy.displayReceipt(pharmacy.getCustomerName() ,pharmacy.getCartDetails() ,
                               order.getFinalPrice(order.getCost(pharmacy.getCartDetails()),
                               order.getScheme()));
       MainMenuModel model = new MainMenuModel(order.getDataBase(),order.getUser());
       MainMenuController control = new MainMenuController(pharmacy,model);
        try {
            order.updateStock(pharmacy.getCartDetails());
        } catch (IOException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
       pharmacy.setOrderInvisible();
        }      
    }
}
  
    class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pharmacy.addToCart(order.getPrescriptionFor());
            pharmacy.setPrice(order.getCost(pharmacy.getCartDetails()));           
        } 
}
    class DelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pharmacy.deleteFromCart();
            pharmacy.setPrice(order.getCost(pharmacy.getCartDetails()));
        }        
    }
    
    class OrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {       
        String name = e.getActionCommand();                      
         order.setPrescription(name,order.getDataBase().getCustomers(),order.getDataBase().getPrescriptions());         
        
         while(order.getInDB() == false){
             pharmacy.displayErrorMessage("Please add customer to DataBase before order");
             if(order.getUser().getRole().equals("M"))
            {
                pharmacy.setOrderInvisible();
                ModifyModel modify = new ModifyModel(order.getDataBase(),order.getUser());
                ModifyController control = new ModifyController(pharmacy,modify);
                
            }else{
                  pharmacy.setOrderInvisible();
                ModifyModel modify = new ModifyModel(order.getDataBase(),order.getUser());
                ModifyController control = new ModifyController(pharmacy,modify);
            }       
             order.setInDB(true);
         }  
         
        boolean found = order.checkForPrescription(name,order.getDataBase().getPrescriptions());
        order.checkRequirePrescription(order.getDataBase().getDrugs());        
        pharmacy.populateList(order.getPresc(),order.getNonPresc(),order.getItems());      
         
         if(found){
          pharmacy.setVisibilityOrder();
          pharmacy.addCart(order.getItems());             
          double price = order.getCost(order.getCurrentItems());
          pharmacy.setPrice(price);
          order.setScheme(order.getMedical(),order.getDrug());
        }
        }        
    }
    
    class BackToMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
            if(order.getUser().getRole().equals("M")){
                pharmacy.displayMainMenuManagerFromOrder();
            }else{
                pharmacy.displayMainMenuEmployeeFromOrder();
            }
        }             
    }
    
}
