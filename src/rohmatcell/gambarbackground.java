/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rohmatcell;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author arifika
 */
public class gambarbackground extends JPanel{
 
    private Image image; // membuat variable image
     public gambarbackground() {
        image = new ImageIcon(getClass().getResource("/gambar/gambar2.jpg")).getImage();
        //memanggil sumber daya gambar
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
     
        Graphics gd = (Graphics2D) g.create();
     
        gd.drawImage(image, 0,0,getWidth(),getHeight(), this);
        // menggambar image
        gd.dispose();
    }
}  

