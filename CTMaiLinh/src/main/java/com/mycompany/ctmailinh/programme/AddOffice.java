/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ctmailinh.programme;

import com.mycompany.ctmailinh.libraly.CheckException;
import com.mycompany.ctmailinh.libraly.QuerryOffice;
import com.mycompany.ctmailinh.object.IdChooseNV;
import com.mycompany.ctmailinh.object.Office;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows
 */
public class AddOffice extends javax.swing.JFrame {
    IdChooseNV id = new IdChooseNV();
    /**
     * Creates new form AddOffice
     */
    public AddOffice() {
        initComponents();
        setLocationRelativeTo(null);
        addComboBoxDate();
        addComboBoxMonth();
        addComboBoxYear();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtofficeadd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtdateofficeadd = new javax.swing.JComboBox<>();
        txtmonthofficeadd = new javax.swing.JComboBox<>();
        txtyearofficeadd = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Thêm chức vụ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 6, -1, -1));

        jLabel2.setText("Tên chức vụ:");

        jLabel3.setText("Ngày bắt đầu:");

        txtmonthofficeadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmonthofficeaddActionPerformed(evt);
            }
        });

        txtyearofficeadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtyearofficeaddActionPerformed(evt);
            }
        });

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Trở về");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtdateofficeadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtmonthofficeadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(txtyearofficeadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtofficeadd))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtofficeadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdateofficeadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmonthofficeadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtyearofficeadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 49, 350, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DetailNV detailNV = new DetailNV();
        detailNV.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String position  = txtofficeadd.getText();
        String checkdate = (String) txtdateofficeadd.getSelectedItem();
        String date = "";
        if (checkdate.length() == 1) {
            date = "0"+checkdate;
        } else {
            date = checkdate;
        }
        String[] strMonth = ((String) txtmonthofficeadd.getSelectedItem()).split(" ");
        String month = "";
        if (strMonth[1].length() == 1) {
            month = "0"+strMonth[1];
        } else {
            month = strMonth[1];
        }
        String year = (String) txtyearofficeadd.getSelectedItem();
        CheckException.checkDate(date+"-"+month+"-"+year);
        if (!position.equals("") && !date.equals("") && !month.equals("") && !year.equals("")) {
            Office office = new Office();
            office.setId_employee(id.getIdChooseNV());
            office.setPosition(position);
            office.setStart(date+"-"+month+"-"+year);
            QuerryOffice.insert(office);
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công","Thành công",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập thông tin trước khi thêm","Lỗi",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtmonthofficeaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmonthofficeaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmonthofficeaddActionPerformed

    private void txtyearofficeaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtyearofficeaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtyearofficeaddActionPerformed

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
            java.util.logging.Logger.getLogger(AddOffice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOffice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOffice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOffice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOffice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> txtdateofficeadd;
    private javax.swing.JComboBox<String> txtmonthofficeadd;
    private javax.swing.JTextField txtofficeadd;
    private javax.swing.JComboBox<String> txtyearofficeadd;
    // End of variables declaration//GEN-END:variables

    private void addComboBoxDate() {
        for (int i = 1; i < 32; i++) {
            txtdateofficeadd.addItem(String.valueOf(i));
        }
    }

    private void addComboBoxMonth() {
        for (int i = 1; i < 13; i++) {
            txtmonthofficeadd.addItem("Tháng "+String.valueOf(i));
        }
    }

    private void addComboBoxYear() {
        for (int i = 2020; i < 2023; i++) {
            txtyearofficeadd.addItem(String.valueOf(i));
        }
    }
}