/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAHBUBAH
 */
import java.sql.*;
import javax.swing.*;
public class connect {
    
    Connection conn = null;
    public static Connection ConnectDb(){
    
        try{
//            Class.forName("con.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
            JOptionPane.showMessageDialog(null, "Connection Established");
        return conn;
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
            return null;
           }
    } 
    
   
}
