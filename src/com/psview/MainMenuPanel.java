package com.psview;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainMenuPanel extends JPanel{
    
    private JLabel welcomeLbl;
    private JButton modifyBtn;
    private JButton orderProcessBtn;
    private JButton logoutBtn;
    
    
    public MainMenuPanel()
    {          
        //Initializing
        modifyBtn = new JButton("Modify");
        orderProcessBtn = new JButton("Process Order");
        logoutBtn = new JButton("Logout");
        welcomeLbl = new JLabel("Welcome ");
        
        
        //Setting Bounds
        welcomeLbl.setBounds(350,20,150,20);
        modifyBtn.setBounds(100,250,150,20);
        orderProcessBtn.setBounds(300,250,150,20);
        logoutBtn.setBounds(500,250,150,20);
       
        
        
        
        this.setLayout(null);  
        
        //Adding to panel
        this.add(modifyBtn);
        this.add(orderProcessBtn);
        this.add(logoutBtn);
        this.add(welcomeLbl);
      
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
   
}
