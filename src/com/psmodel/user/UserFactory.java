package com.psmodel.user;

public class UserFactory {
    
    public User makeUser(String role)
    {
        User user = null;
        System.out.println(role.toLowerCase());
        if(role.toLowerCase().equals("m"))
        {
            System.out.println("returned Manager");
            return new Manager();
        }
        else if(role.toLowerCase().equals("e"))
        {
            System.out.println("returned Employee");
            return new Employee();
        }else{
            return null;
        }
    }
    
}
