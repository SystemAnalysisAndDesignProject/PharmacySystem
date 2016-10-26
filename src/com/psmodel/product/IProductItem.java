/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psmodel.product;

/**
 *
 * @author paul7_000
 */
public interface IProductItem  extends ICheckStock{
     public int getProductID();
     public String getName();
     public int getQuantity();
     public double getPrice();
}
