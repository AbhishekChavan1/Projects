/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import classes.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Abhishek Chavan
 */
public class Brand {
    private int id;
    private String name;
    private ImageIcon logo;
    
    public Brand(){}
    
    public Brand(int _id, String _name, ImageIcon _logo) {
        this.id = _id;
        this.name = _name;       
        this.logo=_logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getLogo() {
        return logo;
    }

    public void setLogo(ImageIcon logo) {
        this.logo = logo;
    }

    
    //add,edit,remove
    public void addBrand(int id, String _name, File _logo){        
        try{        
            FileInputStream fin=new FileInputStream(_logo);
            String insertquery="insert into brands (id,name,logo) values(?,?,?)";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(1,id);
            pst.setString(2, _name);
            pst.setBlob(3, fin);
            ResultSet rs=pst.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"car not added");
            }else{
                JOptionPane.showMessageDialog(null,"Car added Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }          
    
    public void editBrand(int id, String _name, File _logo){
        try{
            FileInputStream fin=new FileInputStream(_logo);            
            String insertquery="update brands set name=?, logo=? where id=?";
            
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(3,id);
            pst.setString(1, _name);
            pst.setBlob(2,fin);
            ResultSet rs=pst.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"car not deleted");
            }else{
                JOptionPane.showMessageDialog(null,"Car edited Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }
    
    public void removeBrand(int id){
        try{                       
            String insertquery="delete from brands where id=?";
            
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(1,id);            
            ResultSet rs=pst.executeQuery();
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"car not deleted");
            }else{
                JOptionPane.showMessageDialog(null,"Car deleted Successfull");                
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
    
    public ArrayList<Brand> brandslist(){
        ArrayList<Brand> brdlist =new ArrayList<Brand>();
        try {                        
            ResultSet rs=getData("select * from brands");
            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                InputStream is = rs.getBinaryStream(3);
                ImageIcon icon = new ImageIcon(ImageIO.read(is));
                Brand brand=new Brand(rs.getInt(1),rs.getString(2),icon);
                brdlist.add(brand);                
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
        return brdlist;
    }
    
    public Brand getBrandById(int brand_id){
        String query="select * from brands where id="+brand_id;
        ResultSet rs =getData(query);
        Brand brand=null;
        try{
            rs.next();
            InputStream is = rs.getBinaryStream(3);
            ImageIcon icon = new ImageIcon(ImageIO.read(is));
            brand=new Brand(rs.getInt(1),rs.getString(2),icon);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return brand;
    }
    
    public HashMap<String, Integer>brandsHashmap(){
        HashMap<String,Integer> brands_map=new HashMap<String,Integer>();        
        ResultSet rs=getData("select * from brands");
        try{
            while(rs.next()){
                brands_map.put(rs.getString(2),rs.getInt(1));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return brands_map;
    }
}
