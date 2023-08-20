package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login;
    JButton clear;
    JButton signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setLayout(null);
        
        setTitle("Automated Teller Machine");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel Cardno = new JLabel("Card No:");
        Cardno.setFont(new Font("Raleway",Font.BOLD,20));
        Cardno.setBounds(120,150,150,30);
        add(Cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Raleway",Font.PLAIN,18));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(120,220,150,30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Raleway",Font.PLAIN,18));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,290,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,290,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,340,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        setSize(800,480);
        setLocation(375,200);
        getContentPane().setBackground(Color.WHITE);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == clear){
            
            cardTextField.setText("");
            pinTextField.setText("");
            
        }else if(ae.getSource() == login){
            
            Conn c = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where CardNumber = '"+cardNumber+"' and pinnumber ='"+pinNumber+"';";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN!!");
                }
            }catch (Exception e){
                System.out.println(e);
            }
            
        }else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        
    }
    
    public static void main(String[] args){
        new Login();
    }

}
