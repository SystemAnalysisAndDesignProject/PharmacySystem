/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pscontroller;

import com.psdb.DataBaseManagment;
import com.psmodel.MainMenuModel;
import com.psmodel.ModifyModel;
import com.psmodel.perscription.Prescription;
import com.psmodel.OrderModel;
import com.psmodel.customer.Customer;
import com.psmodel.product.Drug;
import com.psview.OrderPanel;
import com.psview.PharmacyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pascal
 */
public class OrderController {
    private PharmacyView pharmacy;
    private OrderModel order;
    private Prescription prescription;//
    private OrderPanel  orderPanel;
    private DataBaseManagment dbms;
    private ArrayList <Drug> drugs;
    private ArrayList<Drug> presc;
    private ArrayList<Drug> nonpresc;
    private boolean medical;
    private boolean drug;

    
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
       
       String scheme = order.getScheme();
       System.out.println("!" + scheme + "!!!!!!!!!!!!!!!!!!!!!!!!111");
       double price, price1;
        ArrayList<String> items;
           items = pharmacy.getCartDetails();
       price = order.getCost(items);
            price1 = order.getFinalPrice(price,scheme);
            System.out.println("Price before scheme " + price);
            System.out.println("Final price " + price1);
            String cname = pharmacy.getCustomerName();
            order.updateSales(scheme);
            if(price1 == 0){
                pharmacy.displayReceipt(cname,items,price1);

                 MainMenuModel model = new MainMenuModel(order.getDataBase(),order.getUser());
                 MainMenuController control = new MainMenuController(pharmacy,model);
                 pharmacy.setOrderInvisible();
            }
            else{
                pharmacy.displayCheckout(price,price1);
            }
    }
    
}
    class Pay implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
       
       if(!pharmacy.checkForSelection()){
                System.out.println("printing reciept");
       String scheme = order.getScheme();
  
       
       String cname = pharmacy.getCustomerName();
       ArrayList<String> items = pharmacy.getCartDetails();
       double price = order.getCost(items);
       double finalPrice = order.getFinalPrice(price,scheme);
       
       pharmacy.displayReceipt(cname ,items ,finalPrice);
       MainMenuModel model = new MainMenuModel(order.getDataBase(),order.getUser());
       MainMenuController control = new MainMenuController(pharmacy,model);
        try {
            order.updateStock(items);
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
            String presc = order.getPrescriptionFor();
            pharmacy.addToCart(presc);
            ArrayList<String> items;
           items = pharmacy.getCartDetails();
            double price = order.getCost(items);
            pharmacy.setPrice(price);
           
        } 
}
    class DelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pharmacy.deleteFromCart();
            ArrayList<String> items;
           items = pharmacy.getCartDetails();
            double price = order.getCost(items);
            pharmacy.setPrice(price);
        }
        
    }

    
    class OrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
                System.out.println("printing reciept");
       String scheme = order.getScheme();
            

            String name = e.getActionCommand();
            
            

         medical = false;
         drug = false;
         ArrayList<Customer> customers = order.getDataBase().getCustomers();
         ArrayList<Prescription> prescriptions = order.getDataBase().getPrescriptions();
         boolean inDB = false;
         for(int x = 0; x < customers.size(); x++){
             if(name.equalsIgnoreCase(customers.get(x).getCustomerName()))
             {
                 for(int y =0; y < prescriptions.size();y++){
                     if(prescriptions.get(y).getCustomerName().equalsIgnoreCase(customers.get(x).getCustomerName())){
                         String prescriptionFor = prescriptions.get(x).getItems();
                             order.setPrescriptionFor(prescriptionFor);
                     }
                 }                 
                 inDB = true;
                 if(customers.get(x).getMedical() == true){
                     medical = true;
                 }
                 else if(customers.get(x).getDrug() == true){
                     drug = true;
                 }
                 else{
                     medical = false;
                     drug = false;
                 }
             }
         }
        
         while(inDB == false){
             JOptionPane.showMessageDialog(null,"Please add customer to DataBase before order");
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
             inDB= true;
         }
         
         

         boolean found = false;
         String [] items = new String[20];
         
         
         for(int i = 0; i < prescriptions.size() &&!found; i++){
            if(name.equalsIgnoreCase(prescriptions.get(i).getCustomerName())){
                items = prescriptions.get(i).getItems().split(" ");
               
                found = true;
            }
            else{
               
            }
        }
         System.out.println("test");
        drugs = order.getDataBase().getDrugs();
        System.out.println(order.getDataBase().getDrugs().size());
        System.out.println("test 1");

        System.out.println("size drugs " + drugs.size());
        presc = new ArrayList<Drug>();
        nonpresc = new ArrayList<Drug>();
         for(int j = 0; j < drugs.size(); j++){
             System.out.println(drugs.get(j).getName()  +  " " + drugs.get(j).checkRequiresPerscription());
             if(drugs.get(j).checkRequiresPerscription()== true) {
                 presc.add(drugs.get(j));
             }
             else{
                 nonpresc.add(drugs.get(j));
             }
         }
        System.out.println(" prescription " + presc.size());
        System.out.println("Non prescription " + nonpresc.size());
        pharmacy.populateList(presc,nonpresc,items);
      
         
         if(found){
          System.out.println("found a prescription with that name");
          pharmacy.setVisibilityOrder();
          pharmacy.addCart(items);
          ArrayList<String> items1 = new ArrayList<>();
          for(int i = 0; i < items.length;i++){
              items1.add(items[i]);
          }
          double price = order.getCost(items1);
          pharmacy.setPrice(price);
          order.setScheme(medical,drug);
        }
         else{
             System.out.println("No prescription found");
            }
        }
        
    }
    
    class BackToMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
            System.out.println("back to main menu clicked");
            if(order.getUser().getRole().equals("M")){
                pharmacy.displayMainMenuManagerFromOrder();
            }else{
                pharmacy.displayMainMenuEmployeeFromOrder();
            }
        }             
    }
    
}
