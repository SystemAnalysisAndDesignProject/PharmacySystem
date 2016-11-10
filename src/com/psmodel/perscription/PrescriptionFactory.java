/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psmodel.perscription;

import com.psmodel.product.Drug;
import java.util.ArrayList;

/**
 *
 * @author Pascal
 */
public class PrescriptionFactory {
    
    
    public static Prescription makePrescription(String name, String gpName, String  prescription, int prescriptionID){
        return new Prescription(name,gpName,prescription, prescriptionID);
    }
    
}
