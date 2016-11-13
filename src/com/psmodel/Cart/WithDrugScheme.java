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
  
    
    public WithDrugScheme(EmptyCart c){
       super(c);
    }
    
    @Override
    public double getCost(){
     if (c.getCost() > 100) {
            System.out.println(c.getCost() + "sdasdsadsasa");
            return ((c.getCost() / 100) * 60);
        }
        else {
            return c.getCost();
        }
    }
    
    @Override
    public String getDescription(){
        return c.getDescription() + "With Drug Scheme";
    }
}
