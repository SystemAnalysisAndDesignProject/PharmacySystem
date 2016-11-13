/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psmodel.product;

/**
 *
 * @author Pascal
 */



public class Morphine extends Drug{
    
    public Morphine(int productID, String name, int quantity, double price, boolean checkRequiresPerscription) {
        super(productID, name, quantity, price, checkRequiresPerscription);
    }
    
}
