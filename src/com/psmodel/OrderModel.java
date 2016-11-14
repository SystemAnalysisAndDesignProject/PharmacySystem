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
    private boolean inDb;
    private  String [] items;
    private ArrayList<Drug> presc;
    private ArrayList<Drug> nonpresc;
    
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
 
 public ArrayList<String> getCurrentItems(){
     ArrayList<String> items1 = new ArrayList<>();
          for(int i = 0; i < getItems().length;i++){
              items1.add(getItems()[i]);
          }
          return items1;
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
   
   public void setPrescription(String name,ArrayList<Customer> customers,ArrayList<Prescription> prescriptions){
        for(int x = 0; x < customers.size(); x++){
             if(name.equalsIgnoreCase(customers.get(x).getCustomerName()))
             {
                 for(int y =0; y < prescriptions.size();y++){
                     if(prescriptions.get(y).getCustomerName().equalsIgnoreCase(customers.get(x).getCustomerName())){
                         String prescriptionFor = prescriptions.get(x).getItems();
                             setPrescriptionFor(prescriptionFor);
                     }
                 }                 
                 this.inDb = true;
                 if(customers.get(x).getMedical() == true){
                     this.medical = true;
                 }
                 else if(customers.get(x).getDrug() == true){
                     this.drug = true;
                 }
                 else{
                     this.medical = false;
                     this.drug = false;
                 }
             }
         }
   }
   
   public boolean checkForPrescription(String name,ArrayList<Prescription> prescriptions){
         boolean found = false;
        items = new String[20];
                 
         for(int i = 0; i < prescriptions.size() &&!found; i++){
            if(name.equalsIgnoreCase(prescriptions.get(i).getCustomerName())){
                items = prescriptions.get(i).getItems().split(" ");
               
                found = true;
            }
            else{
               
            }
        }
         return found;
   }
   
   public void checkRequirePrescription(ArrayList<Drug> drugs){
       presc = new ArrayList<Drug>();
        nonpresc = new ArrayList<Drug>();
         for(int j = 0; j < drugs.size(); j++){
             if(drugs.get(j).checkRequiresPerscription()== true) {
                 presc.add(drugs.get(j));
             }
             else{
                 nonpresc.add(drugs.get(j));
             }
         }
   }
   
   public ArrayList<Drug> getPresc(){
       return presc;
   }
   
   public ArrayList<Drug> getNonPresc(){
       return nonpresc;
   }
   
   public boolean getInDB(){
       return inDb;
   }
   
   public boolean getMedical(){
       return medical;
   }
   
   public boolean getDrug(){
       return drug;
   }
   
  public void setInDB(boolean inDb){
      this.inDb = inDb;
  } 
  
  public String [] getItems(){
      return items;
  }
}  