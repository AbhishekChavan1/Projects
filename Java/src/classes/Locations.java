package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Abhishek Chavan
 */
public class Locations {
    private int id;
    private String city;
    private String address;
    
    public Locations(){}
    
    public Locations(int id,String city,String address){
        this.id=id;
        this.city=city;
        this.address=address;    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void addlocation(int id,String _city,String _address){
        try{                    
            String insertquery="insert into locations (id,city,address) values(?,?,?)";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(1,id);
            pst.setString(2, _city);
            pst.setString(3, _address);
            ResultSet rs=pst.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"location not added");
            }else{
                JOptionPane.showMessageDialog(null,"location added Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }
    
    
    public void editlocation(int id,String _city,String _address){
        try{            
            String insertquery="update locations set city=?, address=? where id=?";
            
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(3,id);
            pst.setString(1, _city);
            pst.setString(2, _address);
            ResultSet rs=pst.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"location not edited");
            }else{
                JOptionPane.showMessageDialog(null,"location edited Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }
    
    public void removelocation(int id){
        try{                       
            String insertquery="delete from locations where id=?";            
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(1,id);            
            ResultSet rs=pst.executeQuery();            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"location not deleted");
            }else{
                JOptionPane.showMessageDialog(null,"location deleted Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }
    
    public ResultSet getData(String query){        
        ResultSet rs=null;  
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
            PreparedStatement pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
        return rs;
    }
    
    public ArrayList<Locations> locationlist(){
        ArrayList<Locations> loclist =new ArrayList<Locations>();
        try {                        
            ResultSet rs=getData("select * from locations");
            while(rs.next()){
                Locations location=new Locations(rs.getInt(1),rs.getString(2),rs.getString(3));
                loclist.add(location);
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
        return loclist;
    }
    /*
    public ArrayList<Locations> locationbylist(String city){
        ArrayList<Locations> loclist =new ArrayList<Locations>();
        try {                        
            ResultSet rs=getData("select * from locations where city ="+city);
            while(rs.next()){
                Locations location=new Locations(rs.getInt(1),rs.getString(2),rs.getString(3));
                loclist.add(location);
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
        return loclist;
    }
    */
}
