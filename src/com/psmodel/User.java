package com.psmodel;

public abstract class User {
    private String username;
    private String password;
    private String role;
    private String name;
    private String lastName; 
    private Permission permission;
    
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public String getRole(){
        return role;
    }
    
    public void setPermission(Permission permission){
        this.permission = permission;
    }
    
    public Permission getPermission(){
        return permission;
    }
}
