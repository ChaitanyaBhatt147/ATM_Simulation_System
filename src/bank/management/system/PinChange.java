package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin ,repin;
    JButton change, back;
    String pinNumber;
    
    PinChange(String pinNumber){
        
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Change your PIN");
        text.setBounds(250,290,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(165,350,180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD,14));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setBounds(330,350,180,25);
        pin.setFont(new Font("Raleway",Font.BOLD,14));
        pin.setForeground(Color.WHITE);
        pin.setBackground(Color.BLACK);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setBounds(165,390,180,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD,14));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setBounds(330,390,180,25);
        repin.setFont(new Font("Raleway",Font.BOLD,14));
        repin.setForeground(Color.WHITE);
        repin.setBackground(Color.BLACK);
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(355,450,150,30);
        change.setForeground(Color.WHITE);
        change.setBackground(Color.BLACK);
        change.setFont(new Font("Raleway", Font.BOLD,14));
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(355,490,150,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Raleway", Font.BOLD,14));
        back.addActionListener(this);
        image.add(back);        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public static void main (String[] args){
        new PinChange("");
    }

    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change){
            try{
                String Spin = pin.getText();
                String Srepin = repin.getText();
                
                if (!Spin.equals(Srepin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN dose not match.");
                    return;
                    
                } if (Spin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN.");
                    return;
                    
                }if (Srepin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN.");
                    return;
                    
                }
                
                Conn c = new Conn();
                String query1 = "update bank set pin = '"+Spin+"' where pin = '"+pinNumber+"';";
                String query2 = "update login set pinNumber = '"+Spin+"' where pinNumber = '"+pinNumber+"';";
                String query3 = "update signupthree set PIN_Number = '"+Spin+"' where PIN_Number = '"+pinNumber+"';";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully.");
                
                setVisible(false);
                new Transactions(Spin).setVisible(true);
            
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        
    }
}
