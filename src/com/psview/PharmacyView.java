
package com.psview;

import com.psdb.DataBaseManagment;
import com.psmodel.PharmacyConstants;
import com.psmodel.product.Drug;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PharmacyView extends JFrame {
    
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    
    private LoginPanel loginPanel;
    private MainMenuPanel mainMenuPanel;
    private ModifyPanel modifyPanel;
    private DataBaseManagment dbm;
    private SalesReportPanel salesReportPanel;
    private OrderPanel order;
    private boolean customerBtnClicked = true;
    private Color managerColor;
    private Color employeeColor;
    
    
    public PharmacyView()
    {
        super("Pharmacy System");
        loginPanel = new LoginPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);        
        this.setLocationRelativeTo(null);
        this.add(loginPanel); 
        setIcon();
        managerColor = new Color(1,161,133);
        employeeColor = new Color(26,175,93);
    }
    
    private void setIcon(){
        ImageIcon img = new ImageIcon(PharmacyConstants.pharmacyIconFilePath);
        this.setIconImage(img.getImage());
    }
   public String getUsername(){
        return loginPanel.getUsernameTxt();
    }
    
    public String getPassword(){
        return loginPanel.getPassword();
    }
    
    public void addLoginListener(ActionListener listenerForLoginBtn){
        loginPanel.addLoginListener(listenerForLoginBtn);
    }
    
    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }  
    
    public void clearPanel(){
        this.removeAll();
    }  
    
    public void displayOrderPanel(){
        order = new OrderPanel();
        this.add(order);
        mainMenuPanel.setVisible(false);
       this.setVisible(true);
    }
    
    public void displayMainMenuManager(){
        
        mainMenuPanel = new MainMenuPanel();
        loginPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        
        mainMenuPanel.setBackground(managerColor);
        mainMenuPanel.setWelcomeLbl("Welcome Manager");
        mainMenuPanel.salesReportBtnVisibility(true);
    }
    
    public void displayMainMenuEmployee(){
        mainMenuPanel = new MainMenuPanel();
        loginPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(employeeColor);
        mainMenuPanel.setWelcomeLbl("Welcome Employee");
        mainMenuPanel.setButtonsPosition();
    }
    
    public void displayOrderProcessEmployee(){
        order = new OrderPanel();
        mainMenuPanel.setVisible(false);
        this.add(order);        
        order.setVisible(true);
        order.setBackground(employeeColor);
    }
    
    public void displayOrderProcessManager(){
        order = new OrderPanel();
        mainMenuPanel.setVisible(false);
        this.add(order);        
        order.setVisible(true);
        order.setBackground(managerColor);
    }
    
    public void addModifyListener(ActionListener listenerForModifyBtn){
        mainMenuPanel.addModifyListener(listenerForModifyBtn);
    }
    
    public void addOrderProcessListener(ActionListener listenerForOrderProcessBtn){
        mainMenuPanel.addOrderProcessListener(listenerForOrderProcessBtn);
    }
    
    public void addLogoutListener(ActionListener listenerForLogoutBtn){
        mainMenuPanel.addLogoutListener(listenerForLogoutBtn);
    }
    
    public void displayLoginPanel(){
        mainMenuPanel.setVisible(false);
        this.add(loginPanel);
        loginPanel.setVisible(true);
        loginPanel.clearPanel();
    }
        
    public void displayTable(String[] columns, Object [][] drugs){
        modifyPanel.displayTable(columns,drugs);        
    }
    
    public ArrayList <String> getCartDetails(){
        ArrayList<String> items = order.cartDetails();
        return items;
    }
    
    public void displayCheckout(double price,double price1){
        order.displayCheckout(price, price1);
    }
    
    public void setPrice(double price){
        order.setPrices(price);
    }
    
    public void displayReceipt(String cname ,ArrayList<String> items , double finalPrice){
        order.displayReceipt(cname,items,finalPrice);
    }
    
    public boolean checkForSelection(){
        return order.getPayment();
    }
    
    public boolean checkForSelections1(){
        return order.getPayments();
    }
    
    public void displayMainMenuManagerFromOrder(){
       order.setVisible(false); 
       this.add(mainMenuPanel);
       mainMenuPanel.setVisible(true);
       mainMenuPanel.setBackground(managerColor);
       mainMenuPanel.setWelcomeLbl("Welcome Manager");
    }
    
    public void displayMainMenuEmployeeFromOrder(){
       order.setVisible(false); 
       this.add(mainMenuPanel);
       mainMenuPanel.setVisible(true);
       mainMenuPanel.setBackground(employeeColor);
       mainMenuPanel.setWelcomeLbl("Welcome Employee");
    }
        
    
    public void displayMainMenuManagerFromModify(){
        modifyPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(managerColor);
        mainMenuPanel.setWelcomeLbl("Welcome Manager");
    }
    
    public void displayMainMenuEmployeeFromModify(){
        modifyPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(employeeColor);
        mainMenuPanel.setWelcomeLbl("Welcome Employee");
    }   
    
    public void displayMainMenuManagerFromSalesReports(){
        salesReportPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(managerColor);
        mainMenuPanel.setWelcomeLbl("Welcome Manager");
    }
    
    public void displayModifyManager(){
        modifyPanel = new ModifyPanel();
        mainMenuPanel.setVisible(false);        
        this.add(modifyPanel);        
        modifyPanel.setVisible(true);
        modifyPanel.setBackground(managerColor);
    }
    
    public void displayModifyEmployee(){
        modifyPanel = new ModifyPanel();
        modifyPanel.setVisibilityForEmployee();
        mainMenuPanel.setVisible(false);        
        this.add(modifyPanel);        
        modifyPanel.setVisible(true);
        modifyPanel.setBackground(employeeColor);
    }
