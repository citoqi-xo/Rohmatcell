/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rohmatcell;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author arifika
 */
public class koneksidb {
    
    public static Connection koneksi;
    public static Connection getkoneksi(){
        
        if (koneksi==null){
            try {
                String url = "jdbc:mysql://localhost:3306/rohmatcell";
                String user= "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
            } 
            catch (SQLException e){
                System.out.println("ERROR TERJADI KESALHAN"+e);
            }
        }
        return koneksi;
    }
    
    
}
