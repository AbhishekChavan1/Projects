/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.sql.*;
import javax.swing.*;

/**
 * @Date   14-March-2024
 * @author Abhishek Chavan
 */
public class Car {
    private int id;
    private int brand;
    private int passengers;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    private String model;
    private String fuel;
    private String color;
    private String _clas;
    private String gearbox;
    private String ari_cond;
    private String airbag;
    private String sunroof;
    private String heatedseat;
    private String navigation;
    private String bluetooth;
    private String gps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getClas() {
        return _clas;
    }

    public void setClass(String _clas) {
        this._clas = _clas;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getAri_cond() {
        return ari_cond;
    }

    public void setAri_cond(String ari_cond) {
        this.ari_cond = ari_cond;
    }

    public String getAirbag() {
        return airbag;
    }

    public void setAirbag(String airbag) {
        this.airbag = airbag;
    }

    public String getSunroof() {
        return sunroof;
    }

    public void setSunroof(String sunroof) {
        this.sunroof = sunroof;
    }

    public String getHeatedseat() {
        return heatedseat;
    }

    public void setHeatedseat(String heatedseat) {
        this.heatedseat = heatedseat;
    }

    public String getNavigation() {
        return navigation;
    }

    public void setNavigation(String navigation) {
        this.navigation = navigation;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public Car() {}

    public Car(int id, int brand, int passengers, int price,String model, String fuel, String color, String _clas, String gearbox, String ari_cond, String airbag, String sunroof, String heatedseat, String navigation, String bluetooth, String gps) {
        this.id = id;
        this.brand = brand;
        this.passengers = passengers;
        this.model = model;
        this.fuel = fuel;
        this.color = color;
        this._clas = _clas;
        this.price=price;
        this.gearbox = gearbox;
        this.ari_cond = ari_cond;
        this.airbag = airbag;
        this.sunroof = sunroof;
        this.heatedseat = heatedseat;
        this.navigation = navigation;
        this.bluetooth = bluetooth;
        this.gps = gps;
    }
      
    
    public void addCar(int id,int _brand,int _passengers,int _price,String _model,String _fuel,String _color,String _clas,String _gearbox,String _ari_cond,String _airbag,String _sunroof,String _heatedseat,String _navigation,String _bluetooth,String _gps){
        try{                    
            String insertquery="insert into cars (id,model,fuel,color,class,passengers,gearbox,price,aircondition,airbag,sunroof,heatedseats,navigation,bluetooth,gps,brand) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(1,id);
            pst.setInt(16,_brand);
            pst.setInt(6,_passengers);
            pst.setInt(8,_price);
            pst.setString(2, _model);
            pst.setString(3, _fuel);
            pst.setString(4, _color);
            pst.setString(5, _clas);
            pst.setString(7, _gearbox);            
            pst.setString(9, _ari_cond);
            pst.setString(10, _airbag);
            pst.setString(11, _sunroof);
            pst.setString(12, _heatedseat);
            pst.setString(13, _navigation);
            pst.setString(14, _bluetooth);
            pst.setString(15, _gps);
            
            ResultSet rs=pst.executeQuery();            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Car not added");
            }else{
                JOptionPane.showMessageDialog(null,"Car added Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }
    
    public void removeCar(int id){
        try{                    
            String insertquery="delete from cars where id=?";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);     
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Car not deleted");
            }else{
                JOptionPane.showMessageDialog(null,"Car deleted Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }
    
    public void editCar(int id,int _brand,int _passengers,int _price,String _model,String _fuel,String _color,String _clas,String _gearbox,String _ari_cond,String _airbag,String _sunroof,String _heatedseat,String _navigation,String _bluetooth,String _gps){
        try{                    
            String insertquery="update cars set model=?,fuel=?,color=?,class=?,passengers=?,gearbox=?,price=?,aircondition=?,airbag=?,sunroof=?,heatedseats=?,navigation=?,bluetooth=?,gps=?,brand=? where id=?";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(16,id);
            pst.setInt(15,_brand);
            pst.setInt(5,_passengers);
            pst.setInt(7,_price);
            pst.setString(1, _model);
            pst.setString(2, _fuel);
            pst.setString(3, _color);
            pst.setString(4, _clas);
            pst.setString(6, _gearbox);            
            pst.setString(8, _ari_cond);
            pst.setString(9, _airbag);
            pst.setString(10, _sunroof);
            pst.setString(11, _heatedseat);
            pst.setString(12, _navigation);
            pst.setString(13, _bluetooth);
            pst.setString(14, _gps);
            
            ResultSet rs=pst.executeQuery();            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Car not edited");
            }else{
                JOptionPane.showMessageDialog(null,"Car edited Successfull");                
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
    
    public ArrayList<Car> carlist(){
        ArrayList<Car> crlist =new ArrayList<Car>();
        try {                        
            ResultSet rs=getData("select * from cars");
            while(rs.next()){                                            
                Car car=new Car(rs.getInt(1),rs.getInt(16),rs.getInt(6),rs.getInt(8),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(7),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15));
                crlist.add(car);                
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
        return crlist;
    }
    
    public void addCarimg(int id, int car_id, File _logo){        
        try{        
            FileInputStream fin=new FileInputStream(_logo);
            String insertquery="insert into carimages (id,car_id,cimage) values(?,?,?)";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);
            pst.setInt(1,id);
            pst.setInt(2, car_id);
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
    
    public void removeCarimage(int id){
        try{                    
            String insertquery="delete from carimages where id=?";
            Class.forName("oracle.jdbc.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String name="SYSTEM";
            String password="system";
            Connection conn=DriverManager.getConnection(url,name,password);
                        
            PreparedStatement pst=conn.prepareStatement(insertquery);     
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();            
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Image not deleted");
            }else{
                JOptionPane.showMessageDialog(null,"Image deleted Successfull");                
            }                               
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }
    
    public ArrayList<Integer> carimagelist(int car_id){
        ArrayList<Integer> images =new ArrayList<Integer>();
        try {                        
            ResultSet rs=getData("select id,car_id,cimage from carimages where car_id="+car_id);
            while(rs.next()){                            
                images.add(rs.getInt(2));
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
        return images;
    }
 
    public Car getCarById(int carid){
        String query="select * from cars where id="+carid;
        ResultSet rs =getData(query);
        Car car=null;
        try{
            rs.next();            
            car=new Car(rs.getInt(1),rs.getInt(16),rs.getInt(6),rs.getInt(8),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(7),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return car;
    }
        
    public ArrayList<Car> carbrandlist(int brandid){
        ArrayList<Car> crlist =new ArrayList<Car>();
        try {                        
            ResultSet rs=getData("select * from cars where brand="+brandid);
            while(rs.next()){                                            
                Car car=new Car(rs.getInt(1),rs.getInt(16),rs.getInt(6),rs.getInt(8),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(7),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15));
                crlist.add(car);                
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
        return crlist;
    }
    
}
