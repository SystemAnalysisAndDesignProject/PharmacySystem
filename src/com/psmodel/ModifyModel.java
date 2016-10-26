package com.psmodel;

import com.psmodel.user.User;
import com.psdb.DataBaseManagment;
import com.psmodel.product.Drug;
import java.util.ArrayList;

public class ModifyModel {
    
    private DataBaseManagment dbm;
    private User user;
    private ArrayList<Drug> drugs;
    
    public ModifyModel(DataBaseManagment dbm,User user){
        this.dbm = dbm;
        this.user = user;
        
        drugs = dbm.getDrugs();
    }
    
    public User getUser(){
        return user;
    }
    
    public ArrayList<Drug> getDrugs(){
        return drugs;
    }
    
}
