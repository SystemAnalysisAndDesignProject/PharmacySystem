package com.psmodel.sales;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class SalesBarChart implements IObserver
{
    int latestMedicalCardSales = 0;
    int latestDrugSchemeSales = 0;
    int latestRegularSales = 0;

    ISubject salesDetails; // Subject reference variable

    // Note how subject is passed in the constructor of Observer
    public SalesBarChart(ISubject subject)
    {
     salesDetails = subject;
     salesDetails.register(this); // Registering itself to the Subject
    }

    public void update(int value, int value2, int value3)
    {
     latestMedicalCardSales = value;
     latestDrugSchemeSales = value2;
     latestRegularSales = value3;
     System.out.println(value + " " + value2 + " " + value3);
        try {
            createBarChartImage(latestMedicalCardSales, latestDrugSchemeSales, latestRegularSales);
        } catch (IOException ex) {
            Logger.getLogger(SalesBarChart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createBarChartImage(int x, int y, int z) throws IOException
    {

      final String perscription = "Sales involving Perscription";
      final String drugScheme = "Sales involving Drug Scheme";
      final String regular = "Regular Sales";
      final String sales = "Sales";

      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

      dataset.addValue( x , perscription , sales );
      dataset.addValue( y , drugScheme , sales );
      dataset.addValue( z , regular , sales );
      JFreeChart barChart = ChartFactory.createBarChart(
         "Sales Report", 
         "Category", "Number of Sales", 
         dataset,PlotOrientation.VERTICAL, 
         true, true, false);
         
      int width = 352; /* Width of the image */
      int height = 264; /* Height of the image */ 
      File BarChart = new File( "BarChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
    }
    
    public String getPieChartImage()
    {
        String y = "BarChart.jpeg";
        return y;
    }

    public void unsubscribe()
    {
      salesDetails.unregister(this);
    }
}
