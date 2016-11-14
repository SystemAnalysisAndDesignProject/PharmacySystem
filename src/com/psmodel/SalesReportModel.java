package com.psmodel;

import com.psdb.DataBaseManagment;
import com.psmodel.sales.SalesBarChart;
import com.psmodel.sales.SalesChart;
import com.psmodel.sales.SalesDetails;
import com.psmodel.sales.SalesPieChart;

public class SalesReportModel {

    private final DataBaseManagment dbm;
    private int medicalCardSales;
    private int drugSchemeSales;
    private int regularSales;
    
    
    public SalesReportModel(DataBaseManagment dbm){
        this.dbm = dbm; 
        dbm.readSalesDetails();
    }
    
    public void initializeSubjectsAndObservers(){
        System.out.println("initializin observer");
        int [] salesDetailsArray = dbm.getSalesDetailsArray();
        //Initialize Subject
        SalesDetails salesDetails =  new SalesDetails();
        medicalCardSales = salesDetailsArray[0];
        drugSchemeSales = salesDetailsArray[1];
        regularSales = salesDetailsArray[2];

        // Initialize Gadgets..Note the subject being passed in Constructor
        SalesBarChart salesBarChart = new SalesBarChart(salesDetails);
        SalesPieChart salesPieChart =  new SalesPieChart(salesDetails);
        SalesChart salesChart = new SalesChart(salesDetails);

        
        salesDetails.setMedicalCardSales(medicalCardSales);
        salesDetails.setDrugSchemeSales(drugSchemeSales);
        salesDetails.setRegularSales(regularSales);

        // Updating all Registered Observers
        salesDetails.notifyObserver();
    }
    
    public int getMedicalCardSales(){
        return medicalCardSales;
    }
    public int getDrugSchemeSales(){
        return drugSchemeSales;
    }
    public int getRegularSales(){
        return regularSales;
    }
    
    
}
