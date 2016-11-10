/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psmodel;

import com.psdb.DataBaseManagment;
import com.psmodel.customer.Customer;
import com.psmodel.perscription.Prescription;
import com.psmodel.user.User;

/**
 *
 * @author Pascal
 */
public class OrderModel {
    private DataBaseManagment dbm;
    private User user;
    private Prescription prescription;
    private Customer customer;
    ////////
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
}
