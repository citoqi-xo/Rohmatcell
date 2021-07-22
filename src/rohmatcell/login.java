/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rohmatcell;

import admin.halamanadmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import member.halamanmember;
import owner.halamanutama;

/**
 *
 * @author arifika
 */
public class login extends javax.swing.JFrame {
    public String username="";

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        
        ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          Calendar cal = new GregorianCalendar();
        String nolJam = "";
        String nolMenit = "";
        String nolDetik = "";
        String nolTanggal = "";
        String nolBulan = "";
        String nolTahun = "";
        // Membuat Date
        Date dt = new Date();
        // Mengambil nilaj JAM, MENIT, dan DETIK Sekarang
        int nilaiJam = dt.getHours();
        int nilaiMenit = dt.getMinutes();
        int nilaiDetik = dt.getSeconds();
        int nilaiTanggal = cal.get(Calendar.DAY_OF_MONTH);
        int nilaiBulan = cal.get(Calendar.MONTH);
        
        int nilaiTahun = cal.get(Calendar.YEAR);
        // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
        if (nilaiJam <= 9) {
          // Tambahkan "0" didepannya
          nolJam = "0";
        }
        // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
        if (nilaiMenit <= 9) {
          // Tambahkan "0" didepannya
          nolMenit = "0";
        }
        // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
        if (nilaiDetik <= 9) {
          // Tambahkan "0" didepannya
          nolDetik = "0";
        }
        if (nilaiTanggal<10){
            nolTanggal="0";
        }
        if ((nilaiBulan+1)<10){
            nolBulan="0";
        }
        if (nilaiTahun<10){
            nolTahun="0";
        }
        // Membuat String JAM, MENIT, DETIK
        String jam = nolJam + Integer.toString(nilaiJam);
        String menit = nolMenit + Integer.toString(nilaiMenit);
        String detik = nolDetik + Integer.toString(nilaiDetik);
        String tanggal = nolTanggal + Integer.toString(nilaiTanggal);
        String bulan = nolBulan + Integer.toString(nilaiBulan+1);
        String tahun = nolTahun + Integer.toString(nilaiTahun);
        // Menampilkan pada Layar
        tampiljam.setText(jam+":"+menit+":"+detik);
        tampiltanggal.setText(tahun+"-"+bulan+"-"+tanggal);
      }
    };
    // Timer
    new Timer(1000, taskPerformer).start();
  }
    
    public String tampilUser(){
            username = user.getText().toString();
            String b;
            Vector d = new Vector();
            try {
            Connection c = koneksidb.getkoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("select id_petugas from petugas");
            
            while ( r.next()){
            b=r.getString("id_petugas");
            d.addElement(b);
            }
        } catch (SQLException e) {
                System.out.println("Error di select all Username! "+e);
        }
          String status="";
        int a = d.size();
        for(int i=0;i<a;i++){
            if(username.equals(d.elementAt(i))){
                status="benar";
                break;
            }
            else {
                status="salah";
            }
            }
        return status;
    }
    
    public String tampilPass(){
        String pass =password.getText().toString();
        String status="salah";
        String statusUser=tampilUser().toString();
        if(statusUser.equals("salah")){
            JOptionPane.showMessageDialog(null,"TERJADI ERROR di tombol Insert \nUsername telah tersedia atau Petugas sudah terdaftar", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        else if(statusUser.equals("benar")){
        String b;
            Vector d = new Vector();
            try {
            Connection c = koneksidb.getkoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("select pin from petugas where id_petugas = '"+user.getText().toString()+"'");
            
            while ( r.next()){
            b=r.getString("pin");
            d.addElement(b);
            }
        } catch (SQLException e) {
                System.out.println("Error di select all Username! "+e);
        }
        int a = d.size();
        for(int i=0;i<a;i++){
            if(pass.equals(d.elementAt(i))){
                status="benar";
                break;
            }
            else {
                status="salah";
            }}
        }
        return status;
    }
    
    public String tampilHak(){
        String b="";
        String statusUser=tampilUser().toString();
        String statusPass=tampilPass().toString();
        if(statusUser.equals("salah")||statusPass.equals("salah")){
            JOptionPane.showMessageDialog(null,"TERJADI ERROR di tombol Insert \nUsername telah tersedia atau Petugas sudah terdaftar", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        else if(statusUser.equals("benar")&&statusPass.equals("benar")){
        
            Vector d = new Vector();
            try {
            Connection c = koneksidb.getkoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("select j.nama_jabatan from jabatan j, petugas p where j.id_jabatan=p.id_jabatan and p.id_petugas = '"+user.getText().toString()+"' "+ "AND p.pin = '"+password.getText().toString()+"'");
            
            while ( r.next()){
            b=r.getString("nama_jabatan");
            d.addElement(b);
            }
        } catch (SQLException e) {
                System.out.println("Error di select all Username! "+e);
        }
        }
        return b;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        gambarbackground1 = new rohmatcell.gambarbackground();
        user = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        tampiltanggal = new javax.swing.JLabel();
        tampiljam = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tombollogin = new javax.swing.JButton();

        jPanel1.setLayout(null);

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(435, 340));
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("HALAMAN MASUK");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(117, 26, 220, 24);

        gambarbackground1.setFocusCycleRoot(true);
        gambarbackground1.setFocusTraversalPolicyProvider(true);

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        tampiltanggal.setForeground(new java.awt.Color(255, 255, 255));
        tampiltanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tampiltanggal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tanggal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        tampiltanggal.setVerifyInputWhenFocusTarget(false);

        tampiljam.setForeground(new java.awt.Color(255, 255, 255));
        tampiljam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tampiljam.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jam", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Username  :");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Password  :");
        jLabel2.setOpaque(true);

        tombollogin.setText("Masuk");
        tombollogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolloginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gambarbackground1Layout = new javax.swing.GroupLayout(gambarbackground1);
        gambarbackground1.setLayout(gambarbackground1Layout);
        gambarbackground1Layout.setHorizontalGroup(
            gambarbackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gambarbackground1Layout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(tombollogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
            .addGroup(gambarbackground1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(gambarbackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tampiltanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gambarbackground1Layout.createSequentialGroup()
                        .addGroup(gambarbackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(gambarbackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tampiljam, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        gambarbackground1Layout.setVerticalGroup(
            gambarbackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gambarbackground1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(gambarbackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tampiltanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tampiljam, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(gambarbackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gambarbackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(tombollogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        getContentPane().add(gambarbackground1);
        gambarbackground1.setBounds(0, 0, 590, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolloginActionPerformed
        // TODO add your handling code here:
        username=user.getText().toString();
        tampilUser();
if(tampilUser().equals("benar")){
tampilPass();
    if(tampilUser().equals("benar")&&tampilPass().equals("benar")){
        tampilHak();
        String hakAkses = tampilHak();
        if(hakAkses.equals("owner")){
            halamanutama panggil = new halamanutama (username);
            panggil.show();
            dispose();
        }
        else if(hakAkses.equals("petugas")){
            halamanadmin panggil = new halamanadmin (username);
            panggil.show();
            dispose();
        }
        else if(hakAkses.equals("member")){
            halamanmember panggil = new halamanmember(username);
            panggil.show();
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null,"TERJADI ERROR di tombol Insert \nHak Akses Tidak Tersedia", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        }
    else{
    JOptionPane.showMessageDialog(null,"TERJADI ERROR \n Username atau Password Salah", "ERROR!", JOptionPane.ERROR_MESSAGE);
}
    }
else{
    JOptionPane.showMessageDialog(null,"TERJADI ERROR \n Username atau Password Salah", "ERROR!", JOptionPane.ERROR_MESSAGE);
}
        
//        System.out.println(user.getText());
//        System.out.println(password.getText());
//        if(user.getText().equals("fika")&& password.getText().equals("123")){
//            
//        }
//        if(user.getText().equals("member")&& password.getText().equals("member")){
//            halamanmember panggil = new halamanmember ();
//            panggil.show();
//            dispose();
//        }
//        if(user.getText().equals("admin")&& password.getText().equals("admin")){
//            
//        }
    }//GEN-LAST:event_tombolloginActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rohmatcell.gambarbackground gambarbackground1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel tampiljam;
    private javax.swing.JLabel tampiltanggal;
    private javax.swing.JButton tombollogin;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
