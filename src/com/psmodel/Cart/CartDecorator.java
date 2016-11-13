/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psmodel.Cart;

/*
 *
 * @author Pascal
 */
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
