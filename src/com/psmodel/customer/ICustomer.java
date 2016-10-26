package com.psmodel.customer;

import com.psmodel.perscription.Prescription;

public interface ICustomer {
    public String getCustomerName();
    public String getDateOfBirth();
    public String getAddress();
    public int getContactNumber();
    public boolean getMedical();
    public boolean getDrug();
}
