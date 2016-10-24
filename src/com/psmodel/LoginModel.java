package com.psmodel;

import com.psdb.DataBaseManagment;
import java.util.ArrayList;

public class LoginModel {
    
    private DataBaseManagment dbm;
    
    public LoginModel()
    {
            dbm = new DataBaseManagment();
            dbm.readUsers();
    }
    
    public boolean Validate(String username, String password){
        System.out.println("Validating");        
        ArrayList<User> userList = dbm.getUsers();
        
        for(User user : userList)
        {
            if(user.getUsername().equals(username)){
                if(user.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public DataBaseManagment getDataBase()
    {
        return dbm;
    }
}
