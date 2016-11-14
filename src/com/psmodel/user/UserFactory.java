package com.psmodel.user;

public class UserFactory {
    
    public User makeUser(String role)
    {
        User user = null;
        if(role.toLowerCase().equals("m"))
        {
            return new Manager();
        }
        else if(role.toLowerCase().equals("e"))
        {
            return new Employee();
        }        
        //else if(role.toLowerCase().equals("a")){
           // return Admin.getInstance();
        //}
        else{
            return null;
        }
    }    
}
