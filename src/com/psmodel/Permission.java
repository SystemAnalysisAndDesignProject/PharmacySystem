package com.psmodel;

public class Permission {
    private boolean canModifyCustomer;
    private boolean canModifyManager;
    private boolean canModifyEmployee;
    private boolean canModifyProducts;
    
    public Permission(boolean mCustomer,boolean mManager,boolean mEmployee,boolean mProducts){
        this.canModifyCustomer = mCustomer;
        this.canModifyManager = mManager;
        this.canModifyEmployee = mEmployee;
        this.canModifyProducts = mProducts;
    }
    
    
    public boolean getCanModifyCustomer(){
        return canModifyCustomer;
    }
    
    public boolean getCanModifyManager(){
        return canModifyManager;
    }
    
    public boolean getCanModifyEmployee(){
        return canModifyEmployee;
    }
    
    public boolean getCanModifyProducts(){
        return canModifyProducts;
    }
    
}
