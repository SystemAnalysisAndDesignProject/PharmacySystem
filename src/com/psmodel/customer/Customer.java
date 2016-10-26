package com.psmodel.customer;

import com.psmodel.perscription.Prescription;

public class Customer implements ICustomer {
    private int customerID;
    private String customerName;
    private String dob;
    private String address;
    private int contactNumber;
    private boolean medicalCard;
    private boolean drugScheme;
    
    public Customer(int custID,String name, String dOB, String addr, int number, boolean medical, boolean drug) {
        customerID = custID;
        customerName = name;
        dob = dOB;
        address = addr;
        contactNumber = number;

        medicalCard = medical;
        drugScheme = drug;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public int getCustomerID(){
        return customerID;
    }
    
    public String getDateOfBirth() {
        return dob;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getContactNumber() {
        return contactNumber;
    }

    public boolean getMedical() {
        return medicalCard;
    }
    public boolean getDrug() {
        return drugScheme;
    }
           
}
