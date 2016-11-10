/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pscontroller;

import com.psdb.DataBaseManagment;
import com.psmodel.perscription.Prescription;
import com.psmodel.OrderModel;
import com.psmodel.product.Drug;
import com.psview.OrderPanel;
import com.psview.PharmacyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    
    public OrderController(PharmacyView pharmacy, OrderModel order) {
        this.pharmacy = pharmacy;
        this.order = order;
        
        pharmacy.displayOrderPanel();
    this.pharmacy.addOrderListener(new OrderListener());
    this.pharmacy.addToCartListener(new AddListener());
    this.pharmacy.addDelListener(new DelListener());
    this.pharmacy.addBackToMenu(new BackToMenu());
    }
  
    class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pharmacy.addToCart();
        } 
}
    class DelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pharmacy.deleteFromCart();
        }
        
    }

    
    class OrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("1");
            String name = e.getActionCommand();
          //String name= order.getCustomerName();
          System.out.println("1");
          System.out.println(name);
          System.out.println("3");
         // dbms = order.getDataBase();
         // dbms.readPrescriptions();
        dbms = new DataBaseManagment();
         
         ArrayList<Prescription> prescriptions = dbms.getPrescriptions();
         boolean found = false;
         
         for(int i = 0; i < prescriptions.size() &&!found; i++){
            if(name.equalsIgnoreCase(prescriptions.get(i).getCustomerName())){
                found = true;
            }
        }
        drugs = new ArrayList<Drug>(dbms.getDrugs());
        Drug a = new Drug(4,"ket",20,100,false);
        Drug b = new Drug(5,"heroine",40,1000,true);
        Drug c = new Drug(6,"calpol",20,100,false);
        Drug d = new Drug(7,"DMX",40,1000,true);
        drugs.add(a);
        drugs.add(b);
        drugs.add(c);
        drugs.add(d);
        System.out.println(drugs.size());
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
        pharmacy.populateList(presc,nonpresc);
         
         if(found){
          System.out.println("found a prescription with that name");
          pharmacy.setVisibilityOrder();
         // pharmacy.populateList(presc,nonpresc);
        }
         else{
             System.out.println("No prescription found");
             //pharmacy.populateList(presc,nonpresc); 
            }
        }
    }
    
    class BackToMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
            System.out.println("back to main menu clicked");
            if(order.getUser().getRole().equals("M")){
                pharmacy.displayMainMenuManagerFromModify();
            }else{
                pharmacy.displayMainMenuEmployeeFromModify();
            }
        }             
    }
}
