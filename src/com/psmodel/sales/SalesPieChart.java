package com.psmodel.sales;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class SalesPieChart implements IObserver
{
    int latestMedicalCardSales = 0;
    int latestDrugSchemeSales = 0;
    int latestRegularSales = 0;

    ISubject salesDetails; // Subject reference variable

    // Note how subject is passed in the constructor of Observer
    public SalesPieChart(ISubject subject)
    {
     salesDetails = subject;
     salesDetails.register(this); // Registering itself to the Subject
    }

    public void update(int value, int value2, int value3)
    {
     latestMedicalCardSales = value;
     latestDrugSchemeSales = value2;
     latestRegularSales = value3;
        try {
            createPieChartImage(latestMedicalCardSales, latestDrugSchemeSales, latestRegularSales);
        } catch (IOException ex) {
            Logger.getLogger(SalesPieChart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createPieChartImage(int x, int y, int z) throws IOException
    {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue("involving Drug Scheme", new Double( x ) );
      dataset.setValue("Regular", new Double( y ) );
      dataset.setValue("involving Perscription", new Double( z ) );

      JFreeChart chart = ChartFactory.createPieChart(
         "Sales Report", // chart title
         dataset, // data
         true, // include legend
         true,
         false);
         
      int width = 320; //image width
      int height = 240; //image height
      File pieChart = new File( "PieChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
    }
    
    
    public String getPieChartImage()
    {
        String x = "PieChart.jpeg";
        return x;
    }

    public void unsubscribe()
    {
      salesDetails.unregister(this);
    }
}
