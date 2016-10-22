package com.psview;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenuView extends JFrame{
    
    private JButton modifyBtn;
    private JButton orderProcessBtn;
    
    public MainMenuView()
    {
        JPanel mainMenuPanel = new JPanel();
        
        modifyBtn = new JButton("Modify");
        orderProcessBtn = new JButton("Process Order");
           
        this.setSize(800,600);
        mainMenuPanel.add(modifyBtn);
        mainMenuPanel.add(orderProcessBtn);
            
        this.add(mainMenuPanel);          
    }
   
}
