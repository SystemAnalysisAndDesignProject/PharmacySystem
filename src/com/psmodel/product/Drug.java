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
public class Drug implements IProductItem,IGetInfo{
    
    private int _productID;
    private String _name;
    private int _quantity;
    private double _price;
    private boolean _lowQuantity;
    private boolean _checkRequiresPerscription;
    
    public Drug(int productID, String name, int quantity, double price, boolean checkRequiresPerscription){
        _productID = productID;
        _name = name;
        _quantity = quantity;
        _price = price;
        _lowQuantity = false;
        _checkRequiresPerscription = checkRequiresPerscription;
    }
    
    @Override
    public int getProductID() {
       return _productID;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public int getQuantity() {
       return _quantity;
    }

    @Override
    public double getPrice() {
       return _price;
    }

    @Override
    public boolean checkForLowQuantity() {
        if(_quantity < 10){
            return true;
        }        
        return false;
    }

    @Override
    public String getDescription() {
        return _productID + "\n " + _name + "\n " + _quantity + "\n " + _price;
    }
    
}
