package com.psmodel.Cart;

public class WithMedicalCard extends CartDecorator {
    
    public WithMedicalCard(EmptyCart c){
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
