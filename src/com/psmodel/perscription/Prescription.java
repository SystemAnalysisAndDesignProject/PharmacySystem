/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psmodel.perscription;

import com.psmodel.product.Drug;
import java.util.ArrayList;

public class Prescription implements IPrescription{
    private String _customerName;
    private String _gpName;
    private ArrayList<Drug> _items;
    private int _prescriptionID;
    
    public Prescription(String name,String gpName, ArrayList<Drug> items, int prescriptionID){
        _customerName = name;
        _gpName = gpName;
        _prescriptionID = prescriptionID;
        _items.equals(items);
        
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
    
    public ArrayList<Drug> getItems() {
        return _items;
    }
    
}
