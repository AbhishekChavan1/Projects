/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @Date   19-March-2024
 * @author Abhishek Chavan
 */

public class User {
    private String names;
    private String phone;
    private String email;
    private String password;
    private String address;
    private String user;
    private int id;

    public String getName() {
        return names;
    }

    public void setName(String names) {
        this.names = names;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public User(){}
    public User(String uname, String phone, String email, String password, String address, String user, int id) {
        this.names = uname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.user = user;
        this.id = id;
    }
    
    public void addUser(int id,String _uname,String _phone,String _email,String _address,String usertype,String pass){
        try{                    
            String insertquery="insert into users (id,name,password,email,address,phone,usertype) values(?,?,?,?,?,?,?)";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String mypassword="system";
            Connection conn=DriverManager.getConnection(url,name,mypassword);
            
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(1,id);
            pst.setString(2, _uname);
            pst.setString(3, pass);
            pst.setString(4, _email);
            pst.setString(5, _address);                                            
            pst.setString(6, _phone);   
            pst.setString(7, usertype);   
            ResultSet rs=pst.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"User not added");
            }else{
                JOptionPane.showMessageDialog(null,"user added Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }
    
    public void editUser(int id,String _uname,String _phone,String _email,String _address,String usertype,String pass){
        try{                    
            String insertquery="update users set name=?,password=?,email=?,address=?,phone=?,usertype=? where id=?";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String mname="SYSTEM";
            String mypassword="system";
            Connection conn=DriverManager.getConnection(url,mname,mypassword);
            
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(7,id);
            pst.setString(1, _uname);
            pst.setString(2, pass);
            pst.setString(3, _email);
            pst.setString(4, _address);                                            
            pst.setString(5, _phone);   
            pst.setString(6, usertype);   
            ResultSet rs=pst.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"User not edited");
            }else{
                JOptionPane.showMessageDialog(null,"User edited Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }
    
    public void removeUser(int id){
        try{                       
            String insertquery="delete from users where id=?";            
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String mname="SYSTEM";
            String mpassword="system";
            Connection conn=DriverManager.getConnection(url,mname,mpassword);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(1,id);            
            ResultSet rs=pst.executeQuery();            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"User not deleted");
            }else{
                JOptionPane.showMessageDialog(null,"User deleted Successfull");                
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
    
    public ArrayList<User> userlist(){
        ArrayList<User> userlist =new ArrayList<User>();
        try {                        
            ResultSet rs=getData("select * from users");
            while(rs.next()){
                User use=new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(1));
                userlist.add(use);
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
        return userlist;
    }
    
}
