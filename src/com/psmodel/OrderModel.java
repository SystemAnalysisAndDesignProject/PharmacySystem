/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psmodel;

import com.psdb.DataBaseManagment;
import com.psmodel.Cart.Cart;
import com.psmodel.Cart.EmptyCart;
import com.psmodel.Cart.CartDecorator;
import com.psmodel.Cart.WithDrugScheme;
import com.psmodel.Cart.WithMedicalCard;
import com.psmodel.customer.Customer;
import com.psmodel.perscription.Prescription;
import com.psmodel.product.Drug;
import com.psmodel.user.User;
import java.io.IOException;
import java.util.ArrayList;

public class OrderModel {
    private DataBaseManagment dbm;
    private User user;
    private Prescription prescription;
    private Customer customer;
    private boolean medical;
    private boolean drug;
    private String prescriptionFor;

    public OrderModel(DataBaseManagment dbm, User user) {
        this.dbm = dbm;
        this.user =user;
    }
  
    public Customer getCustomer(){
        return customer;
    }
    
    public Prescription getPrescription() {
        return prescription;
    }
    
    public User getUser(){
        return user;
    }
    
    public DataBaseManagment getDataBase(){
        return dbm;
    }
    
 public void setScheme(boolean medical1,boolean drug1){
     medical = medical1;
     drug = drug1;
 }
 
 public String getScheme(){
     if(medical == true){
         return "medical";
     }
     else if(drug == true && medical == false){
         return "drug";
     }
     else if(medical == true && drug == true){
         return "medical";
     }
     else{
     return "none";
    }
 }
 public void setPrescriptionFor(String items){
     prescriptionFor = items;
 }
 
 public String getPrescriptionFor() {
     return prescriptionFor;
 }
    
   public double getCost(ArrayList<String> items){
       
       ArrayList<Drug> drugs = dbm.getDrugs();
       int size = items.size();
       double price = 0.0;
       for(int i = 0; i < size; i++){
           for(int j = 0; j < drugs.size(); j++){
               if(items.get(i).equalsIgnoreCase(drugs.get(j).getName())){
                   price += drugs.get(j).getPrice();
               }
           }
       }
       return price;
   }
   
   public double getFinalPrice(double price,String scheme){
     EmptyCart cart = new EmptyCart();
  
       cart.setCost(price);
       double prices;
       
       if(scheme.equalsIgnoreCase("medical")){
          Cart carts = new WithMedicalCard(new EmptyCart());
            prices = carts.Cost();
            return prices;
       }
       else if(scheme.equalsIgnoreCase("drug")){
          Cart carts = new CartDecorator( new WithDrugScheme(cart));
            prices = carts.getCost();
            System.out.println(prices);
            return prices;
       }
       else{
           return price;
       }
   }
   
   public void updateStock(ArrayList<String> items) throws IOException{
       ArrayList<Drug> drugs = dbm.getDrugs();
       
       for(int i = 0; i < items.size(); i++){
           for(int j = 0; j < drugs.size(); j++){
               if(items.get(i).equalsIgnoreCase(drugs.get(j).getName())){
                 int quantity =  drugs.get(j).getQuantity();
                 quantity = quantity -1;
                 drugs.get(j).setQuantity(quantity);
               }
           }
       }
       dbm.updateDrugsFile(drugs);
   }
   
   public void updateSales(String scheme){
       scheme = getScheme();
       int [] num = dbm.getSalesDetailsArray();
       System.out.println(num[0] + " " + num[1] + " " + num[2] );
       scheme = scheme.trim();
       if(scheme.equalsIgnoreCase("medical")){
           num[0]++;
       }
       else if(scheme.equalsIgnoreCase("drug")){
           num[1]++;
       }
       else{
           num[2]++;
        }
       dbm.updateSales(num);
   }
}  