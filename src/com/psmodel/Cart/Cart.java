package com.psmodel.Cart;

public abstract class Cart {
    public String description;
    public abstract double getCost();
    public String getDescription(){
        return "Empty Cart";
    }
    
    public double Cost(){
        return getCost();
    }
}
