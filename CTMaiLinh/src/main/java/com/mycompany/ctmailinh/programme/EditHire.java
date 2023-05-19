/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ctmailinh.programme;

import com.mycompany.ctmailinh.libraly.HandleDate;
import com.mycompany.ctmailinh.libraly.QuerryCorr;
import com.mycompany.ctmailinh.libraly.QuerryCustomer;
import com.mycompany.ctmailinh.libraly.QuerryEmployee;
import com.mycompany.ctmailinh.libraly.QuerryHire;
import com.mycompany.ctmailinh.libraly.QuerryPay;
import com.mycompany.ctmailinh.libraly.QuerrySHire;
import com.mycompany.ctmailinh.libraly.QuerryVehice;
import com.mycompany.ctmailinh.object.Customer;
import com.mycompany.ctmailinh.object.Employee;
import com.mycompany.ctmailinh.object.IdDataAdmin;
import com.mycompany.ctmailinh.object.StatusCorr;
import com.mycompany.ctmailinh.object.StatusHire;
import com.mycompany.ctmailinh.object.StatusPay;
import com.mycompany.ctmailinh.object.Vehice;
import com.mycompany.ctmailinh.object.Hire;
import com.mycompany.ctmailinh.object.IdLogin;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows
 */
public class EditHire extends javax.swing.JFrame {
    IdDataAdmin iddataad = new IdDataAdmin();
    IdLogin idlogin = new IdLogin();
    /**
     * Creates new form EditHire
     */
    public EditHire() {
        initComponents();
        setLocationRelativeTo(null);
        addComboBoxDate();
        addComboBoxMonth();
        addComboBoxYear();
        addComboVehice();
        addComboDriver();
        addComboUser();
        addCorr();
        addHire();
        addPay();
        Hire h = QuerryHire.findByIdFull(iddataad.getIdChooseHire());
        txtvehice.setSelectedItem(h.getVehice_id()+" - "+h.getNameVehi());
        txtdriver.setSelectedItem(h.getEmployee_id()+" - "+h.getNameEploy());
        txtcustomer.setSelectedItem(h.getCustomer_id()+" - "+h.getNameCus());
        txtstatushire.setSelectedItem(h.getStatus_hire_id()+" - "+h.getNameHire());
        txtcorr.setSelectedItem(h.getStatus_correct_id()+" - "+h.getNameCorr());
        txtpay.setSelectedItem(h.getStatus_payment_id()+" - "+h.getNamePayment());
        if (!"NULL".equalsIgnoreCase(h.getTotal_price())) {
            txtprice.setText(h.getTotal_price());
        } else {
            txtprice.setText("");
        }
        
        String[] datetimest = h.getStart_date().split(" ");
        String[] datest = datetimest[0].split("-");
        String[] timest = datetimest[1].split(":");
        HandleDate handle = new HandleDate();
        txthourst.setText(timest[0]);
        txtminisst.setText(timest[1]);
        txtdatest.setSelectedItem(handle.dateString(datest[0]));
        txtmonthst.setSelectedItem("Tháng "+handle.dateString(datest[1]));
        txtyearst.setSelectedItem(handle.dateString(datest[2]));
        if (h.getEnd_date() != null) {
            String[] datetimeed = h.getEnd_date().split(" ");
            String[] dateed = datetimeed[0].split("-");
            String[] timeed = datetimeed[1].split(":");
            txthoured.setText(timeed[0]);
            txtminised.setText(timeed[1]);
            txtdateed.setSelectedItem(handle.dateString(dateed[0]));
            txtmonthed.setSelectedItem("Tháng "+handle.dateString(dateed[1]));
            txtyeared.setSelectedItem(handle.dateString(dateed[2]));
        }
    }

    private void addCorr() {
        List<StatusCorr> ls = QuerryCorr.select();
        for (StatusCorr l : ls) {
            txtcorr.addItem(l.getId()+" - "+l.getName());
        }
    }
    
