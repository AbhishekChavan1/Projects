/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @Date   19-March-2024
 * @author Abhishek Chavan
 */
public class Rentcar {
    int id;
    int carid;
    int customerid;
    int cost;
    String pickupcity;
    String pickupaddr;
    String dropcity;
    String dropaddr;
    String picktime;
    String droptime;
    Date pickdate;
    Date dropdate;        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getPickupcity() {
        return pickupcity;
    }

    public void setPickupcity(String pickupcity) {
        this.pickupcity = pickupcity;
    }

    public String getPickupaddr() {
        return pickupaddr;
    }

    public void setPickupaddr(String pickupaddr) {
        this.pickupaddr = pickupaddr;
    }

    public String getDropcity() {
        return dropcity;
    }

    public void setDropcity(String dropcity) {
        this.dropcity = dropcity;
    }

    public String getDropaddr() {
        return dropaddr;
    }

    public void setDropaddr(String dropaddr) {
        this.dropaddr = dropaddr;
    }

    public String getPicktime() {
        return picktime;
    }

    public void setPicktime(String picktime) {
        this.picktime = picktime;
    }

    public String getDroptime() {
        return droptime;
    }

    public void setDroptime(String droptime) {
        this.droptime = droptime;
    }

    public Date getPickdate() {
        return pickdate;
    }

    public void setPickdate(Date pickdate) {
        this.pickdate = pickdate;
    }

    public Date getDropdate() {
        return dropdate;
    }

    public void setDropdate(Date dropdate) {
        this.dropdate = dropdate;
    }

    public Rentcar(){}
    public Rentcar(int id, int carid, int customerid, int cost, String pickupcity, String pickupaddr, String dropcity, String dropaddr, String picktime, String droptime, Date pickdate, Date dropdate) {
        this.id = id;
        this.carid = carid;
        this.customerid = customerid;
        this.cost = cost;
        this.pickupcity = pickupcity;
        this.pickupaddr = pickupaddr;
        this.dropcity = dropcity;
        this.dropaddr = dropaddr;
        this.picktime = picktime;
        this.droptime = droptime;
        this.pickdate = pickdate;
        this.dropdate = dropdate;
    }
    
    public static java.sql.Date convertToSQLDate(Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }
    
    public void addrent(int _id,int _carid,int custid,String pickup,String paddr,Date pickdate,String picktime,String drop,String destaddr,Date dropdate,String droptime,int price){
        try{                    
            String insertquery="insert into reservation (id,carid,customerid,pickupcity,pickupaddr,pickupdate,pickuptime,destcity,destaddr,destdate,desttime,cost) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
            
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(1,_id);
            pst.setInt(2, _carid);
            pst.setInt(3, custid);
            pst.setString(4, pickup);
            pst.setString(5, paddr);                                           
            pst.setDate(6, convertToSQLDate(pickdate));
            pst.setString(7, picktime); 
            pst.setString(8, drop); 
            pst.setString(9, destaddr); 
            pst.setDate(10, convertToSQLDate(dropdate));
            pst.setString(11, droptime); 
            pst.setInt(12, price); 
            ResultSet rs=pst.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Booking not added");
            }else{
                JOptionPane.showMessageDialog(null,"Booking added Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }
    
    public void editrent(int _id,int _carid,int custid,String pickup,String paddr,Date pickdate,String picktime,String drop,String destaddr,Date dropdate,String droptime,int price){
        try{                    
            String insertquery="update reservation set carid=?,customerid=?,pickupcity=?,pickupaddr=?,pickupdate=?,pickuptime=?,destcity=?,destaddr=?,destdate=?,desttime=?,cost=? where id=?";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(12,_id);
            pst.setInt(1, _carid);
            pst.setInt(2, custid);
            pst.setString(3, pickup);
            pst.setString(4, paddr);                                           
            pst.setDate(5, convertToSQLDate(pickdate));
            pst.setString(6, picktime); 
            pst.setString(7, drop); 
            pst.setString(8, destaddr); 
            pst.setDate(9, convertToSQLDate(dropdate));
            pst.setString(10, droptime); 
            pst.setInt(11, price); 
            ResultSet rs=pst.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Customer not edited");
            }else{
                JOptionPane.showMessageDialog(null,"Customer edited Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }                        
    }
    
    public void removerent(int id){
        try{                       
            String insertquery="delete from reservation where id=?";            
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(1,id);            
            ResultSet rs=pst.executeQuery();            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Rent not deleted");
            }else{
                JOptionPane.showMessageDialog(null,"Rent deleted Successfull");                
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
    
    public ArrayList<Rentcar> rentslist(){
    ArrayList<Rentcar> rentlist =new ArrayList<Rentcar>();
    try {                        
        ResultSet rs=getData("select * from reservation");
        while(rs.next()){
            Rentcar r=new Rentcar(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(12),rs.getString(4),rs.getString(5),rs.getString(8),rs.getString(9),rs.getString(7),rs.getString(11),rs.getDate(6),rs.getDate(10));
            rentlist.add(r);
        }
    }catch(Exception e){
       JOptionPane.showMessageDialog(null,e);
    }
    return rentlist;
}

    
}
