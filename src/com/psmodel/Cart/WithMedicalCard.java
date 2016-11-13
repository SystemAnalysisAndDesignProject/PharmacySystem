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
public class WithMedicalCard extends CartDecorator {
   // private Cart c; 
    
    public WithMedicalCard(EmptyCart c){
       // this.c = c;
       super(c);
    }
    @Override
    public double getCost(){
        return c.getCost() * 0;
    }
    
    @Override
    public String getDescription(){
        return c.getDescription() + "With Medical Card";
    }
}
