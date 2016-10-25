package com.psdb;

import com.psmodel.Permission;
import com.psmodel.PharmacyConstants;
import com.psmodel.User;
import com.psmodel.UserFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataBaseManagment {
    
    private ArrayList<User> users;
    
    public void readUsers(){ 
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
    
    public ArrayList<User> getUsers(){     
        return users;
    }
}
