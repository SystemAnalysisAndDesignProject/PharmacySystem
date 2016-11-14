package com.psmodel;

import com.psmodel.user.User;
import com.psdb.DataBaseManagment;

public class MainMenuModel {
    
    private DataBaseManagment dbm;
    private User user;
    
    public MainMenuModel(DataBaseManagment dbm, User user){
        this.dbm = dbm;
        this.user = user;
    }
    
    public User getUser(){
        return user;
    }
    
    public DataBaseManagment getDataBase(){
        return dbm;
    }
    
}
