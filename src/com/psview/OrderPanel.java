/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psview;

import com.psdb.DataBaseManagment;
import com.psmodel.product.Drug;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Pascal
 * 
 */
public class OrderPanel extends JPanel {
    private JButton orderBtn;
    private JButton backToMenuBtn;
    private JButton add;
    private JButton delete;
    private JLabel cost;
    private JLabel price;
    private JLabel cname;
    private JCheckBox prescriptionRequired;
    private String  customerName;
    private JTextField name;
    private JList cart;
    private JLabel cartLabel;
    private JList prescriptionList;
    private JLabel prescriptionLabel;
    private JList nonPre;
    private JLabel nonPreLabel;
    private DefaultListModel<String> model;
    private DefaultListModel<String> model1;
    private DefaultListModel<String> dlm;
    private DataBaseManagment dbms;
    
    public OrderPanel() {
        
        model = new DefaultListModel<>();
        model1 = new DefaultListModel<>();
        dlm = new DefaultListModel<>();
        backToMenuBtn = new JButton("Back to Main Menu");
        orderBtn = new JButton("Proceed to checkout");
        cost = new JLabel("Price is ");
        name = new JTextField();
        cart = new JList(dlm);
        cartLabel = new JLabel("Cart");
        prescriptionList = new JList(model);
        prescriptionLabel = new JLabel("Prescription Drugs");
        nonPre = new JList(model1);
        nonPreLabel = new JLabel("non Prescription Drugs");
        add = new JButton("Add to cart");
        delete = new JButton("Delete from cart");
        price = new JLabel();
        
        customerName = name.getText();
        
        cname = new JLabel("Please enter Customer name and press enter");
        
       
        cname.setBounds(100,50,300,20);// name label
        name.setBounds(400,50,150,20); // name text field
        
        add.setBounds(200,400,150,20);
        delete.setBounds(400,400,150,20);
         
        prescriptionList.setBounds(150,150,50,200);
        prescriptionLabel.setBounds(130,130,150,20);
        prescriptionList.setVisible(false);
        prescriptionLabel.setVisible(false);
        
        nonPre.setBounds(350,150,50,200);
        nonPreLabel.setBounds(330,130,150,20);
         
        cart.setBounds(550,150,50,200);// shopping cart
        cartLabel.setBounds(550,130,50,20);
        
        backToMenuBtn.setBounds(100,450,150,20);
        orderBtn.setBounds(400,450,250,20);
        cost.setBounds(600,300,100,20);
        price.setBounds(650,300,50,20);
        this.setVisible(true);
        this.setLayout(null);
        this.add(backToMenuBtn);
        this.add(orderBtn);
        
        this.add(name);
        this.add(cname);
        
        this.add(cartLabel);
        this.add(cart);
        this.add(price);
        this.add(cost);
        
        this.add(prescriptionList);
        this.add(prescriptionLabel);
        
        this.add(nonPre);
        this.add(nonPreLabel);
        
        this.add(add);
        this.add(delete);
        
    }
    
    public void updateCost(){
        int size = cart.getModel().getSize();
        String name;
        ArrayList<String> items = new ArrayList<String>();
        for(int i = 0; i < size; i++){
           name = cart.getModel().getElementAt(i).toString();
           items.add(name);
        }
        dbms = new DataBaseManagment();
  
        ArrayList<Drug> drugs = new ArrayList<Drug>();
        drugs = dbms.getDrugs();
        
        
        drugs = new ArrayList<Drug>(dbms.getDrugs());
        Drug a = new Drug(4,"ket",20,100,false);
        Drug b = new Drug(5,"heroine",40,1000,true);
        Drug c = new Drug(6,"calpol",20,100,false);
        Drug d = new Drug(7,"DMX",40,1000,true);
        drugs.add(a);
        drugs.add(b);
        drugs.add(c);
        drugs.add(d);
        
        
        
        
        double prices=0;
        
        for(int j = 0; j < items.size();j++){
            //System.out.println(drugs.get(j));
            for(int k = 0; k < drugs.size(); k++ ){
                if(items.get(j).equalsIgnoreCase(drugs.get(k).getName())){
                    prices += drugs.get(j).getPrice();
                }
            }
        }
       
        price.setText(Double.toString(prices));
    }
    
    public void deleteFromCart(){
        System.out.println("deleting from cart");
        cart.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        int selectedIndex = cart.getSelectedIndex();
        if (selectedIndex != -1) {
        dlm.remove(selectedIndex);
        clearSelections();
        updateCost();
    }
  }
    
    public void addItemsToCart(){
        System.out.println("adding to cart");
        prescriptionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        nonPre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        for (Iterator it = prescriptionList.getSelectedValuesList().iterator(); it.hasNext();) {
            
                String sel = (String) it.next();
               // String sel1 = (String) it1.next();
                if (dlm.contains(sel)) {
                } else {
                    dlm.addElement(sel);
                    clearSelections();
                }  
        }
        
        for (Iterator it1 = nonPre.getSelectedValuesList().iterator(); it1.hasNext();) {
            String sel1 = (String) it1.next();
         if(dlm.contains(sel1)){

                }else{
                    dlm.addElement(sel1);
                    clearSelections(); 
                }
            }      
        updateCost();
    }  
    public void clearSelections(){
            cart.clearSelection();
            prescriptionList.clearSelection();
            nonPre.clearSelection();
        }
    public void setVisibilityPrescription() {
        prescriptionList.setVisible(true);
        prescriptionLabel.setVisible(true);
    }
    
    public void populateLists(ArrayList<Drug> presc,ArrayList<Drug> nonpresc) {
        
        System.out.println("adding to list");
        String name="";
        System.out.println(presc.size());
        for (int i=0;i<presc.size();i++)
        {
            name = presc.get(i).getName();
            if(model.contains(name)){
                
            }
            else{
                System.out.println(name);
                model.addElement(name);
            }
        }
        for (int j=0;j<nonpresc.size();j++)
        {
            name = nonpresc.get(j).getName();
            if(model1.contains(name)){
                
            }
            else{
                System.out.println(name);
                model1.addElement(name);
            }
        }
    }
            
   public void addToCartListener(ActionListener listenerForAdd){
       add.addActionListener(listenerForAdd);
   }
    
   public void addDelListener(ActionListener listenerForDelete){
       delete.addActionListener(listenerForDelete);
   }
   
   public void addBackToMenu(ActionListener listenerForBackToMenuBtn){
        backToMenuBtn.addActionListener(listenerForBackToMenuBtn);
    }
    
    public void addOrderListener(ActionListener listenerForOrderBtn){
        name.addActionListener(listenerForOrderBtn);
    }
}

   
