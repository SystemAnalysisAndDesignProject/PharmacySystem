package com.psmodel.sales;

import java.util.ArrayList;

public class SalesDetails implements ISubject
{
  
  public SalesDetails()
  {    
  }
  
  // A Collection to keep track of all Registered Observers
  ArrayList <IObserver>observers = new ArrayList<>();

  // Stores latest stock quote (example is purposely simplistic)
  private int medicalCardSales = 0;
  private int drugSchemeSales = 0;
  private int regularSales = 0;
  
  public void setMedicalCardSales(int v)
  {
    medicalCardSales = v;
  }
  
  public void setDrugSchemeSales(int w)
  {
    drugSchemeSales = w;
  }
  
  public void setRegularSales(int x)
  {
    regularSales = x;
  }
  
  @Override
  public void register(IObserver o)
  {
    observers.add(o);
  }

  @Override
  public void unregister(IObserver o)
  {
    int i = observers.indexOf(o);
    observers.remove(i);
  }
  
  @Override
  public void notifyObserver()
  {
    for (int i=0;i < observers.size();i++)
    {
      IObserver ob = (IObserver)observers.get(i);
      ob.update(medicalCardSales, drugSchemeSales, regularSales);
    }
  }
}
