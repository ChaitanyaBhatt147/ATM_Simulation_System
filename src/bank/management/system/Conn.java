package bank.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Chetan2001@");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){
        new Conn();
        System.out.println("connected");
    }
    
}