    private void addHire() {
        List<StatusHire> ls = QuerrySHire.select();
        for (StatusHire l : ls) {
            txtstatushire.addItem(l.getId()+" - "+l.getName());
        }
    }
    
    private void addPay() {
        List<StatusPay> ls = QuerryPay.select();
        for (StatusPay l : ls) {
            txtpay.addItem(l.getId()+" - "+l.getName());
        }
    }
    
    private void addComboUser() {
        List<Customer> ls = new ArrayList<>();
        ls = QuerryCustomer.select();
        for (Customer l : ls) {
            txtcustomer.addItem(l.getId()+" - "+l.getFullname());
        }
    }
    
    private void addComboDriver() {
        List<Employee> ls = new ArrayList<>();
        ls = QuerryEmployee.selectDriver();
        txtdriver.addItem("0 - Không thuê");
        for (Employee l : ls) {
            txtdriver.addItem(String.valueOf(l.getId())+" - "+l.getFullname());
        }
    }
    
    private void addComboVehice() {
        List<Vehice> ls = new ArrayList<>();
        ls = QuerryVehice.findByStatus();
        for (Vehice vehice : ls) {
            txtvehice.addItem(String.valueOf(vehice.getId())+" - "+vehice.getName());
        }
    }
    
    private void addComboBoxDate() {
        for (int i = 1; i < 32; i++) {
            txtdatest.addItem(String.valueOf(i));
            txtdateed.addItem(String.valueOf(i));
        }
    }

    private void addComboBoxMonth() {
        for (int i = 1; i < 13; i++) {
            txtmonthst.addItem("Tháng "+String.valueOf(i));
            txtmonthed.addItem("Tháng "+String.valueOf(i));
        }
    }

