package com.psview;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel{
    
    private JButton modifyBtn;
    private JButton orderProcessBtn;
    private JButton logoutBtn;
    
    public MainMenuPanel()
    {          
        //Initializing
        modifyBtn = new JButton("Modify");
        orderProcessBtn = new JButton("Process Order");
        logoutBtn = new JButton("Logout");
        
        //Setting Bounds
        modifyBtn.setBounds(100,250,150,20);
        orderProcessBtn.setBounds(300,250,150,20);
        logoutBtn.setBounds(500,250,150,20);
        
        
        this.setLayout(null);  
        
        //Adding to panel
        this.add(modifyBtn);
        this.add(orderProcessBtn);
        this.add(logoutBtn);
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
