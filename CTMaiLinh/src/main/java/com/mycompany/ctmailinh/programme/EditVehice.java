/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ctmailinh.programme;

import com.mycompany.ctmailinh.libraly.HandleDate;
import com.mycompany.ctmailinh.libraly.QuerryVehice;
import com.mycompany.ctmailinh.object.IdDataAdmin;
import com.mycompany.ctmailinh.object.Vehice;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows
 */
public class EditVehice extends javax.swing.JFrame {
    IdDataAdmin iddataad = new IdDataAdmin();
    /**
     * Creates new form EditVehice
     */
    public EditVehice() {
        initComponents();
        setLocationRelativeTo(null);
        addComboBoxDate();
        addComboBoxMonth();
        addComboBoxYear();
        Vehice vehice = QuerryVehice.find(iddataad.getIdChooseVehice());
        txtnamevehiceedit.setText(vehice.getName());
        txtcolorvehiceedit.setText(vehice.getColor());
        txtsitvehiceedit.setText(String.valueOf(vehice.getNumber_of_seats()));
        txtbsvehiceedit.setText(vehice.getLicense_plates());
        txtpricevehiceedit.setText(vehice.getPrice());
        
        String[] date = vehice.getTesting_date().split("-");
        HandleDate handle = new HandleDate();
        txtdatevehiceedit.setSelectedItem(handle.dateString(date[0]));
        txtmonthvehiceedit.setSelectedItem("Tháng "+handle.dateString(date[1]));
        txtyearvehiceedit.setSelectedItem(handle.dateString(date[2]));
    }

    private void addComboBoxDate() {
        for (int i = 1; i < 32; i++) {
            txtdatevehiceedit.addItem(String.valueOf(i));
        }
    }

    private void addComboBoxMonth() {
        for (int i = 1; i < 13; i++) {
            txtmonthvehiceedit.addItem("Tháng "+String.valueOf(i));
        }
    }

    private void addComboBoxYear() {
        for (int i = 2000; i < 2024; i++) {
            txtyearvehiceedit.addItem(String.valueOf(i));
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnamevehiceedit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcolorvehiceedit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtsitvehiceedit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtbsvehiceedit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtdatevehiceedit = new javax.swing.JComboBox<>();
        txtmonthvehiceedit = new javax.swing.JComboBox<>();
        txtyearvehiceedit = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtpricevehiceedit = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Chỉnh sửa thông tin phương tiện");

        jLabel2.setText("Tên xe:");

        jLabel3.setText("Màu:");

        jLabel4.setText("Số ghế:");

        jLabel5.setText("Biển số xe:");

        jLabel6.setText("Ngày kiểm tra:");

        jLabel7.setText("Giá thuê:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcolorvehiceedit)
                            .addComponent(txtnamevehiceedit)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtdatevehiceedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtmonthvehiceedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtyearvehiceedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtpricevehiceedit)
                            .addComponent(txtbsvehiceedit)
                            .addComponent(txtsitvehiceedit))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnamevehiceedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcolorvehiceedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtsitvehiceedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtbsvehiceedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtdatevehiceedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmonthvehiceedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtyearvehiceedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtpricevehiceedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jButton1.setText("Sửa");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(203, 203, 203)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        iddataad.setIdChooseVehice(-1);
        PT pt = new PT();
        pt.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = txtnamevehiceedit.getText();
        String color = txtcolorvehiceedit.getText();
        int sit = Integer.parseInt(txtsitvehiceedit.getText());
        String bs = txtbsvehiceedit.getText();
        String price = txtpricevehiceedit.getText();
        
        String checkdate = String.valueOf(txtdatevehiceedit.getSelectedItem());
        String date = "";
        if (checkdate.length() == 1) {
            date = "0"+checkdate;
        } else {
            date = checkdate;
        }
        String[] checkmonth = String.valueOf(txtmonthvehiceedit.getSelectedItem()).split(" ");
        String month = "";
        if (checkmonth[1].length() == 1) {
            month = "0"+checkmonth[1];
        } else {
            month = checkmonth[1];
        }
        String year = String.valueOf(txtyearvehiceedit.getSelectedItem());
        
        if (!"".equals(name) && !"".equals(bs) && !"".equals(color) && !"".equals(sit) && !"".equals(price)) {
            Vehice vehice = new Vehice();
            vehice.setName(name);
            vehice.setColor(color);
            vehice.setLicense_plates(bs);
            vehice.setNumber_of_seats(sit);
            vehice.setPrice(price);
            vehice.setTesting_date(date+"-"+month+"-"+year);
            vehice.setId(iddataad.getIdChooseVehice());
            QuerryVehice.editById(vehice);
            JOptionPane.showMessageDialog(rootPane, "Sửa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập đầy đủ thông tin","Lỗi",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EditVehice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditVehice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditVehice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditVehice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditVehice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtbsvehiceedit;
    private javax.swing.JTextField txtcolorvehiceedit;
    private javax.swing.JComboBox<String> txtdatevehiceedit;
    private javax.swing.JComboBox<String> txtmonthvehiceedit;
    private javax.swing.JTextField txtnamevehiceedit;
    private javax.swing.JTextField txtpricevehiceedit;
    private javax.swing.JTextField txtsitvehiceedit;
    private javax.swing.JComboBox<String> txtyearvehiceedit;
    // End of variables declaration//GEN-END:variables
}
