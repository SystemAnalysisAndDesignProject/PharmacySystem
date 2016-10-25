package com.psmodel;

import com.psdb.DataBaseManagment;

public class ModifyModel {
    
    private DataBaseManagment dbm;
    private User user;
    
    public ModifyModel(DataBaseManagment dbm,User user){
        this.dbm = dbm;
        this.user = user;
    }
    
    public User getUser(){
        return user;
    }
    
}
