/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication;

import javax.swing.*;
import java.sql.*;

/**
 *
 * @author HP
 */
public class javalogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
            String sql="select * from userlogin";
            PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                System.out.println("FNAME"+ "\t" +"LNAME");
                System.out.println(rs.getString(2)+"\t"+rs.getString(3));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
