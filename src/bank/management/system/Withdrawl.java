package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java .util.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JButton withdraw,back;
    JTextField amount;
    String pinNumber;
    
    Withdrawl(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount youn want to deposit.");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(190,300,700,35);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBackground(Color.BLACK);
        amount.setForeground(Color.WHITE);
        amount.setHorizontalAlignment(JTextField.CENTER);
        amount.setBounds(235,350,200,40);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] arg){
        new Withdrawl("");
    }    

    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == withdraw){
            
            String Samount = amount.getText();
            Date date = new Date();
            if (Samount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the ammount you want to withdraw.");
            }else{
                try{
                    Conn c = new Conn();
                    String query = "insert into bank values ('"+pinNumber+"','"+date+"','Withdraw','"+Samount+"');";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+Samount+" withdrawl successfully.");
                    setVisible(false);
                    new Transactions (pinNumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
        }else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        
    }
}
