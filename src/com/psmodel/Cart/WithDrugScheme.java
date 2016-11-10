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
public class WithDrugScheme extends CartDecorator{
    Cart c;
    
    public WithDrugScheme(Cart c){
        super(c);
    }
    
    public double getCost(){
        if (c.getCost() > 100) {
            return ((c.getCost() * 0) +100);
        }
        else {
            return c.getCost();
        }
    }
}
