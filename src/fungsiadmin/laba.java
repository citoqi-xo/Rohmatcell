/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fungsiadmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author arifika
 */
public class laba {
    public void laba(JTextField isilaba, JLabel isitglawal1,JLabel isitglakhir1 ){
        String tanggal_awal1, tanggal_akhir1 ;
        tanggal_awal1 = isitglawal1 .getText().trim();
        tanggal_akhir1 = isitglakhir1.getText().trim();
        String b [] = new String [1];
        try {
            Connection c = rohmatcell.koneksidb.getkoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery( "select (count(*)*(u.harga_jual-u.harga_default))as laba from penjualan p, pulsa u where p.id_pulsa = u.id_pulsa and `tanggal` BETWEEN '"+tanggal_awal1+"' and '"+tanggal_akhir1+"'");
            
            while ( r.next()){
              
            b[0]=r.getString("laba");
           
            }
        } catch (SQLException e) {
                System.out.println("Error di select all laba! "+e);
        }
        isilaba.setText(b[0]);
        
    }
}
