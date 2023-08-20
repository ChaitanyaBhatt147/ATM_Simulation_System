package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
    MiniStatement(String pinNumber){
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel bank = new JLabel("Chaitanya Bank");
        bank.setBounds(125,20,200,30);
        bank.setFont(new Font("Raleway",Font.BOLD,16));
        add(bank);
        
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        card.setFont(new Font("Raleway",Font.BOLD,14));
        add(card);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinNumber = '"+pinNumber+"';");
            while (rs.next()){
                card.setText("Card Number "+ rs.getString("CardNumber").substring(0, 4)+"XXXXXXXXXXXX"+rs.getString("CardNumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        mini.setFont(new Font("Raleway",Font.PLAIN,14));
        add(mini);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"';");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+" /- <br><br><html>");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        JLabel Lbalance = new JLabel();
        Lbalance.setBounds(20,400,300,20);
        Lbalance.setFont(new Font("Raleway",Font.PLAIN,14));
        add(Lbalance);
        
        
        try{
            Conn c = new Conn();
            int balance = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"';");
            while (rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            Lbalance.setText("Your current Balabce is RS "+balance+" /-");
        }catch(Exception e){
            System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    
    
    public static void main (String[] args){
        new MiniStatement("");
    }
}