    private void addComboBoxYear() {
        for (int i = 2023; i < 2025; i++) {
            txtyearst.addItem(String.valueOf(i));
            txtyeared.addItem(String.valueOf(i));
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtvehice = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtdriver = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtcustomer = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txthourst = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtminisst = new javax.swing.JTextField();
        txtdatest = new javax.swing.JComboBox<>();
        txtmonthst = new javax.swing.JComboBox<>();
        txtyearst = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txthoured = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtminised = new javax.swing.JTextField();
        txtmonthed = new javax.swing.JComboBox<>();
        txtyeared = new javax.swing.JComboBox<>();
        txtdateed = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtstatushire = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtcorr = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtpay = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Chỉnh sửa đơn");

        jLabel2.setText("Phương tiện muốn thuê:");

        jLabel3.setText("Nhân viên lái xe:");

        jLabel4.setText("Người thuê:");

        jLabel5.setText("Thời gian bắt đầu:");

        jLabel6.setText(":");

        jLabel7.setText("Thời gian kết thúc:");

        jLabel8.setText(":");

        jLabel9.setText("Trạng thái mượn:");

        jLabel10.setText("Trạng thái:");

        jLabel11.setText("Thanh toán:");

        jLabel12.setText("Tổng tiền:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtvehice, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txthourst, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtminisst, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtdriver, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtdatest, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtmonthst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtyearst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(txtmonthed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtyeared, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtprice, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpay, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcorr, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtstatushire, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txthoured, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtminised, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtdateed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtvehice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txthourst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtminisst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdatest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmonthst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtyearst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txthoured, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtminised, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmonthed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtyeared, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdateed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtstatushire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtcorr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtpay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jButton1.setText("Trở về");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(164, 164, 164))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(255, 255, 255)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        iddataad.setIdChooseHire(-1);
        TPT tpt = new TPT();
        tpt.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String[] vehiceChoose = String.valueOf(txtvehice.getSelectedItem()).split(" - ");
        String[] driverChoose = String.valueOf(txtdriver.getSelectedItem()).split(" - ");
        String[] userChoose = String.valueOf(txtcustomer.getSelectedItem()).split(" - ");
        String[] statusHire = String.valueOf(txtstatushire.getSelectedItem()).split(" - ");
        String[] statusCorr = String.valueOf(txtcorr.getSelectedItem()).split(" - ");
        String[] statusPay = String.valueOf(txtpay.getSelectedItem()).split(" - ");
        String price = "";
        
        
        String checkdate = String.valueOf(txtdatest.getSelectedItem());
        String date = "";
        if (checkdate.length() == 1) {
            date = "0"+checkdate;
        } else {
            date = checkdate;
        }
        String[] checkmonth = String.valueOf(txtmonthst.getSelectedItem()).split(" ");
        String month = "";
        if (checkmonth[1].length() == 1) {
            month = "0"+checkmonth[1];
        } else {
            month = checkmonth[1];
        }
        String year = String.valueOf(txtyearst.getSelectedItem());
        
        String timehoured = "",timeminised = "",dateed = "",monthed = "",yeared = "";
        if (!"".equals(txthoured.getText()) && !"".equals(txtminised.getText())) {
            timehoured = txthoured.getText();
            timeminised = txtminised.getText();
            String checkdateed = String.valueOf(txtdateed.getSelectedItem());
            if (checkdateed.length() == 1) {
                dateed = "0"+checkdateed;
            } else {
                dateed = checkdateed;
            }
            String[] checkmonthed = String.valueOf(txtmonthed.getSelectedItem()).split(" ");
            if (checkmonthed[1].length() == 1) {
                monthed = "0"+checkmonthed[1];
            } else {
                monthed = checkmonthed[1];
            }
            yeared = String.valueOf(txtyeared.getSelectedItem());
        }
        
        if (!"".equals(txthourst.getText()) && !"".equals(txtminisst.getText())) {
            if (Integer.parseInt(statusPay[0]) == 2) {
                price = txtprice.getText();
                String regex = "[0-9]+";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(price);
                if (!matcher.find()) {
                    JOptionPane.showMessageDialog(rootPane, "Tiền phải là số","Lỗi",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if ("".equals(price)) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập giá","Lỗi",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            Hire h = new Hire();
            h.setAccount_correct_id(idlogin.getId());
            h.setId_hire(iddataad.getIdChooseHire());
            h.setVehice_id(Integer.parseInt(vehiceChoose[0]));
            h.setEmployee_id(Integer.parseInt(driverChoose[0]));
            h.setCustomer_id(Integer.parseInt(userChoose[0]));
            h.setStatus_hire_id(Integer.parseInt(statusHire[0]));
            h.setStatus_correct_id(Integer.parseInt(statusCorr[0]));
            h.setStatus_payment_id(Integer.parseInt(statusPay[0]));
            if (!"".equals(price)) {
                QuerryHire.updatePrice(price, iddataad.getIdChooseHire());
            }
            h.setStart_date(date+"-"+month+"-"+year+" "+txthourst.getText()+":"+txtminisst.getText());
            if (!"".equals(txthoured.getText()) && !"".equals(txtminised.getText())) {
               QuerryHire.updateEd(dateed+"-"+monthed+"-"+yeared+" "+timehoured+":"+timeminised, iddataad.getIdChooseHire());
            }
            QuerryHire.updateFull(h);
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập đầy đủ thông tin");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EditHire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditHire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditHire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditHire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditHire().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> txtcorr;
    private javax.swing.JComboBox<String> txtcustomer;
    private javax.swing.JComboBox<String> txtdateed;
    private javax.swing.JComboBox<String> txtdatest;
    private javax.swing.JComboBox<String> txtdriver;
    private javax.swing.JTextField txthoured;
    private javax.swing.JTextField txthourst;
    private javax.swing.JTextField txtminised;
    private javax.swing.JTextField txtminisst;
    private javax.swing.JComboBox<String> txtmonthed;
    private javax.swing.JComboBox<String> txtmonthst;
    private javax.swing.JComboBox<String> txtpay;
    private javax.swing.JTextField txtprice;
    private javax.swing.JComboBox<String> txtstatushire;
    private javax.swing.JComboBox<String> txtvehice;
    private javax.swing.JComboBox<String> txtyeared;
    private javax.swing.JComboBox<String> txtyearst;
    // End of variables declaration//GEN-END:variables
}
