package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton savings,current,fixedDepodit,recurring;
    JCheckBox atmCard,internetBanking,mobileBanking,alert,chequeBook,eStatement,delecration;
    JButton submit, cancel;
    String formno;
    Conn c = new Conn();
    
   SignupThree(String formno){
       
       this.formno = formno;
       
       setLayout(null);
       
       JLabel l1 = new JLabel("Page 3: Account Details");
       l1.setFont(new Font("Raleway",Font.BOLD,22));
       l1.setBounds(290,40,400,40);
       add(l1);
       
       JLabel accountType = new JLabel("Account Type:");
       accountType.setFont(new Font("Raleway",Font.BOLD,20));
       accountType.setBounds(100,140,200,30);
       add(accountType);
       
       savings = new JRadioButton("Savings Account");
       savings.setBounds(100,180,200,30);
       savings.setFont(new Font("Raleway",Font.PLAIN,20));
       add(savings);
       
       current = new JRadioButton("Current Account");
       current.setBounds(100,220,200,30);
       current.setFont(new Font("Raleway",Font.PLAIN,20));
       add(current);
       
       fixedDepodit = new JRadioButton("Fixed Depodit Account");
       fixedDepodit.setBounds(350,180,300,30);
       fixedDepodit.setFont(new Font("Raleway",Font.PLAIN,20));
       add(fixedDepodit);
       
       recurring = new JRadioButton("Recurring Deposit Account");
       recurring.setBounds(350,220,300,30);
       recurring.setFont(new Font("Raleway",Font.PLAIN,20));
       add(recurring);
       
       ButtonGroup groupAccountType = new ButtonGroup(); 
       groupAccountType.add(savings);
       groupAccountType.add(current);
       groupAccountType.add(fixedDepodit);
       groupAccountType.add(recurring);
       
       JLabel cardno = new JLabel("Card Number:");
       cardno.setFont(new Font("Raleway",Font.BOLD,20));
       cardno.setBounds(100,280,200,30);
       add(cardno);
       
       JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
       cardDetail.setFont(new Font("Raleway",Font.PLAIN,12));
       cardDetail.setBounds(100,310,200,20);
       add(cardDetail);
       
       JLabel number = new JLabel("XXXX-XXXX-XXXX-1407");
       number.setFont(new Font("Raleway",Font.PLAIN,20));
       number.setBounds(330,280,300,30);
       add(number);
       
       JLabel pin = new JLabel("PIN :");
       pin.setFont(new Font("Raleway",Font.BOLD,20));
       pin.setBounds(100,350,200,30);
       add(pin);
       
       JLabel pinDetail = new JLabel("Your 4 Digit Password");
       pinDetail.setFont(new Font("Raleway",Font.PLAIN,12));
       pinDetail.setBounds(100,380,200,20);
       add(pinDetail);
       
       JLabel pinno = new JLabel("XXXX");
       pinno.setFont(new Font("Raleway",Font.PLAIN,20));
       pinno.setBounds(330,350,300,30);
       add(pinno);
       
       JLabel servicesRequired = new JLabel("Services Required:");
       servicesRequired.setFont(new Font("Raleway",Font.BOLD,20));
       servicesRequired.setBounds(100,430,200,30);
       add(servicesRequired);
       
       atmCard = new JCheckBox("ATM Card");
       atmCard.setBounds(100,480,200,30);
       atmCard.setFont(new Font("Raleway",Font.PLAIN,20));
       add(atmCard);
       
       internetBanking = new JCheckBox("Internet Banking");
       internetBanking.setBounds(350,480,200,30);
       internetBanking.setFont(new Font("Raleway",Font.PLAIN,20));
       add(internetBanking);
       
       mobileBanking = new JCheckBox("Mobile Banking");
       mobileBanking.setBounds(100,530,200,30);
       mobileBanking.setFont(new Font("Raleway",Font.PLAIN,20));
       add(mobileBanking);
       
       alert = new JCheckBox("Email & SMS Alert");
       alert.setBounds(350,530,200,30);
       alert.setFont(new Font("Raleway",Font.PLAIN,20));
       add(alert);
       
       eStatement = new JCheckBox("e-Statement");
       eStatement.setBounds(100,580,200,30);
       eStatement.setFont(new Font("Raleway",Font.PLAIN,20));
       add(eStatement);
       
       chequeBook = new JCheckBox("Cheqe Book");
       chequeBook.setBounds(350,580,200,30);
       chequeBook.setFont(new Font("Raleway",Font.PLAIN,20));
       add(chequeBook);
       
       delecration = new JCheckBox("I hereby declear that the above entered details are correct to the best of my knowledge.");
       delecration.setBounds(100,650,650,20);
       delecration.setFont(new Font("Raleway",Font.PLAIN,12));
       add(delecration);
       
       submit = new JButton("Submit");
       submit.setBackground(Color.black);
       submit.setForeground(Color.WHITE);
       submit.setFont(new Font("Raleway",Font.PLAIN,20));
       submit.setBounds(250,700,100,30);
       submit.addActionListener(this);
       add(submit);
       
       cancel = new JButton("Cancel");
       cancel.setBackground(Color.black);
       cancel.setForeground(Color.WHITE);
       cancel.setFont(new Font("Raleway",Font.PLAIN,20));
       cancel.setBounds(420,700,100,30);
       cancel.addActionListener(this);
       add(cancel);
       
       setSize(850,800);
       setLocation(350,30);
       setVisible(true);
   }

    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == submit){
            String AccountType = null;
            if (savings.isSelected()){
                AccountType = "Savings Account";
            }else if (fixedDepodit.isSelected()){
                AccountType = "Fixed Depodit Account";
            }else if (current.isSelected()){
                AccountType = "Current Account";
            }else if(recurring.isSelected()){
                AccountType = "Recurring Deposit Account";
            }
            
            Random random = new Random();
            String cardNumber =""+ Math.abs((random.nextLong()% 90000000L + 5040936000000000L));
            
            String pinnumber = ""+Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String sAtmCard = null;
            if (atmCard.isSelected()){
                sAtmCard = "yes";
            }else if (!atmCard.isSelected()){
                sAtmCard = "No";
            }
            String sInternetBanking = null;
            if(internetBanking.isSelected()){
                sInternetBanking = "Yes";
            }else if (!internetBanking.isSelected()){
                sInternetBanking = "No";
            }
            String sMobileBanking = null;
            if (mobileBanking.isSelected()){
                sMobileBanking = "Yes";
            }else if (!mobileBanking.isSelected()){
                sMobileBanking = "No";
            }
            String sAlert = null;
            if (alert.isSelected()){
                sAlert = "Yes";
            }else if (!alert.isSelected()){
                sAlert = "No";
            }
            String sChequeBook = null;
            if (chequeBook.isSelected()){
                sChequeBook = "Yes";
            }else if (!chequeBook.isSelected()){
                sChequeBook = "No";
            }
            String sEStement = null;
            if (eStatement.isSelected()){
                sEStement = "Yes";
            }else if (!eStatement.isSelected()){
                sEStement = "No";
            }
            
            try{
                
                if (AccountType==null){
                    JOptionPane.showMessageDialog(null, "Account type is required!!");
                }else if (!delecration.isSelected()){
                    JOptionPane.showMessageDialog(null, "Checking the delecration is required!!");
                }else{
                    
                    String query1 = "insert into SignupThree values('"+formno+"','"+AccountType+"','"+cardNumber+"','"+pinnumber+"','"+sAtmCard+"','"+sInternetBanking+"','"+sMobileBanking+"','"+sAlert+"','"+sChequeBook+"','"+sEStement+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber+"\nPin: "+pinnumber);
                    
                }
                                
            }catch (Exception e){
                System.out.println(e);
            }
            
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            
        }else if(ae.getSource() == cancel){
            try{
                String query3 = "DELETE FROM signup WHERE formno = '"+formno+"';";
                String query4 = "DELETE FROM signupTwo WHERE formno = '"+formno+"';";
                c.s.executeUpdate(query3);
                c.s.executeUpdate(query4);
            }catch(Exception e){
                System.out.println(e);
            }
            
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new SignupThree("");
    }
}
