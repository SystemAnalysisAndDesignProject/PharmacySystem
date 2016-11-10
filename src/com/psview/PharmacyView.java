
package com.psview;

import com.psdb.DataBaseManagment;
import com.psmodel.product.Drug;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
    
    
    public PharmacyView()
    {
        super("Pharmacy System");
        loginPanel = new LoginPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);        
        this.setLocationRelativeTo(null);
        this.add(loginPanel);            
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
            System.out.println("dop");

        order = new OrderPanel();
            System.out.println("op init");

        this.add(order);
            System.out.println("op added");

        mainMenuPanel.setVisible(false);
       this.setVisible(true);
    }
    
    public void displayMainMenuManager(){
        
        mainMenuPanel = new MainMenuPanel();
        loginPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(Color.red);
        mainMenuPanel.setWelcomeLbl("Welcome Manager");
        mainMenuPanel.salesReportBtnVisibility(true);
    }
    
    public void displayMainMenuEmployee(){
        mainMenuPanel = new MainMenuPanel();
        loginPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(Color.blue);
        mainMenuPanel.setWelcomeLbl("Welcome Employee");
    }
    
    //Main Menu Panel    
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
    
    public void displayMainMenuManagerFromModify(){
        modifyPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(Color.red);
        mainMenuPanel.setWelcomeLbl("Welcome Manager");
    }
    
    public void displayMainMenuEmployeeFromModify(){
        modifyPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(Color.blue);
        mainMenuPanel.setWelcomeLbl("Welcome Employee");
    }
    
    
    
    
    
    public void displayMainMenuManagerFromSalesReports(){
        salesReportPanel.setVisible(false);
        this.add(mainMenuPanel);        
        mainMenuPanel.setVisible(true);
        mainMenuPanel.setBackground(Color.red);
        mainMenuPanel.setWelcomeLbl("Welcome Manager");
    }
    //Modify Panel
    
    public void displayModifyManager(){
        modifyPanel = new ModifyPanel();
        mainMenuPanel.setVisible(false);        
        this.add(modifyPanel);        
        modifyPanel.setVisible(true);
        modifyPanel.setBackground(Color.red);
    }
    
    public void displayModifyEmployee(){
        modifyPanel = new ModifyPanel();
        modifyPanel.setVisibilityForEmployee();
        mainMenuPanel.setVisible(false);        
        this.add(modifyPanel);        
        modifyPanel.setVisible(true);
        modifyPanel.setBackground(Color.blue);
    }
    
    public void displaySalesReport(){
       salesReportPanel = new SalesReportPanel();
       mainMenuPanel.setVisible(false);
       this.add(salesReportPanel);
       salesReportPanel.setVisible(true);
       salesReportPanel.setBackground(Color.red);
    }
    
    public void setVisibilityForCustomer(){
        modifyPanel.setVisibilityForCustomerDetails(customerBtnClicked);
        customerBtnClicked = !customerBtnClicked;
    }
    
    public void addCustomerListener(ActionListener listenerForCustomerBtn){
        modifyPanel.addCustomerListener(listenerForCustomerBtn);
    }
    
    public void addManagerListener(ActionListener listenerForManagerBtn){
        modifyPanel.addManagerListener(listenerForManagerBtn);
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
    
    public void setVisibilityOrder(){
        order.setVisibilityPrescription();
    }
    
    public void populateList(ArrayList<Drug> presc,ArrayList<Drug> nonpresc){        
        order.populateLists(presc,nonpresc);
    }
    
    public void addToCartListener(ActionListener listenerForAdd){
        order.addToCartListener(listenerForAdd);
    }
    
    public void addToCart(){
        order.addItemsToCart();
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
    
    public void addUpdateListener(ActionListener listenerForUpdateButton){
        modifyPanel.addUpdateListener(listenerForUpdateButton);
    }
    
    
    
    public void addAddListenerForEmployee(ActionListener listenerForAddButtonForEmployee){
        modifyPanel.addAddListenerForEmployee(listenerForAddButtonForEmployee);
    }
    
    public void addDeleteListenerForEmployee(ActionListener listenerForDeleteButtonForEmployee){
        modifyPanel.addDeleteListenerForEmployee(listenerForDeleteButtonForEmployee);
    }
    
    public void addUpdateListenerForEmployee(ActionListener listenerForUpdateButtonForEmployee){
        modifyPanel.addUpdateListenerForEmployee(listenerForUpdateButtonForEmployee);
    }
  
    public void addTextFieldListener(ActionListener listenerForAddTextField){
        modifyPanel.addTextFieldListener(listenerForAddTextField);
    }
    
    public void deleteTextFieldListener(ActionListener listenerForDeleteTextField){
        modifyPanel.deleteTextFieldListener(listenerForDeleteTextField);
    }
    
    public void updateTextFieldListener(ActionListener listenerForUpdateTextField){
        modifyPanel.updateTextFieldListener(listenerForUpdateTextField);
    }
    
    public void employeeAddTextFieldListener(ActionListener listenerForEmployeeAddTextField){
        modifyPanel.employeeAddTextFieldListener(listenerForEmployeeAddTextField);
    }
    
    public void employeeDeleteTextFieldListener(ActionListener listenerForEmployeeDeleteTextField){
        modifyPanel.employeeDeleteTextFieldListener(listenerForEmployeeDeleteTextField);
    }
    
    public void employeeUpdateTextFieldListener(ActionListener listenerForEmployeeUpdateTextField){
        modifyPanel.employeeUpdateTextFieldListener(listenerForEmployeeUpdateTextField);
    }
    
    public void UpdateButtons(){ //add delete update buttons for customers
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
        modifyPanel.setUpdateInvisible();
        modifyPanel.setAddInvisibleForEmployee();
        modifyPanel.setDeleteInvisibleForEmployee();
        modifyPanel.setUpdateInvisibleForEmployee();
    }
    
    public void addOptionsForEmployee(){
        modifyPanel.changeEmployeeAddJLabel();
        modifyPanel.setAddVisibleForEmployee();
        modifyPanel.setDeleteInvisibleForEmployee();
        modifyPanel.setUpdateInvisibleForEmployee();
        modifyPanel.setAddInvisible();
        modifyPanel.setDeleteInvisible();
        modifyPanel.setUpdateInvisible();
        
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
        modifyPanel.setUpdateInvisible();
        modifyPanel.setAddInvisible();
        modifyPanel.setAddInvisibleForEmployee();
        modifyPanel.setDeleteInvisibleForEmployee();
        modifyPanel.setUpdateInvisibleForEmployee();
    }
    
    public void deleteOptionsForEmployee(){
        modifyPanel.setAddInvisible();
        modifyPanel.setUpdateInvisible();
        modifyPanel.changeEmployeeDeleteJLabel();
        modifyPanel.setAddInvisibleForEmployee();
        modifyPanel.setDeleteInvisible();
        modifyPanel.setUpdateInvisibleForEmployee();
        modifyPanel.setDeleteVisibleForEmployee();
    }
        
        
    public void dontShowDeleteOptions(){
        modifyPanel.setDeleteInvisible();
    }
    
    public void updateOptionsForCustomer(){
        modifyPanel.setUpdateVisible();
        modifyPanel.changeCustomerUpdateJLabel();
        modifyPanel.setAddInvisible();
        modifyPanel.setDeleteInvisible();
        modifyPanel.setAddInvisibleForEmployee();
        modifyPanel.setDeleteInvisibleForEmployee();
        modifyPanel.setUpdateInvisibleForEmployee();
    }
    
    public void updateOptionsForEmployee(){
        modifyPanel.setAddInvisible();
        modifyPanel.setDeleteInvisible();
        modifyPanel.setUpdateInvisible();
        modifyPanel.changeEmployeeUpdateJLabel();
        modifyPanel.setDeleteInvisibleForEmployee();
        modifyPanel.setAddInvisibleForEmployee();
        modifyPanel.setUpdateVisible();
    }
    
    public void dontShowUpdateOptions(){
        modifyPanel.setUpdateInvisible();
    }
    
    public void TextFieldToFile(){
        modifyPanel.addTextFieldToFile();
    }
   
    public void employeeAddJLabel(){
        modifyPanel.changeEmployeeAddJLabel();
    }
    
    public void employeeDeleteJLabel(){
        modifyPanel.changeEmployeeDeleteJLabel();
    }
    
    public void employeeUpdateJlabel(){
        modifyPanel.changeEmployeeUpdateJLabel();
    }
    
    public void dontShowButtonsForProduct(){
        modifyPanel.setUpdateButtonsInvisible();
    }
    
    public void dontShowJLabel(){
        modifyPanel.setJLabelInvisible();
    }
    
}
