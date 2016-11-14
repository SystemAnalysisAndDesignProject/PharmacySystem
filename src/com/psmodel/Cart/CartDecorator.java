package com.psmodel.Cart;

public class CartDecorator extends EmptyCart{
    EmptyCart c;
    public CartDecorator(EmptyCart c){
        this.c = c;
    }
    @Override
    public double getCost(){
        return c.getCost();
    }
}
