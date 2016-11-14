package com.psmodel.Cart;

public class EmptyCart extends Cart {
    double cost;
    public EmptyCart(){
        description = "Empty Basket";
        
    }
    @Override
    public double getCost(){
        return cost;
    }
    
    public void setCost(double price){
        cost = price;
    }
    
}
