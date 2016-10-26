package com.psmodel;

import com.psmodel.user.User;
import com.psdb.DataBaseManagment;
import java.util.ArrayList;

public class LoginModel {
    
    private DataBaseManagment dbm;
    private User user;
    
    public LoginModel()
    {
            dbm = new DataBaseManagment();
    }
    
    public boolean Validate(String username, String password){
        System.out.println("Validating");        
        ArrayList<User> userList = dbm.getUsers();
        
        for(User user : userList)
        {
            if(user.getUsername().equals(username)){
                if(user.getPassword().equals(password)){                    
                    this.user = user;
                    return true;
                }
            }
        }
        return false;
    }
    
    public DataBaseManagment getDataBase(){
        return dbm;
    }
    
    public User getUser(){
        return user;
    }
}
