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
