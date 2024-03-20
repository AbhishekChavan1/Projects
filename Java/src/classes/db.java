/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.sql.*;

/**
 *
 * @author Abhishek Chavan
 * @date   25-Feb-2024
 */
public class db {
    //database 
    public static void main(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=null;
            con=DriverManager.getConnection("jdbc:oracle:@localhost:1521:xe","SYSTEM","system");
            
            if(con!=null){
                System.out.println("hellos goods");
            }
        }catch(ClassNotFoundException |SQLException e){
            e.printStackTrace();
        }
    }
}
