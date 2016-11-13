package com.psview;

import com.psmodel.Clock;
import com.psmodel.PharmacyConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{
    
    private JLabel titleLbl;
    private JLabel usernameLbl;
    private JLabel passwordLbl;
    private JTextField usernameTxt;
    private JTextField passwordTxt;
    private JButton loginBtn;
    public JLabel clockLabel;
    public Color color;
    public ImageIcon img;
    public JLabel logo;
    //private final int WIDTH = 800;
    //private final int HEIGHT = 600; 
    
    public LoginPanel()
    {        
        //INITIALIZING COMPONENTS
        titleLbl = new JLabel("Pharmacy System");
        usernameLbl = new JLabel("Username");
        passwordLbl = new JLabel("Password");
        usernameTxt = new JTextField(20);
        passwordTxt = new JTextField(20);
        loginBtn = new JButton("Login");
        clockLabel = new JLabel();
        img = new ImageIcon(PharmacyConstants.pharmacyIconFilePath);
        logo = new JLabel();
        color = new Color(100,149,237);
        
        logo.setIcon(img);
        clock(clockLabel);
        
        //SET POSITION
        titleLbl.setBounds(350,10,150,100);
        usernameLbl.setBounds(250,150,100,100);
        usernameTxt.setBounds(350,190,150,20);
        passwordLbl.setBounds(250,200,100,100);      
        passwordTxt.setBounds(350,240,150,20);
        loginBtn.setBounds(370,300,100,20);
        clockLabel.setBounds(390,500,120,30);
        logo.setBounds(20,450,100,100);
        
        //ADDING TO PANEL
        this.add(titleLbl);
        this.add(usernameLbl);
        this.add(usernameTxt);
        this.add(passwordLbl);
        this.add(passwordTxt);
        this.add(loginBtn);        
        this.add(clockLabel);
        this.add(logo);        
         this.setBackground(color);
        this.setLayout(null);  
        
    } 
    
    public String getUsernameTxt(){
        return usernameTxt.getText();
    }
    
    public String getPassword(){
        return passwordTxt.getText();
    }
    
    public void addLoginListener(ActionListener listenerForLoginBtn){
        loginBtn.addActionListener(listenerForLoginBtn);
    }
    
    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }
    
    
    
    public void clearPanel()
    {
        usernameTxt.setText("");        
        passwordTxt.setText("");
    
    }
    
    public JLabel getClockLabel()
    {
        return clockLabel;
    }
    
    public void clock(JLabel jb)
    {
        Clock c1 = new Clock(jb);
        Thread t1 = new Thread(c1);
        t1.start();
    }
}
