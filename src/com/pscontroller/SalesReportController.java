package com.pscontroller;

import com.psmodel.SalesReportModel;
import com.psview.PharmacyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SalesReportController {
    private PharmacyView salesReportView;
    private SalesReportModel salesReportModel;
    
    public SalesReportController(PharmacyView salesReportView, SalesReportModel salesReportModel) throws IOException
    {
        this.salesReportView = salesReportView;
        this.salesReportModel = salesReportModel;
        
        this.salesReportModel.initializeSubjectsAndObservers();
        this.salesReportView.displaySalesReport();
        this.salesReportView.initializeLabels(salesReportModel.getMedicalCardSales(),salesReportModel.getDrugSchemeSales(),salesReportModel.getRegularSales());
  
        //this.salesReportView.initializeCharts();
        this.salesReportView.addBackToMainMenuFromSalesReportsListener(new BackToMainMenuListener());
        
        
    }
    
    class BackToMainMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("back to main menu clicked");
                salesReportView.displayMainMenuManagerFromSalesReports();  
        }             
    }
    
}

