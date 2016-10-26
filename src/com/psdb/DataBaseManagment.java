package com.psdb;

import com.psmodel.Permission;
import com.psmodel.PharmacyConstants;
import com.psmodel.User;
import com.psmodel.UserFactory;
import com.psmodel.product.Drug;
import com.psmodel.product.DrugFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataBaseManagment {
    
    private ArrayList<User> users;
    private ArrayList<Drug> drugs;
    
    public DataBaseManagment(){
        readUsers();
        readDrugs();
    }
    
    private void readUsers(){ 
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
    
    private void readDrugs(){
        
        BufferedReader br = null;        
        try{
            String currentLine;
            drugs = new ArrayList<Drug>();
            
            br = new BufferedReader(new FileReader(PharmacyConstants.drugsFilePath));
            
            while((currentLine = br.readLine()) != null){
                
                String [] tempDrug = currentLine.split(",");
                DrugFactory drugFactory = new DrugFactory();
                
                Drug drug = drugFactory.makeDrug(Integer.parseInt(tempDrug[0]),tempDrug[1],
                                          Integer.parseInt(tempDrug[2]),Double.parseDouble(tempDrug[3]),
                                          Boolean.parseBoolean(tempDrug[4]));
                
                System.out.println(drug.getDescription());
               
                drugs.add(drug);
            }            
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    
    public ArrayList<User> getUsers(){     
        return users;
    }
    
    public ArrayList<Drug> getDrugs(){
        return drugs;
    }
}
