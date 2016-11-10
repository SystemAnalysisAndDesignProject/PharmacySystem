package com.pscontroller;

import com.psmodel.SalesReportModel;
import com.psmodel.sales.SalesBarChart;
import com.psmodel.sales.SalesPieChart;
import com.psview.PharmacyView;
import java.io.IOException;

public class SalesReportController {
    private PharmacyView salesReportView;
    private SalesReportModel salesReportModel;
    
    public SalesReportController(PharmacyView salesReportView, SalesReportModel salesReportModel) throws IOException
    {
        this.salesReportView = salesReportView;
        this.salesReportModel = salesReportModel;
        
        salesReportView.displaySalesReport();
        salesReportModel.initializeSubjectsAndObservers();
        
    }
}
