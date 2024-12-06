/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.javakt.views;

import com.mycompany.javakt.models.PhongBan;
import com.mycompany.javakt.views.interfaces.PhongBanView;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class PHONGBAN extends javax.swing.JFrame implements PhongBanView {

  public DefaultTableModel tbm =
      new DefaultTableModel(new String[][] {}, new String[] {"Mã số", "Tên Phòng Ban"});

  private String idSelected;

  public ActionListener onAdd;
  public ActionListener onEdit;
  public ActionListener onDelete;
  public ActionListener onChangeToNhanVien;

  public String getTenPhongBan() {
    return txtTenPB.getText();
  }

  public void addRow(PhongBan pb) {
    tbm.addRow(new String[] {String.valueOf(pb.getMaPB()), pb.getTenPB()});
  }

  public String getIdSelected() {
    return this.idSelected;
  }

  public PHONGBAN() {
    initComponents();
    tblPhongban.setModel(tbm);
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
    btnNew = new javax.swing.JButton();
    btnNhanVien = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    btnEdit.setText("EDIT");

    btnDelete.setText("DELETE");

    btnAdd.setText("ADD");

    tblPhongban.setModel(
        new javax.swing.table.DefaultTableModel(
            new Object[][] {
              {null, null},
              {null, null},
              {null, null},
              {null, null}
            },
            new String[] {"Mã Phòng Ban", "Tên Phòng Ban"}) {
          Class[] types = new Class[] {java.lang.Integer.class, java.lang.String.class};

          public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
          }
        });
    jScrollPane1.setViewportView(tblPhongban);

    jLabel1.setText("Tên Phòng Ban : ");

    btnNew.setText("NEW");
    btnNew.setToolTipText("");
    btnNew.setName("btnNew"); // NOI18N
    btnNew.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNewActionPerformed(evt);
          }
        });

    btnNhanVien.setText("Nhân Viên");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                layout
                                    .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(
                                        layout
                                            .createSequentialGroup()
                                            .addComponent(
                                                jLabel1,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addGap(18, 18, 18)
                                            .addComponent(
                                                txtTenPB,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                187,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(
                                        jScrollPane1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        301,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        btnAdd,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        60,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(btnNew)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnDelete)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(
                                        btnEdit,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        59,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(btnNhanVien)
                    .addContainerGap(13, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                txtTenPB,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        jScrollPane1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        238,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(btnNhanVien)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)))
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete)
                            .addComponent(btnNew)
                            .addComponent(btnEdit))
                    .addGap(35, 35, 35)));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void btnNewActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnNewActionPerformed
    idSelected = "";
    txtTenPB.setText("");
  } // GEN-LAST:event_btnNewActionPerformed

  public void initEvents() {
    btnDelete.addActionListener(onDelete);
    btnEdit.addActionListener(onEdit);
    btnAdd.addActionListener(onAdd);
    btnNhanVien.addActionListener(onChangeToNhanVien);
    tblPhongban
        .getSelectionModel()
        .addListSelectionListener(
            (ListSelectionEvent event) -> {
              if (tblPhongban.getSelectedRow() >= 0) {
                this.idSelected =
                    tblPhongban.getValueAt(tblPhongban.getSelectedRow(), 0).toString();
                this.txtTenPB.setText(
                    tblPhongban.getValueAt(tblPhongban.getSelectedRow(), 1).toString());
              }
            });
  }

  public void XoaBang() {
    tbm.setRowCount(0);
  }

  public void NapdulieuchoTable(List<PhongBan> list) {
    for (PhongBan pb : list) {
      tbm.addRow(new String[] {String.valueOf(pb.getMaPB()), pb.getTenPB()});
    }
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(PHONGBAN.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PHONGBAN.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PHONGBAN.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PHONGBAN.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new PHONGBAN().setVisible(true);
          }
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAdd;
  private javax.swing.JButton btnDelete;
  private javax.swing.JButton btnEdit;
  private javax.swing.JButton btnNew;
  private javax.swing.JButton btnNhanVien;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tblPhongban;
  private javax.swing.JTextField txtTenPB;

  // End of variables declaration//GEN-END:variables
  @Override
  public void open() {
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void setOnAdd(ActionListener onAdd) {
    this.onAdd = onAdd;
  }

  @Override
  public void setOnEdit(ActionListener onEdit) {
    this.onEdit = onEdit;
  }

  @Override
  public void setOnDelete(ActionListener onDelete) {
    this.onDelete = onDelete;
  }

  @Override
  public void setOnChangeNhanVien(ActionListener onChangeToNhanVien) {
    this.onChangeToNhanVien = onChangeToNhanVien;
  }

}
