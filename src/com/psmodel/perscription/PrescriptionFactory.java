package com.psmodel.perscription;

public class PrescriptionFactory {
    
    
    public static Prescription makePrescription(String name, String gpName, String  prescription, int prescriptionID){
        return new Prescription(name,gpName,prescription, prescriptionID);
    }
    
}