public void setOrderInvisible(){
    order.setOrderInvisible();
}
    
    public void displaySalesReport(){
       salesReportPanel = new SalesReportPanel();
       mainMenuPanel.setVisible(false);
       this.add(salesReportPanel);
       salesReportPanel.setVisible(true);
       salesReportPanel.setBackground(managerColor);
    } 
    
    public void setVisibilityForCustomer(){
        modifyPanel.setVisibilityForCustomerDetails(customerBtnClicked);
        customerBtnClicked = !customerBtnClicked;
    }
    
    public void addCustomerListener(ActionListener listenerForCustomerBtn){
        modifyPanel.addCustomerListener(listenerForCustomerBtn);
    }
    
    public void addEmployeeListener(ActionListener listenerForEmployeeBtn){
        modifyPanel.addEmployeeListener(listenerForEmployeeBtn);
    }
    
    public void addProductListener(ActionListener listenerForProductBtn){
        modifyPanel.addProductListener(listenerForProductBtn);
    }
    
    public void addBackToMenuListener(ActionListener listenerForBackToMenuBtn){
        modifyPanel.addBackToMenuListener(listenerForBackToMenuBtn);
    }
    public void addBackToMenu(ActionListener listenerForBackToMenuBtn){
        order.addBackToMenu(listenerForBackToMenuBtn);
    }
     public void addBackToMainMenuFromSalesReportsListener(ActionListener listenerForBackToMenuBtn){
        salesReportPanel.addBackToMainMenuListener(listenerForBackToMenuBtn);
    }
    
    public void addSalesReportsListener(ActionListener listenerForSalesReportBtn){
        mainMenuPanel.addSalesReportsListener(listenerForSalesReportBtn);
    }
    
    public void addOrderListener(ActionListener listenerForOrderBtn){
        order.addOrderListener(listenerForOrderBtn);
    }
    
    public void addPayListener(ActionListener listenerForPay){
        order.addPayListener(listenerForPay);
    }
    
    public void setVisibilityOrder(){
        order.setVisibilityPrescription();
    }
    
    public String getCustomerName(){
        return order.getCustomerName();
    }
    
    
    public void populateList(ArrayList<Drug> presc,ArrayList<Drug> nonpresc,String [] items){        
        order.populateLists(presc,nonpresc,items);
    }
    
    public void addToCartListener(ActionListener listenerForAdd){
        order.addToCartListener(listenerForAdd);
    }
    
    public void addToCart(String items){
        order.addItemsToCart(items);
    }
    
    public void addCart(String [] items){
        order.addCart(items);
    }
    
    public void addCheckoutListener(ActionListener listenerForCheckout){
        order.addCheckoutListener(listenerForCheckout);
    }
    
   public void addDelListener(ActionListener listenerForDelete){
        order.addDelListener(listenerForDelete);
    }
            
    public void deleteFromCart(){
        order.deleteFromCart();
    }
    
     public void addAddListener(ActionListener listenerForAddButton){
        modifyPanel.addAddListener(listenerForAddButton);
    }
    
    public void addDeleteListener1(ActionListener listenerForDeleteButton){
        modifyPanel.addDeleteListener1(listenerForDeleteButton);
    }
    
    public void addAddListenerForEmployee(ActionListener listenerForAddButtonForEmployee){
        modifyPanel.addAddListenerForEmployee(listenerForAddButtonForEmployee);
    }
    
    public void addDeleteListenerForEmployee(ActionListener listenerForDeleteButtonForEmployee){
        modifyPanel.addDeleteListenerForEmployee(listenerForDeleteButtonForEmployee);
    }
    
    public void addTextFieldListener(ActionListener listenerForAddTextField){
        modifyPanel.addTextFieldListener(listenerForAddTextField);
    }
    
    public void deleteTextFieldListener(ActionListener listenerForDeleteTextField){
        modifyPanel.deleteTextFieldListener(listenerForDeleteTextField);
    }
    
    public void employeeAddTextFieldListener(ActionListener listenerForEmployeeAddTextField){
        modifyPanel.employeeAddTextFieldListener(listenerForEmployeeAddTextField);
    }
    
    public void employeeDeleteTextFieldListener(ActionListener listenerForEmployeeDeleteTextField){
        modifyPanel.employeeDeleteTextFieldListener(listenerForEmployeeDeleteTextField);
    }
    
    public void UpdateButtons(){
        modifyPanel.setUpdateButtonsVisible();
    }
    
    public void employeeUpdateButtons(){
        modifyPanel.setUpdateButtonsForEmployeeVisible();
    }
    
    public void dontShowEmployeeUpdateButtons(){
        modifyPanel.setUpdateButtonsForEmployeeInvisible();
    }
    
    public void DontShowUpdateButtonsForManager(){
        modifyPanel.DontDisplayUpdatesForManager();
    }
    
    public void addOptionsForCustomer(){
        modifyPanel.setAddVisible();
        modifyPanel.changeCustomerAddJLabel();
        modifyPanel.setDeleteInvisible();
        modifyPanel.setAddInvisibleForEmployee();
        modifyPanel.setDeleteInvisibleForEmployee();
    }
    
    public void addOptionsForEmployee(){
        modifyPanel.changeEmployeeAddJLabel();
        modifyPanel.setAddVisibleForEmployee();
        modifyPanel.setDeleteInvisibleForEmployee();
        modifyPanel.setAddInvisible();
        modifyPanel.setDeleteInvisible();        
    }
    public void UButtonInvisible(){
        modifyPanel.setUpdateButtonsInvisible();
    }
    
    public void dontShowAddOptions(){
        modifyPanel.setAddInvisible();
    }
    
    public void deleteOptionsForCustomer(){
        modifyPanel.setDeleteVisible();
        modifyPanel.changeCustomerDeleteJLabel();
        modifyPanel.setAddInvisible();
        modifyPanel.setAddInvisibleForEmployee();
        modifyPanel.setDeleteInvisibleForEmployee();
    }
    
    public void deleteOptionsForEmployee(){
        modifyPanel.setAddInvisible();
        modifyPanel.changeEmployeeDeleteJLabel();
        modifyPanel.setAddInvisibleForEmployee();
        modifyPanel.setDeleteInvisible();
        modifyPanel.setDeleteVisibleForEmployee();
    }
        
        
    public void dontShowDeleteOptions(){
        modifyPanel.setDeleteInvisible();
    }
    
    public void updateOptionsForCustomer(){
        modifyPanel.setAddInvisible();
        modifyPanel.setDeleteInvisible();
        modifyPanel.setAddInvisibleForEmployee();
        modifyPanel.setDeleteInvisibleForEmployee();
    }
    
    public void updateOptionsForEmployee(){
        modifyPanel.setAddInvisible();
        modifyPanel.setDeleteInvisible();
        modifyPanel.setDeleteInvisibleForEmployee();
        modifyPanel.setAddInvisibleForEmployee();
    }
    
   public String TextFieldToFile(){
        return modifyPanel.addTextFieldToFile();
        }
   
    public String employeeAddTextFieldToFile(){
        return modifyPanel.addTextFieldForEmployeeToFile();
    }
    
    public String employeeDeleteTextFieldToFile(){
        return modifyPanel.deleteEmployeeTextFieldFromFile();
    }
    
    public String customerDeleteTextFieldToFile(){
        return modifyPanel.deleteCustomerTextFieldFromFile();
    }
   
   
    public void employeeAddJLabel(){
        modifyPanel.changeEmployeeAddJLabel();
    }
    
    public void employeeDeleteJLabel(){
        modifyPanel.changeEmployeeDeleteJLabel();
    }
    
    public void dontShowButtonsForProduct(){
        modifyPanel.setUpdateButtonsInvisible();
    }
    
    public void dontShowJLabel(){
        modifyPanel.setJLabelInvisible();
    }
    
    public void setTableInvisible(){
        modifyPanel.dontDisplayTable();
    }
    
    public void dontShowForProduct(){
        modifyPanel.dontShowButtonForProduct();
    }
}
