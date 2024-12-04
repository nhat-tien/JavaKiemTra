/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.javakt;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;


public class PHONGBAN extends javax.swing.JFrame {

     DefaultTableModel tbm =new DefaultTableModel(new String[][]{}, new String[]{"Mã số","Tên Phòng Ban"});

    private String idSelected;
    public PHONGBAN() {
        initComponents();
        tblPhongban.setModel(tbm);
        NapdulieuchoTable();
        initEvents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhongban = new javax.swing.JTable();
        txtTenPB = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblPhongban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Phòng Ban", "Tên Phòng Ban"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPhongban);

        jLabel1.setText("Tên Phòng Ban : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnAdd)
                .addGap(24, 24, 24)
                .addComponent(btnEdit)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenPB, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initEvents() {
        tblPhongban.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if(tbm.getRowCount() > 0) {
            this.idSelected = tblPhongban.getValueAt(tblPhongban.getSelectedRow(),0).toString();
            this.txtTenPB.setText(tblPhongban.getValueAt(tblPhongban.getSelectedRow(),1).toString());
            }
        });
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String tenpb = txtTenPB.getText();
        Connection connect = MysqlConnection.createConnection();
        String sql="insert into phongban(TenPB) values (?)";
        try{
                PreparedStatement ps=connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,tenpb);
                ps.executeUpdate();
                ResultSet keys = ps.getGeneratedKeys();
                keys.next();
                long id = keys.getLong(1);
                tbm.addRow(new String[] {String.valueOf(id), tenpb});
                JOptionPane.showMessageDialog(this,"Thông báo","Thêm phòng ban thành công !",JOptionPane.INFORMATION_MESSAGE);
            }catch (SQLException ex){
                System.out.println(ex);
            }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String tenpb = txtTenPB.getText();
        String mapb = idSelected;
        Connection connect = MysqlConnection.createConnection();
        String sql="update phongban set tenpb = ? where mapb = ?";
        try{
                PreparedStatement ps=connect.prepareStatement(sql);
                ps.setString(1,tenpb);
                ps.setString(2,mapb);
                ps.executeUpdate();
                XoaBang();
                NapdulieuchoTable();
                JOptionPane.showMessageDialog(this,"Thông báo","Sua phòng ban thành công !",JOptionPane.INFORMATION_MESSAGE);
            }catch (SQLException ex){
                System.out.println(ex);
            }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String mapb = idSelected;
        Connection connect = MysqlConnection.createConnection();
        String sql="delete from phongban where mapb = ?";
        try{
                PreparedStatement ps=connect.prepareStatement(sql);
                ps.setString(1,mapb);
                ps.executeUpdate();
                XoaBang();
                NapdulieuchoTable();
                JOptionPane.showMessageDialog(this,"Thông báo","Delete phòng ban thành công !",JOptionPane.INFORMATION_MESSAGE);
            }catch (SQLException ex){
                System.out.println(ex);
            }
    }//GEN-LAST:event_btnDeleteActionPerformed
    
    private void XoaBang() {
        tbm.setRowCount(0);
    }
    private void NapdulieuchoTable()
    {
        Connection conn = MysqlConnection.createConnection();
        String query = "SELECT * FROM phongban";
        
        try {
            //Tạo đối tượng Statement
            Statement stm = conn.createStatement();
            //Thực thi truy vấn và trả về đối tượng ResultSet
            ResultSet rs = stm.executeQuery(query);
        
            while (rs.next()){  //Di chuyển con trỏ xuống bản ghi kế tiếp
                String MaPB = rs.getString("MaPB");
                String TenPB = rs.getString("TenPB");
                tbm.addRow(new String[] {MaPB,TenPB});
            }
            //Đóng kết nối
            conn.close();
        } catch (SQLException e) {
             System.out.println(e);
        }
        
    }
    
    
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
            java.util.logging.Logger.getLogger(PHONGBAN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PHONGBAN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PHONGBAN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PHONGBAN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PHONGBAN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPhongban;
    private javax.swing.JTextField txtTenPB;
    // End of variables declaration//GEN-END:variables
}
