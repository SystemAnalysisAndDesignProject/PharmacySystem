package com.psmodel.Cart;

public class WithDrugScheme extends CartDecorator{
  
    
    public WithDrugScheme(EmptyCart c){
       super(c);
    }
    
    @Override
    public double getCost(){
     if (c.getCost() > 100) {
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
