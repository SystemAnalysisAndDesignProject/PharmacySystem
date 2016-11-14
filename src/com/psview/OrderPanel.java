/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psview;

import com.psdb.DataBaseManagment;
import com.psmodel.Cart.Cart;
import com.psmodel.PharmacyConstants;
import com.psmodel.product.Drug;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
    private String customerName;
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
    private JLabel p1;
    private JLabel p2;
    private JList payment;
    private DefaultListModel<String> paymentList;
    private JButton pay;
    private JLabel mess;
    private JLabel logo;
    private ImageIcon img;

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
        nonPreLabel = new JLabel("Non Prescription Drugs");
        add = new JButton("Add to cart");
        delete = new JButton("Delete from cart");
        price = new JLabel();
        p1 = new JLabel();
        p2 = new JLabel();
         paymentList = new DefaultListModel<>();
        payment = new JList(paymentList);
        paymentList.addElement("Cash");
        paymentList.addElement("Credit");
        paymentList.addElement("Debit");
        pay = new JButton("Pay Now");
        img = new ImageIcon(PharmacyConstants.pharmacyIconFilePath);
        logo = new JLabel();
        logo.setIcon(img);
        
        
      

        customerName = name.getText();

        cname = new JLabel("Please enter Customer name and press enter");

        cname.setBounds(100, 50, 300, 20);// name label
        name.setBounds(400, 50, 150, 20); // name text field

        add.setBounds(140, 400, 150, 20);
        delete.setBounds(330, 400, 150, 20);

        prescriptionList.setBounds(150, 150, 80, 200);
        prescriptionLabel.setBounds(130, 130, 150, 20);
        prescriptionList.setVisible(false);
        prescriptionLabel.setVisible(false);

        nonPre.setBounds(350, 150, 80, 200);
        nonPreLabel.setBounds(330, 130, 150, 20);
        
        payment.setBounds(350, 150, 80, 200);
        payment.setVisible(false);

        cart.setBounds(550, 150, 80, 200);// shopping cart
        cartLabel.setBounds(550, 130, 50, 20);

        backToMenuBtn.setBounds(600, 500, 150, 20);
        p1.setBounds(100, 400, 100, 20);
        p1.setVisible(false);
        p2.setBounds(400, 400, 250, 20);
        p2.setVisible(false);
        orderBtn.setBounds(520, 400, 170, 20);
        pay.setBounds(400,450,350,20);
        pay.setVisible(false);
        cost.setBounds(650, 300, 100, 20);
        price.setBounds(700, 300, 50, 20);
        logo.setBounds(20,450,100,100);
        
        this.setVisible(true);
        this.setLayout(null);
        this.add(backToMenuBtn);
        this.add(pay);
        this.add(orderBtn);
        this.add(payment);
        this.add(name);
        this.add(cname);

        this.add(cartLabel);
        this.add(cart);
        this.add(price);
        this.add(cost);
        this.add(p1);
        this.add(p2);

        this.add(prescriptionList);
        this.add(prescriptionLabel);

        this.add(nonPre);
        this.add(nonPreLabel);

        this.add(add);
        this.add(delete);
        this.add(logo);

        /////////////////////////////
    }

    public ArrayList<String> cartDetails() {
        int size = cart.getModel().getSize();
        String name;

        ArrayList<String> items = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            name = cart.getModel().getElementAt(i).toString();
            items.add(name);
        }
        return items;
    }

    public void deleteFromCart() {
        System.out.println("deleting from cart");
        cart.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        int selectedIndex = cart.getSelectedIndex();
        if (selectedIndex != -1) {
            dlm.remove(selectedIndex);
            clearSelections();

        }
    }
    
    public void setPrices(double cost){
        String b = Double.toString(cost);
        price.setText(b);
    }

    public void addCart(String[] items) {
        System.out.println("Adding presc to cart");

        for (int i = 0; i < items.length; i++) {
            if (!dlm.contains(items[i]) && model.contains(items[i])) {
                dlm.addElement(items[i]);
            }
        }
    }

    public void addItemsToCart(String items) {
        System.out.println("adding to cart");
        prescriptionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        nonPre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        System.out.println("test 1");

        for (Iterator it = prescriptionList.getSelectedValuesList().iterator(); it.hasNext();) {

            String sel = (String) it.next();
            // String sel1 = (String) it1.next();
            if (dlm.contains(sel)) {
            } else {
                if(!items.contains(sel)){
                    
                }
                else{
                dlm.addElement(sel);
                clearSelections();
                }
            }
        }

        for (Iterator it1 = nonPre.getSelectedValuesList().iterator(); it1.hasNext();) {
            String sel1 = (String) it1.next();
            if (dlm.contains(sel1)) {

            } else {
                dlm.addElement(sel1);
                clearSelections();
            }
        }

    }

    public void clearSelections() {
        cart.clearSelection();
        prescriptionList.clearSelection();
        nonPre.clearSelection();
    }

    public void setVisibilityPrescription() {
        prescriptionList.setVisible(true);
        prescriptionLabel.setVisible(true);
    }

    public void populateLists(ArrayList<Drug> presc, ArrayList<Drug> nonpresc, String[] items) {

        System.out.println("adding to list");
        String name = "";
        addCart(items);
        //System.out.println(presc.size());
        System.out.println("A");
        for (int i = 0; i < presc.size(); i++) {
            name = presc.get(i).getName();
            System.out.println("B");
            if (model.contains(name)) {

            } else {
                System.out.println(name);
                model.addElement(name);
            }
        }
        for (int j = 0; j < nonpresc.size(); j++) {
            name = nonpresc.get(j).getName();
            if (model1.contains(name)) {

            } else {
                System.out.println(name);
                model1.addElement(name);
            }
        }
    }

    public void displayCheckout(double price1, double price2) {
        cname.setVisible(false);
        name.setVisible(false);
        cart.setVisible(false);
        cartLabel.setVisible(false);
        orderBtn.setVisible(false);
        nonPre.setVisible(false);
        prescriptionList.setVisible(false);
        prescriptionLabel.setVisible(false);
        nonPreLabel.setVisible(false);
        add.setVisible(false);
        delete.setVisible(false);
        price.setVisible(false);
        cost.setBounds(450, 150, 100, 20);
        p2.setBounds(500,150,100,20);
        String x = Double.toString(price1);
        p1.setText(x);
        String y = Double.toString(price2);
        p2.setText(y);
        payment.setVisible(true);
        p1.setVisible(false);
        p2.setVisible(true);
        pay.setVisible(false);
        
        payment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
               
        mess = new JLabel("Select payment option and press pay");
        this.add(mess);
        mess.setBounds(100,150,250,20);
        mess.setVisible(true);

        pay.setVisible(true);
    }

    public void displayReceipt(String cusname, ArrayList<String> items, double finalPrice){
        cname.setVisible(false);
        name.setVisible(false);
        cart.setVisible(false);
        cartLabel.setVisible(false);
        orderBtn.setVisible(false);
        nonPre.setVisible(false);
        prescriptionList.setVisible(false);
        prescriptionLabel.setVisible(false);
        nonPreLabel.setVisible(false);
        add.setVisible(false);
        delete.setVisible(false);
        String x = Double.toString(finalPrice);
        JTextField field = new JTextField(x);
        p1.setText(x);
        cost.setVisible(false);
        price.setVisible(false);

        payment.setVisible(false);
        p1.setVisible(false);

        Object paymenttype = payment.getSelectedValue();
        String payment;
        if(paymenttype == null){
            payment = "Medical Card";
        }
        else{
            payment = paymenttype.toString();
        }
        String item=""; 
        for(int i = 0; i < items.size(); i++){
            item += items.get(i) + "\n";
        }
        JOptionPane.showMessageDialog(null,"Customer Name : " + cusname + "\n" + "Products : " + item + "\n" + "Price : " 
                + finalPrice + "\n" + "Payed by : " + payment,"Receipt",1 );
    }
    public void setOrderInvisible(){
        this.setVisible(false);
    }
    
    public String getCustomerName(){
        String cname = name.getText();      
        return cname;
    }
    
    public boolean getPayment(){
        return payment.isSelectionEmpty();
    }
    
    public boolean getPayments(){
        return cart.isSelectionEmpty();
    }

    public void addToCartListener(ActionListener listenerForAdd) {
        add.addActionListener(listenerForAdd);
    }

    public void addDelListener(ActionListener listenerForDelete) {
        delete.addActionListener(listenerForDelete);
    }

    public void addBackToMenu(ActionListener listenerForBackToMenuBtn) {
        backToMenuBtn.addActionListener(listenerForBackToMenuBtn);
    }

    public void addOrderListener(ActionListener listenerForOrderBtn) {
        name.addActionListener(listenerForOrderBtn);
    }

    public void addCheckoutListener(ActionListener listenerForCheckout) {
        orderBtn.addActionListener(listenerForCheckout);
    }
    
    public void addPayListener(ActionListener listenerForPay){
        pay.addActionListener(listenerForPay);
    }
}

