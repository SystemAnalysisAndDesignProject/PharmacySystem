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
abstract class CartDecorator implements Cart{
    private Cart c;
    
    CartDecorator(Cart c){ 
        this.c = c;
    }
    
    public double getCost() {
        return c.getCost();
    }
}
