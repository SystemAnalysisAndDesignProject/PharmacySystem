package com.psmodel.sales;

public class SalesChart implements IObserver
{
    int latestMedicalCardSales = 0;
    int latestDrugSchemeSales = 0;
    int latestRegularSales = 0;

    ISubject salesDetails; // Subject reference variable

    // Note how subject is passed in the constructor of Observer
    public SalesChart(ISubject subject)
    {
     salesDetails = subject;
     salesDetails.register(this); // Registering itself to the Subject
    }

    public void update(int value, int value2, int value3)
    {
     latestMedicalCardSales = value;
     latestDrugSchemeSales = value2;
     latestRegularSales = value3;
    }

    public void unsubscribe()
    {
      salesDetails.unregister(this);
    }
}
