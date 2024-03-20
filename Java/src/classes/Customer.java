/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 * @Date   19-March-2024
 * @author Abhishek Chavan
 */
public class Customer {
    private int id;
    private String cname;
    private String phone;
    private String email;
    private String address;
    private Date birthday;  
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Customer(){}
    public Customer(int id, String cname, String phone, String email, String address, Date birthday) {
        this.id = id;
        this.cname = cname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
    }
    
    public static java.sql.Date convertToSQLDate(Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }
    
    public void addCustomer(int id,String _cname,String _phone,String _email,String _address,Date _birthdate){
        try{                    
            String insertquery="insert into customer (id,name,phone,email,address,birthdate) values(?,?,?,?,?,?)";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
            
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(1,id);
            pst.setString(2, _cname);
            pst.setString(3, _phone);
            pst.setString(4, _email);
            pst.setString(5, _address);                                
            pst.setDate(6, convertToSQLDate(_birthdate));
            ResultSet rs=pst.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Customer not added");
            }else{
                JOptionPane.showMessageDialog(null,"Customer added Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }
    
    public void editCustomer(int id,String _cname,String _phone,String _email,String _address,Date _birthdate){
        try{                    
            String insertquery="update customer set name=?,phone=?,email=?,address=?,birthdate=? where id=?";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
            
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(6,id);
            pst.setString(1, _cname);
            pst.setString(2, _phone);
            pst.setString(3, _email);
            pst.setString(4, _address);                                
            pst.setDate(5, convertToSQLDate(_birthdate));
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
    
    public void removeCustomer(int id){
        try{                       
            String insertquery="delete from customer where id=?";            
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(1,id);            
            ResultSet rs=pst.executeQuery();            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"customer not deleted");
            }else{
                JOptionPane.showMessageDialog(null,"customer deleted Successfull");                
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
    
    public ArrayList<Customer> custlist(){
        ArrayList<Customer> custlist =new ArrayList<Customer>();
        try {                        
            ResultSet rs=getData("select * from customer");
            while(rs.next()){
                Customer cust=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6));
                custlist.add(cust);
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
        return custlist;
    }
    
}
