/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psmodel.Cart;

/**
 *
 * @author Pascal
 */
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
