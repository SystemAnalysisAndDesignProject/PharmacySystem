package com.psview;

import com.psmodel.PharmacyConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainMenuPanel extends JPanel{
    
    private JLabel welcomeLbl;
    private JButton modifyBtn;
    private JButton orderProcessBtn;
    private JButton logoutBtn;
    private JButton salesReportBtn;
    private JLabel logo;
    private ImageIcon img;
    
    
    public MainMenuPanel()
    {          
        //Initializing
        modifyBtn = new JButton("Modify");
        orderProcessBtn = new JButton("Process Order");
        salesReportBtn = new JButton("Sales Reports");
        logoutBtn = new JButton("Logout");
        welcomeLbl = new JLabel("Welcome ");   
        img = new ImageIcon(PharmacyConstants.pharmacyIconFilePath);
        logo = new JLabel();
        
        //Setting Bounds
        welcomeLbl.setBounds(320,20,150,20);
        modifyBtn.setBounds(100,250,150,20);
        orderProcessBtn.setBounds(300,250,150,20);
        logoutBtn.setBounds(300,500,150,20);
        salesReportBtn.setBounds(500,250,150,20);    
        logo.setBounds(20,450,100,100);
        
        logo.setIcon(img);    
        
        //Adding to panel
        this.add(modifyBtn);
        this.add(orderProcessBtn);
        this.add(logoutBtn);
        this.add(welcomeLbl);
        this.add(salesReportBtn);
        this.add(logo);
        salesReportBtn.setVisible(false);
        this.setLayout(null);  
    }
    
    public void setButtonsPosition(){
        modifyBtn.setLocation((int)modifyBtn.getLocation().getX() + 100,(int)modifyBtn.getLocation().getY());
        orderProcessBtn.setLocation((int)orderProcessBtn.getLocation().getX() + 100,(int)orderProcessBtn.getLocation().getY());
    }
    
    public void salesReportBtnVisibility(boolean vis){
        salesReportBtn.setVisible(vis);
    }
    
    public void setWelcomeLbl(String info)
    {
        welcomeLbl.setText(info);
    }
    
    public void addModifyListener(ActionListener listenerForModifyBtn){
        modifyBtn.addActionListener(listenerForModifyBtn);
    }
    
    public void addOrderProcessListener(ActionListener listenerForOrderProcessBtn){
        orderProcessBtn.addActionListener(listenerForOrderProcessBtn);
    }
    
    public void addLogoutListener(ActionListener listenerForLogoutBtn){
        logoutBtn.addActionListener(listenerForLogoutBtn);
    }
    
    public void addSalesReportsListener(ActionListener listenerForSalesReportBtn){
        salesReportBtn.addActionListener(listenerForSalesReportBtn);
    }
   
}
