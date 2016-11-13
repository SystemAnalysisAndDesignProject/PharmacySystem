/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psmodel.Cart;

/*
 *
 * @author Pascal
 **/
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
