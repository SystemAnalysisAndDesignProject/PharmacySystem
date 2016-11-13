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
    
    public SalesReportPanel()
    {
        this.setLayout(null);        
        //Initializing
        pieImage = new ImageIcon(PharmacyConstants.pieChartFilePath);
        pieLabel = new JLabel(pieImage);
        barImage = new ImageIcon(PharmacyConstants.barChartFilePath);
        barLabel = new JLabel(barImage);   
        backToMainMenuBtn = new JButton("Back to Main Menu");
        img = new ImageIcon(PharmacyConstants.pharmacyIconFilePath);
        logo = new JLabel();
        logo.setIcon(img);
        
      
        //Setting Position      
        pieLabel.setBounds(50, 50, 320, 240);
        barLabel.setBounds(400, 50, 320, 240);
        backToMainMenuBtn.setBounds(600,500,150,20);
        logo.setBounds(20,450,100,100);
        
        //Adding to components to Panel
        this.add(pieLabel);
        this.add(barLabel);
        this.add(backToMainMenuBtn);
        this.add(logo);
    }
    public void addBackToMainMenuListener(ActionListener listenerForBackToMainMenuBtn){
        backToMainMenuBtn.addActionListener(listenerForBackToMainMenuBtn);
    }
}
