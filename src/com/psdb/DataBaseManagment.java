package com.psdb;

import com.psmodel.user.Permission;
import com.psmodel.PharmacyConstants;
import com.psmodel.customer.Customer;
import com.psmodel.perscription.Prescription;
import com.psmodel.user.User;
import com.psmodel.user.UserFactory;
import com.psmodel.product.Drug;
import com.psmodel.product.DrugFactory;
import com.psmodel.sales.SalesDetails;
import com.psview.ModifyPanel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseManagment {
    
    private ArrayList<User> users;
    private ArrayList<Drug> drugs;
    private ArrayList<Customer> customers;
    private ArrayList<Prescription> prescriptions; 
    private int [] salesDetailsArray;
    private ModifyPanel modifyPanel;
    
    public DataBaseManagment(){
        readUsers();
        readDrugs();
        readCustomers();
        readSalesDetails();
        readPrescriptions();
    }
    
    private void readPrescriptions(){
        BufferedReader br = null;        
        try{
            String currentLine;
            prescriptions = new ArrayList<Prescription>();
            drugs = new ArrayList<Drug>();
            br = new BufferedReader(new FileReader(PharmacyConstants.prescriptionFilePath));
            
            while((currentLine = br.readLine()) != null){
                
                String [] tempPrescription = currentLine.split(",");
              
                String pres = tempPrescription[2];
                String name = tempPrescription[0];
                String gpName = tempPrescription[1];
                int prescriptionID = Integer.parseInt(tempPrescription[3]);
                
                Prescription prescription = new Prescription(name,gpName,pres,prescriptionID);
                
                System.out.println(prescription.getDescription());
               prescriptions.add(prescription);
            }            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void readUsers(){ 
        BufferedReader br = null;        
        try{
            String currentLine;
            users = new ArrayList<User>();
            
            br = new BufferedReader(new FileReader(PharmacyConstants.usersFilePath));
            
            while((currentLine = br.readLine()) != null){
                
                String [] tempUser = currentLine.split(",");
                UserFactory userFactory = new UserFactory();
                
                User user = userFactory.makeUser(tempUser[2]);
                user.setUsername(tempUser[0]);
                user.setPassword(tempUser[1]);
                user.setRole(tempUser[2]);
                user.setPermission(new Permission(Boolean.parseBoolean(tempUser[3]),
                                                  Boolean.parseBoolean(tempUser[4]),
                                                  Boolean.parseBoolean(tempUser[5]),
                                                  Boolean.parseBoolean(tempUser[6])));
               
                users.add(user);
            }            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void readDrugs(){
        
        BufferedReader br = null;        
        try{
            String currentLine;
            drugs = new ArrayList<Drug>();
            
            br = new BufferedReader(new FileReader(PharmacyConstants.drugsFilePath));
            
            while((currentLine = br.readLine()) != null){
                
                String [] tempDrug = currentLine.split(",");
                DrugFactory drugFactory = new DrugFactory();
                
                Drug drug = drugFactory.makeDrug(Integer.parseInt(tempDrug[0]),tempDrug[1],
                                          Integer.parseInt(tempDrug[2]),Double.parseDouble(tempDrug[3]),
                                          Boolean.parseBoolean(tempDrug[4]));
                
                System.out.println(drug.getDescription());
               
                drugs.add(drug);
            }            
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    
    public void updateDrugsFile(ArrayList<Drug> drugs) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(PharmacyConstants.drugsFilePath));
        String line ="";
        
        for(int i = 0; i < drugs.size(); i++){
            line = drugs.get(i).getProductID() + "," + drugs.get(i).getName() + "," + drugs.get(i).getQuantity()
                    + "," + drugs.get(i).getPrice() + "," + drugs.get(i).checkRequiresPerscription();
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
    
    public void updateSales(int [] num){
        System.out.println("updating sales");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(PharmacyConstants.salesDetailsFilePath));
            String line = num[0] + "," + num[1] + "," + num[2];
            writer.write(line);
            
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(DataBaseManagment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void readCustomers(){
        BufferedReader br = null;        
        try{
            String currentLine;
            customers = new ArrayList<Customer>();
            
            br = new BufferedReader(new FileReader(PharmacyConstants.customersFilePath));
            
            while((currentLine = br.readLine()) != null){
                
                String [] tempCustomer = currentLine.split(",");
                Customer customer = new Customer(Integer.parseInt(tempCustomer[0]),tempCustomer[1],tempCustomer[2],
                                                tempCustomer[3],
                                                Integer.parseInt(tempCustomer[4]),
                                                Boolean.parseBoolean(tempCustomer[5]),
                                                Boolean.parseBoolean(tempCustomer[6]));
                
                System.out.println(customer.getCustomerID());
                
               
                customers.add(customer);
            }            
        }catch(IOException e){
            e.printStackTrace();
        }
    }   
    
    public void readSalesDetails(){ 
        BufferedReader br = null;        
        SalesDetails salesDetails = new SalesDetails();
        try{
            String currentLine;
            salesDetailsArray = new int[3];            
            br = new BufferedReader(new FileReader(PharmacyConstants.salesDetailsFilePath));
            
            while((currentLine = br.readLine()) != null){
                
                String [] tempSalesDetails = currentLine.split(",");
                for(int i = 0; i < tempSalesDetails.length; i++)
                {
                    salesDetailsArray[i] = Integer.parseInt(tempSalesDetails[i]);
                }
         
            }
            
            salesDetails.setMedicalCardSales(salesDetailsArray[0]);
            salesDetails.setDrugSchemeSales(salesDetailsArray[1]);
            salesDetails.setRegularSales(salesDetailsArray[2]);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //////////////////////////////////////////////
    public void writeToCustomerArray(String something){ 
    try{
    String fileAdd = something;
    String[] array = fileAdd.split(",");
    System.out.println("a");    
    FileWriter fw = new FileWriter(PharmacyConstants.customersFilePath); //the true will append the new data
    Customer customer = new Customer(Integer.parseInt(array[0]),array[1],array[2],array[3],
                                                Integer.parseInt(array[4]),
                                                Boolean.parseBoolean(array[5]),
                                                Boolean.parseBoolean(array[6]));
    System.out.println("GOOD");
    customers.add(customer);
    System.out.println("b");
    for(int i = 0; i < customers.size(); i++)
        {
            fw.write(customers.get(i).getCustomerID() + "," +
                    customers.get(i).getCustomerName() + "," +
                    customers.get(i).getDateOfBirth() + "," +
                    customers.get(i).getAddress() + "," + 
                    customers.get(i).getContactNumber() + "," +
                    customers.get(i).getMedical() + "," +
                    customers.get(i).getDrug() + System.lineSeparator());
         
        }
    fw.close();
    }
    catch(IOException e)
        {
            e.printStackTrace();
        }  
    
    }
 
    public void updateEmployeeTable(String textField){ 
    try{
    String fileAdd = textField;
    String[] employeeArray = fileAdd.split(",");
    FileWriter fileWriter = new FileWriter(PharmacyConstants.usersFilePath); //the true will append the new data
    UserFactory userFactory = new UserFactory();
    User employees = userFactory.makeUser(employeeArray[2]);
                        employees.setUsername(employeeArray[0]);
                        employees.setPassword(employeeArray[1]);
                        employees.setRole(employeeArray[2]);
                        employees.setPermission(new Permission(Boolean.parseBoolean(employeeArray[3]),
                                                                Boolean.parseBoolean(employeeArray[4]),
                                                                Boolean.parseBoolean(employeeArray[5]),
                                                                Boolean.parseBoolean(employeeArray[6])));
               
    users.add(employees);
    for(int i = 0; i < users.size(); i++)
        {
            
            fileWriter.write(users.get(i).getUsername() + "," +
                    users.get(i).getPassword() + "," +
                    users.get(i).getRole() + "," +
                    users.get(i).getPermission().getCanModifyCustomer() + "," + 
                    users.get(i).getPermission().getCanModifyEmployee() + "," +
                    users.get(i).getPermission().getCanModifyProducts() + "," +
                    users.get(i).getPermission().getCanModifyProducts() + System.lineSeparator());
         
        }
     fileWriter.close();
    }
   
    catch(IOException e)
        {
            e.printStackTrace();
        }  
    }
    
    public void deleteCustomerEntry(String data) throws IOException{
        //tring input = modifyPanel.deleteCustomerTextFieldFromFile();
        //System.out.println(input);
        FileWriter newCustomerFile = new FileWriter(PharmacyConstants.customersFilePath);
        try{    
            if(!data.equals("")){
                
            int deleteCustomer = Integer.parseInt(data) -1;
            
            System.out.println(deleteCustomer + "costam");
            customers.remove(deleteCustomer);
        
            for(int a = 0; a < customers.size(); a++)
            {
                    newCustomerFile.write(customers.get(a).getCustomerID() + "," +
                    customers.get(a).getCustomerName() + "," +
                    customers.get(a).getDateOfBirth() + "," +
                    customers.get(a).getAddress() + "," + 
                    customers.get(a).getContactNumber() + "," +
                    customers.get(a).getMedical() + "," +
                    customers.get(a).getDrug() + System.lineSeparator());
            }
            newCustomerFile.close(); 
            }            
        }catch(NumberFormatException e){
            
        }catch(NullPointerException e){
            
        }             
    }
    
    public void deleteEmployeeEntry(String employee) throws IOException{
        FileWriter fWriter = new FileWriter(PharmacyConstants.usersFilePath); 
        try{   
            if(!employee.equals("")){
             int input = Integer.parseInt(employee)-1;
             
                  users.remove(input);     
  
            for(int i = 0; i < users.size(); i++)
            {
                    fWriter.write(users.get(i).getUsername() + "," +
                    users.get(i).getPassword() + "," +
                    users.get(i).getRole() + "," +
                    users.get(i).getPermission().getCanModifyCustomer() + "," + 
                    users.get(i).getPermission().getCanModifyEmployee() + "," +
                    users.get(i).getPermission().getCanModifyProducts() + "," +
                    users.get(i).getPermission().getCanModifyProducts() + System.lineSeparator());
        
            }
            fWriter.close();
             }            
        }catch(NumberFormatException e){
            
        }catch(NullPointerException e){
            
        }
    }
    
    public ArrayList<User> getUsers(){  
        readUsers();
        return users;
    }
    
    public ArrayList<Drug> getDrugs(){
        readDrugs();
        return drugs;
    }
    
    public ArrayList<Customer> getCustomers(){
        readCustomers();
        return customers;
    }
    
    public int [] getSalesDetailsArray(){
        return salesDetailsArray;
    }
    
    public ArrayList<Prescription> getPrescriptions(){
        readPrescriptions();
        return prescriptions;
    }
}
