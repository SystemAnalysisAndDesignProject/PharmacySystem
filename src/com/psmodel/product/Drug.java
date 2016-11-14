package com.psmodel.product;

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
    
    public void setQuantity(int quantity){
        _quantity = quantity;
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
        return _productID + " " + _name + " " + _quantity + " " + _price;
    }
   
    public boolean checkRequiresPerscription(){
        return _checkRequiresPerscription;
    }

}
