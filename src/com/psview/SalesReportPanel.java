package com.psview;

import com.psmodel.PharmacyConstants;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SalesReportPanel extends JPanel{
    private JLabel pieLabel;
    private JLabel barLabel;
    private ImageIcon pieImage;
    private ImageIcon barImage;
    private JButton backToMainMenuBtn;
    private ImageIcon img;
    private JLabel logo;
    private JLabel prescriptionLbl;
    private JLabel drugSchemeLbl;
    private JLabel regularSalesLbl;
    
    public SalesReportPanel()
    {
        this.setLayout(null);        
        //Initializing
       // initializeImages();
        pieImage = new ImageIcon(PharmacyConstants.pieChartFilePath);
        pieImage.getImage().flush();
        pieLabel = new JLabel(pieImage);
        barImage = new ImageIcon(PharmacyConstants.barChartFilePath);
         barImage.getImage().flush();
        barLabel = new JLabel(barImage);   
        backToMainMenuBtn = new JButton("Back to Main Menu");
        img = new ImageIcon(PharmacyConstants.pharmacyIconFilePath);
        logo = new JLabel();
        logo.setIcon(img);
        prescriptionLbl = new JLabel();
        drugSchemeLbl = new JLabel();
        regularSalesLbl = new JLabel();
        
       //new create
        
        
      
        //Setting Position      
        pieLabel.setBounds(35, 50, 352, 264);
        barLabel.setBounds(410, 50, 352, 264);
        backToMainMenuBtn.setBounds(600,500,150,20);
        logo.setBounds(20,450,100,100);
        prescriptionLbl.setBounds(320,364,150,20);
        
        drugSchemeLbl.setBounds(320,414,150,20);
        
        regularSalesLbl.setBounds(320,464,150,20);
        
        //Adding to components to Panel
        this.add(pieLabel);
        this.add(barLabel);
        this.add(backToMainMenuBtn);
        this.add(logo);
        this.add(prescriptionLbl);        
        this.add(drugSchemeLbl);
        this.add(regularSalesLbl);
    }

    public void initializeLabels(int p,int d,int r){
        prescriptionLbl.setText("Medical Card: " + p);
        drugSchemeLbl.setText("Drug Scheme: " + d);
        regularSalesLbl.setText("Regular Sales: " + r);
        
    }
    
    public void addBackToMainMenuListener(ActionListener listenerForBackToMainMenuBtn){
        backToMainMenuBtn.addActionListener(listenerForBackToMainMenuBtn);
    }
}
