package com.psmodel.product;

public class DrugFactory {
    
    
    
    public Drug makeDrug(int productID, String name, int quantity, double price, boolean checkRequiresPerscription){
        if(name.equals("Aspirin")){
            return new Asprine(productID,name,quantity,price,checkRequiresPerscription);
        }
        else if(name.equals("Xanax")){
            return new Xanax(productID,name,quantity,price,checkRequiresPerscription);
        }else if(name.equals("Panadol")){
            return new Panadol(productID,name,quantity,price,checkRequiresPerscription);
        }
        else if(name.equals("Morphine")){
            return new Morphine(productID,name,quantity,price,checkRequiresPerscription);
        }
        else if(name.equals("Calpol")){
            return new Calpol(productID,name,quantity,price,checkRequiresPerscription);
        }
        
        
        return null;
    }
}
