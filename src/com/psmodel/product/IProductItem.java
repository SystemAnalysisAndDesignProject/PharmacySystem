package com.psmodel.product;

public interface IProductItem  extends ICheckStock{
     public int getProductID();
     public String getName();
     public int getQuantity();
     public double getPrice();
}
