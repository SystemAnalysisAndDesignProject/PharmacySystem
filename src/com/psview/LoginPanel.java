package com.psview;

import java.awt.event.ActionListener;
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
        
        //SET POSITION
        titleLbl.setBounds(350,10,150,100);
        usernameLbl.setBounds(250,150,100,100);
        usernameTxt.setBounds(350,190,150,20);
        passwordLbl.setBounds(250,200,100,100);      
        passwordTxt.setBounds(350,240,150,20);
        loginBtn.setBounds(370,300,100,20);
        
        //ADDING TO PANEL
        this.add(titleLbl);
        this.add(usernameLbl);
        this.add(usernameTxt);
        this.add(passwordLbl);
        this.add(passwordTxt);
        this.add(loginBtn);                
        
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
    
}
