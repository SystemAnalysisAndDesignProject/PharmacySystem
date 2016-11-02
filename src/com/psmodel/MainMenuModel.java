package com.psmodel;

import com.psmodel.user.User;
import com.psdb.DataBaseManagment;
import com.psmodel.sales.SalesBarChart;
import com.psmodel.sales.SalesDetails;
import com.psmodel.sales.SalesPieChart;

public class MainMenuModel {
    
    private DataBaseManagment dbm;
    private User user;
    
    public MainMenuModel(DataBaseManagment dbm, User user){
        this.dbm = dbm;
        this.user = user;
    }
    
    public void displayModifyView(){
        
    }
    
    public User getUser(){
        return user;
    }
    
    public DataBaseManagment getDataBase(){
        return dbm;
    }
    
}
