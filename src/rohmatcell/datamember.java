/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rohmatcell;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arifika
 */
public class datamember extends javax.swing.JInternalFrame {
private DefaultTableModel model;
private DefaultTableModel model1;

    /**
     * Creates new form datamember
     */
    public datamember() {
        initComponents();
        
        model = new DefaultTableModel();
        model.addColumn("NO Hp Member");
        model.addColumn("Nama Member");
        model.addColumn("Nama Konter");
        model.addColumn("Pin");
        model.addColumn("Tanggal Aktif");
        
        tabelmember.setModel(model);
        selectAll();
        
        model1 = new DefaultTableModel();
        model1.addColumn("Id Pembelian");
        model1.addColumn("No Hp Member");
        model1.addColumn("Nominal");
        model1.addColumn("Tanggal");
        
        tabelpembelian.setModel(model1);
        selectAll1();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        datamember = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        isitglakhir = new javax.swing.JLabel();
        isitglawal = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        proses = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelmember = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelpembelian = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("DATA MEMBER");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        datamember.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                datamemberAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel3.setText("Tanggal Akhir   :");

        jLabel2.setText("Tanggal Awal    :");

        isitglakhir.setText("    ");
        isitglakhir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        isitglawal.setText("    ");
        isitglawal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        proses.setText("Proses");
        proses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesActionPerformed(evt);
            }
        });

        tabelmember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelmember);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isitglawal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(isitglakhir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(proses, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(362, 362, 362))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(isitglakhir, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(proses, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(isitglawal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );

        datamember.addTab("Data Member", jPanel1);

        tabelpembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelpembelian.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelpembelianAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane4.setViewportView(tabelpembelian);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        datamember.addTab("Pembelian Saldo", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(datamember, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(datamember, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesActionPerformed
        // TODO add your handling code here:
        String tanggal_awal, tanggal_akhir ;
          String tampilan = "yyyy-MM-dd";

        SimpleDateFormat format = new SimpleDateFormat(tampilan);

        String tanggal = String.valueOf(format.format(jDateChooser1.getDate()));
        String tanggal1 = String.valueOf(format.format(jDateChooser2.getDate()));
        isitglawal.setText(tanggal);
        isitglakhir.setText(tanggal1);
        tanggal_awal = isitglawal .getText().trim();
        tanggal_akhir = isitglakhir.getText().trim();
        String sql;
        sql = "select* from member where tanggal_aktif BETWEEN '"+tanggal_awal+"' and '"+tanggal_akhir+"'";
        for (int i=0;i<tabelmember.getRowCount();i++){
            model.removeRow(i);
        }

        try {
            Connection c=koneksidb.getkoneksi();
            Statement s=c.createStatement();
            ResultSet r=s.executeQuery(sql);
            selectAll();

            //memanggil refresh agar data yang dimasukan langsung tampil
            JOptionPane.showMessageDialog(this,"Berhasil di Mengambil");
        }

        catch(SQLException ex){
            //  Logger.getLogger(FInput.clatxtoperatorame()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Maaf Gagal Mengambil");
        }

    }//GEN-LAST:event_prosesActionPerformed

    private void tabelpembelianAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelpembelianAncestorAdded
         //TODO add your handling code here:
//       
        
    }//GEN-LAST:event_tabelpembelianAncestorAdded

    private void datamemberAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_datamemberAncestorAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_datamemberAncestorAdded

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane datamember;
    private javax.swing.JLabel isitglakhir;
    private javax.swing.JLabel isitglawal;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton proses;
    private javax.swing.JTable tabelmember;
    private javax.swing.JTable tabelpembelian;
    // End of variables declaration//GEN-END:variables

    private void selectAll() {
         tabelmember.setModel(model);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        String tanggal_awal = isitglawal .getText().trim();
        String tanggal_akhir = isitglakhir.getText().trim();
        
        try {
            Connection c=koneksidb.getkoneksi();
            Statement s=c.createStatement();
            ResultSet r=s.executeQuery("select* from member where tanggal_aktif BETWEEN '"+tanggal_awal+"' and '"+tanggal_akhir+"'");
            while(r.next()){
                Object[] pulsa = new Object[5]; 
            pulsa[0]=r.getString("No_hp_Member");
            pulsa[1]=r.getString("Nama_Member");
            pulsa[2]=r.getString("Nama_konter");
            pulsa[3]=r.getString("pin");
            pulsa[4]=r.getString("tanggal_aktif");
            model.addRow(pulsa);
            }
        }
        catch (SQLException e){
            System.out.println("terjadi error :" +e);
        }
    }

    private void selectAll1() {
        tabelpembelian.setModel(model1);
        model1.getDataVector().removeAllElements();
        model1.fireTableDataChanged();
        try {
            Connection c=koneksidb.getkoneksi();
            Statement s=c.createStatement();
            ResultSet r=s.executeQuery("select* from pembelian_saldo");
            while(r.next()){
                Object[] pembelian = new Object[4]; 
                
            pembelian[0]=r.getString("Id_pembelian");
            pembelian[1]=r.getString("no_hp_member");
            pembelian[2]=r.getString("Nominal_pembelian");
            pembelian[3]=r.getString("tanggal_pembelian");
            model1.addRow(pembelian);
           
   
            }
        }
        catch (SQLException e){
            System.out.println("terjadi error :" +e);
        }
    }
    
}