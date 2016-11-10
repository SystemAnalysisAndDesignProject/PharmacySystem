/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psmodel.perscription;

import com.psmodel.product.Drug;
import java.util.ArrayList;
import java.util.Arrays;

public class Prescription implements IPrescription{
    private String _customerName;
    private String _gpName;
    private String  _items;
    private int _prescriptionID;
    
    public Prescription(String name,String gpName, String  items, int prescriptionID){
        _customerName = name;
        _gpName = gpName;
        _prescriptionID = prescriptionID;
        _items = items;
        
    }
    
    public String getCustomerName() {
        return _customerName;
    }
    
    public String getGPName() {
        return _gpName;
    }
    
    public int getPrescriptionID() {
        return _prescriptionID;
    }
    
    public String getItems() {
        return _items;
    }

    public String getDescription() {
        return "Customer Name " + _customerName + " GP Name " + _gpName + "items " + _items + " Prescription ID " + _prescriptionID;
    }
    
}
