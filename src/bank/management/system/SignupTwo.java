package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class SignupTwo extends JFrame implements ActionListener{
    long random;
    JTextField pancardTextField,aadhercardTextField;
    JButton next;
    JRadioButton yseSenior,noSecinor,yesExisting,noExisting;
    JComboBox Religion,Category,Income,eductionQulification,Occuption;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetail = new JLabel("Page 2: Additional Detail");
        additionalDetail.setFont(new Font("Raleway", Font.BOLD,22));
        additionalDetail.setBounds(290,30,400,30);
        add(additionalDetail);
        
        JLabel lFormno = new JLabel("Form No: "+formno);
        lFormno.setFont(new Font("Raleway", Font.BOLD,20));
        lFormno.setBounds(100,80,400,30);
        add(lFormno);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.PLAIN,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String valReligion[] = {"Select","Hindu","Muslim","Sikh","Christian","Outher"};
        Religion= new JComboBox(valReligion);
        Religion.setFont(new Font("Raleway",Font.PLAIN,20));
        Religion.setBounds(300,140,400,30);
        Religion.setBackground(Color.WHITE);
        add(Religion);
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.PLAIN,20));
        category.setBounds(100,190,200,30);
        add(category);
        
        String valCategory[] = {"Select","General","OBC","SC","ST","Outher"};
        Category= new JComboBox(valCategory);
        Category.setFont(new Font("Raleway",Font.PLAIN,20));
        Category.setBounds(300,190,400,30);
        Category.setBackground(Color.WHITE);
        add(Category);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.PLAIN,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String valIncome[] = {"Select","Null","< 1,50,000","< 2,50,000","< 5,00,000","< 10,00,000","> 10,00,000"};
        Income= new JComboBox(valIncome);
        Income.setFont(new Font("Raleway",Font.PLAIN,20));
        Income.setBounds(300,240,400,30);
        Income.setBackground(Color.WHITE);
        add(Income);
        
        
        JLabel eduction = new JLabel("Eductional");
        eduction.setFont(new Font("Raleway", Font.PLAIN,20));
        eduction.setBounds(100,290,200,30);
        add(eduction);
        
        JLabel qulification = new JLabel("Qualification:");
        qulification.setFont(new Font("Raleway", Font.PLAIN,20));
        qulification.setBounds(100,315,200,30);
        add(qulification);
        
        String valEductionQulification[] = {"Select","Non-Graduation","Graduate","Post - Graduation","Docttrate","Others"};
        eductionQulification= new JComboBox(valEductionQulification);
        eductionQulification.setFont(new Font("Raleway",Font.PLAIN,20));
        eductionQulification.setBounds(300,315,400,30);
        eductionQulification.setBackground(Color.WHITE);
        add(eductionQulification);
        
        JLabel occuption = new JLabel("Occuption:");
        occuption.setFont(new Font("Raleway", Font.PLAIN,20));
        occuption.setBounds(100,390,200,30);
        add(occuption);
        
        String valOccuption[] = {"Select","Salaried","Self-Employed","Bussiness","Student","Others"};
        Occuption= new JComboBox(valOccuption);
        Occuption.setFont(new Font("Raleway",Font.PLAIN,20));
        Occuption.setBounds(300,390,400,30);
        Occuption.setBackground(Color.WHITE);
        add(Occuption);
        
        JLabel pancard = new JLabel("PAN Number:");
        pancard.setFont(new Font("Raleway", Font.PLAIN,20));
        pancard.setBounds(100,440,200,30);
        add(pancard);
        
        pancardTextField = new JTextField();
        pancardTextField.setFont(new Font("Raleway",Font.PLAIN,20));
        pancardTextField.setBounds(300,440,400,30);
        add(pancardTextField);
        
        JLabel aadher = new JLabel("Aadhar Number:");
        aadher.setFont(new Font("Raleway", Font.PLAIN,20));
        aadher.setBounds(100,490,200,30);
        add(aadher);
        
        aadhercardTextField = new JTextField();
        aadhercardTextField.setFont(new Font("Raleway",Font.PLAIN,20));
        aadhercardTextField.setBounds(300,490,400,30);
        add(aadhercardTextField);
        
        JLabel scinorCitizen = new JLabel("Senior Citizen:");
        scinorCitizen.setFont(new Font("Raleway", Font.PLAIN,20));
        scinorCitizen.setBounds(100,540,200,30);
        add(scinorCitizen);
        
        yseSenior = new JRadioButton("Yes");
        yseSenior.setBounds(300,540,120,30);
        yseSenior.setFont(new Font("Raleway",Font.PLAIN,20));
        add(yseSenior);
        
        noSecinor = new JRadioButton("No");
        noSecinor.setBounds(450,540,120,30);
        noSecinor.setFont(new Font("Raleway",Font.PLAIN,20));
        add(noSecinor);
        
        ButtonGroup scinorCitizenGroup = new ButtonGroup();
        scinorCitizenGroup.add(yseSenior);
        scinorCitizenGroup.add(noSecinor);
        
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.PLAIN,20));
        existingAccount.setBounds(100,590,200,30);
        add(existingAccount);
        
        yesExisting = new JRadioButton("Yes");
        yesExisting.setBounds(300,590,120,30);
        yesExisting.setFont(new Font("Raleway",Font.PLAIN,20));
        add(yesExisting);
        
        noExisting = new JRadioButton("No");
        noExisting.setBounds(450,590,120,30);
        noExisting.setFont(new Font("Raleway",Font.PLAIN,20));
        add(noExisting);
        
        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(yesExisting);
        existingAccountGroup.add(noExisting);
        
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(650,670,100,30);
        next.addActionListener(this);
        add(next);
        
        setSize(850,800);
        setLocation(350,30);
//        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String Formno = formno;
        String sReligion = (String) Religion.getSelectedItem();
        String sCategory = (String) Category.getSelectedItem();
        String sIncome = (String) Income.getSelectedItem();
        String seductionQulification = (String) eductionQulification.getSelectedItem();
        String sOccuption = (String) Occuption.getSelectedItem();
        String sPan = pancardTextField.getText();
        String sAadher = aadhercardTextField.getText();
        String sSeniorCitizen = null;
        if (yseSenior.isSelected()){
            sSeniorCitizen = "Yes";
        }else if(noSecinor.isSelected()){
            sSeniorCitizen = "No";
        }
        
        String sExistingAccount = null;
        if (yesExisting.isSelected()){
            sExistingAccount = "Yes";
        }else if (noExisting.isSelected()){
            sExistingAccount = "No";
        }
        
        
        
        try{
            
            Conn c = new Conn();
            String query = "insert into signupTwo values('"+formno+"','"+sReligion+"','"+sCategory+"','"+sIncome+"','"+seductionQulification+"','"+sOccuption+"','"+sPan+"','"+sAadher+"','"+sSeniorCitizen+"','"+sExistingAccount+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args){
        new SignupTwo("");
    }
}
