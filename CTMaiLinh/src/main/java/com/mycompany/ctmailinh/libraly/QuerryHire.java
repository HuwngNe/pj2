/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.object.Hire;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class QuerryHire {
    static Connection conn = null;
    static PreparedStatement statement = null;
    static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ctmailinh","root","");
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement = null;
        conn = null;
    }
    
    public static void insert(Hire h) {
        open();
        String sql = "";
        if (h.getEmployee_id() == 0) {
            sql = "insert into hire(vehice_id,customer_id,status_hire_id,status_correct_id,status_payment_id,start_date) values (?,?,?,?,?,?)";
        } else {
            sql = "insert into hire(vehice_id,customer_id,status_hire_id,status_correct_id,status_payment_id,start_date,employee_id) values (?,?,?,?,?,?,?)";
        }
        try {
            statement = conn.prepareStatement(sql);
            if (h.getEmployee_id() == 0) {
                statement.setInt(1,h.getVehice_id());
                statement.setInt(2, h.getCustomer_id());
                statement.setInt(3, h.getStatus_hire_id());
                statement.setInt(4, h.getStatus_correct_id());
                statement.setInt(5, h.getStatus_payment_id());
                statement.setString(6, h.getStart_date());
            } else {
                statement.setInt(1,h.getVehice_id());
                statement.setInt(2, h.getCustomer_id());
                statement.setInt(3, h.getStatus_hire_id());
                statement.setInt(4, h.getStatus_correct_id());
                statement.setInt(5, h.getStatus_payment_id());
                statement.setString(6, h.getStart_date());
                statement.setInt(7, h.getEmployee_id());
            }
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Hire> select(int id) {
        List<Hire> ls = new ArrayList<>();
        open();
        String sql = "SELECT hire.id,hire.status_correct_id,status_hire.name ,status_payment.name as pay_name FROM hire JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_payment ON status_payment.id = hire.status_payment_id WHERE hire.customer_id = ? ORDER BY hire.id DESC";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Hire h = null;
            while (result.next()) {
                h = new Hire(
                        result.getInt("id"),
                        result.getInt("status_correct_id"),
                        result.getString("name"),
                        result.getString("pay_name")
                );
                ls.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static Hire findById(int id) {
        Hire h = null;
        open();
        String sql = "SELECT * FROM hire WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                h = new Hire(
                        result.getInt("id"),
                        result.getInt("vehice_id"),
                        result.getInt("employee_id"),
                        result.getString("start_date")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return h;
    }
    
    public static void update(Hire h) {
        open();
        String sql = "";
        if (h.getEmployee_id() == 0) {
            sql = "UPDATE hire SET vehice_id = ?, start_date = ? WHERE id = ?";
        } else {
            sql = "UPDATE hire SET vehice_id = ?, employee_id = ?, start_date = ? WHERE id = ?";
        }
        try {
            statement = conn.prepareStatement(sql);
            if (h.getEmployee_id() == 0) {
                statement.setInt(1, h.getVehice_id());
                statement.setString(2, h.getStart_date());
                statement.setInt(3, h.getId_hire());
            } else {
                statement.setInt(1, h.getVehice_id());
                statement.setInt(2, h.getEmployee_id());
                statement.setString(3, h.getStart_date());
                statement.setInt(4, h.getId_hire());
            }
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static Hire findDetail(int id,int check) {
        Hire h = null;
        open();
        String sql = "";
        if (check == 0) {
            sql = "SELECT hire.id,hire.start_date,hire.end_date,hire.vehice_id,vehice.name,status_correct.name as corr_name,status_hire.name as hire_name,status_payment.name as pay_name FROM hire JOIN vehice ON vehice.id = hire.vehice_id JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_correct ON status_correct.id = hire.status_correct_id JOIN status_payment ON status_payment.id = hire.status_payment_id WHERE hire.id = ?";
        } else {
            sql = "SELECT hire.id,hire.start_date,hire.end_date, hire.vehice_id,hire.employee_id,vehice.name,status_correct.name as corr_name,status_hire.name as hire_name,status_payment.name as pay_name,employee.fullname as emplo_name FROM hire JOIN employee ON employee.id = hire.employee_id JOIN vehice ON vehice.id = hire.vehice_id JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_correct ON status_correct.id = hire.status_correct_id JOIN status_payment ON status_payment.id = hire.status_payment_id WHERE hire.id = ?";
        }
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (check == 0) {
                while (result.next()) {
                    h = new Hire(
                        result.getInt("id"),
                        result.getInt("vehice_id"),
                        result.getString("start_date"),
                        result.getString("end_date"),
                        result.getString("hire_name"),
                        result.getString("pay_name"),
                        result.getString("corr_name"),
                        result.getString("name")
                    );
                    break;
                } 
            } else {
                while (result.next()) {
                    h = new Hire(
                        result.getInt("id"),
                        result.getInt("vehice_id"),
                        result.getInt("employee_id"),
                        result.getString("start_date"),
                        result.getString("end_date"),
                        result.getString("hire_name"),
                        result.getString("pay_name"),
                        result.getString("corr_name"),
                        result.getString("name"),
                        result.getString("emplo_name")
                    );
                    break;
                } 
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return h;
    }
    
    public static List<Hire> select() {
        List<Hire> ls = new ArrayList<>();
        open();
        String sql = "SELECT hire.id,hire.status_correct_id,status_hire.name ,status_payment.name as pay_name FROM hire JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_payment ON status_payment.id = hire.status_payment_id ORDER BY hire.id DESC";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Hire h = null;
            while (result.next()) {
                h = new Hire(
                        result.getInt("id"),
                        result.getInt("status_correct_id"),
                        result.getString("name"),
                        result.getString("pay_name")
                );
                ls.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static List<Hire> findByIdS(int id) {
        List<Hire> ls = new ArrayList<>();
        Hire h = null;
        open();
        String sql = "SELECT hire.id,hire.status_correct_id,status_hire.name ,status_payment.name as pay_name FROM hire JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_payment ON status_payment.id = hire.status_payment_id  WHERE hire.id = ? ORDER BY hire.id DESC";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                h = new Hire(
                    result.getInt("id"),
                    result.getInt("status_correct_id"),
                    result.getString("name"),
                    result.getString("pay_name")
                );
                ls.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static Hire findDetailEmp(int id,int check) {
        Hire h = null;
        open();
        String sql = "";
        if (check == 0) {
            sql = "SELECT hire.customer_id,customer.fullname,hire.start_date,hire.end_date,hire.vehice_id,vehice.name,status_correct.name as corr_name,status_hire.name as hire_name,status_payment.name as pay_name FROM hire JOIN vehice ON vehice.id = hire.vehice_id JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_correct ON status_correct.id = hire.status_correct_id JOIN status_payment ON status_payment.id = hire.status_payment_id JOIN customer ON customer.id = hire.customer_id WHERE hire.id = ?";
        } else {
            sql = "SELECT hire.customer_id,customer.fullname,hire.start_date,hire.end_date, hire.vehice_id,hire.employee_id,vehice.name,status_correct.name as corr_name,status_hire.name as hire_name,status_payment.name as pay_name,employee.fullname as emplo_name FROM hire JOIN employee ON employee.id = hire.employee_id JOIN vehice ON vehice.id = hire.vehice_id JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_correct ON status_correct.id = hire.status_correct_id JOIN status_payment ON status_payment.id = hire.status_payment_id JOIN customer ON customer.id = hire.customer_id WHERE hire.id = ?";
        }
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (check == 0) {
                while (result.next()) {
                    h = new Hire(
                        result.getInt("vehice_id"),
                        result.getInt("customer_id"),
                        result.getString("start_date"),
                        result.getString("end_date"),
                        result.getString("hire_name"),
                        result.getString("pay_name"),
                        result.getString("corr_name"),
                        result.getString("name"),
                        result.getString("fullname")
                    );
                    break;
                } 
            } else {
                while (result.next()) {
                    h = new Hire(
                        result.getInt("vehice_id"),
                        result.getInt("employee_id"),
                        result.getInt("customer_id"),
                        result.getString("start_date"),
                        result.getString("end_date"),
                        result.getString("hire_name"),
                        result.getString("pay_name"),
                        result.getString("corr_name"),
                        result.getString("name"),
                        result.getString("emplo_name"),
                        result.getString("fullname")
                    );
                    break;
                } 
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return h;
    }
    
    public static void updateCorrect(int id,int idaccount) {
        open();
        String sql = "";
            sql = "UPDATE hire SET status_correct_id = 2, account_correct_id = ? WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idaccount);
            statement.setInt(2, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void updateHire(int id,int idaccount) {
        open();
        String sql = "";
            sql = "UPDATE hire SET status_hire_id = 1, account_correct_id = ? WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idaccount);
            statement.setInt(2, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void updatePay(int id,int idaccount,String total) {
        open();
        String sql = "";
            sql = "UPDATE hire SET status_hire_id = 2, account_correct_id = ?, status_payment = 2,total_price = ? WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idaccount);
            statement.setString(2, total);
            statement.setInt(3, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Hire> selectCorrWait() {
        List<Hire> ls = new ArrayList<>();
        open();
        String sql = "SELECT hire.id,hire.status_correct_id,status_hire.name ,status_payment.name as pay_name FROM hire JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_payment ON status_payment.id = hire.status_payment_id WHERE hire.status_correct_id = 1 ORDER BY hire.id DESC";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Hire h = null;
            while (result.next()) {
                h = new Hire(
                        result.getInt("id"),
                        result.getInt("status_correct_id"),
                        result.getString("name"),
                        result.getString("pay_name")
                );
                ls.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static List<Hire> selectCorr() {
        List<Hire> ls = new ArrayList<>();
        open();
        String sql = "SELECT hire.id,hire.status_correct_id,status_hire.name ,status_payment.name as pay_name FROM hire JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_payment ON status_payment.id = hire.status_payment_id WHERE hire.status_correct_id = 2 ORDER BY hire.id DESC";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Hire h = null;
            while (result.next()) {
                h = new Hire(
                        result.getInt("id"),
                        result.getInt("status_correct_id"),
                        result.getString("name"),
                        result.getString("pay_name")
                );
                ls.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static List<Hire> selectHireM() {
        List<Hire> ls = new ArrayList<>();
        open();
        String sql = "SELECT hire.id,hire.status_correct_id,status_hire.name ,status_payment.name as pay_name FROM hire JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_payment ON status_payment.id = hire.status_payment_id WHERE hire.status_hire_id = 1 ORDER BY hire.id DESC";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Hire h = null;
            while (result.next()) {
                h = new Hire(
                        result.getInt("id"),
                        result.getInt("status_correct_id"),
                        result.getString("name"),
                        result.getString("pay_name")
                );
                ls.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static List<Hire> selectHireT() {
        List<Hire> ls = new ArrayList<>();
        open();
        String sql = "SELECT hire.id,hire.status_correct_id,status_hire.name ,status_payment.name as pay_name FROM hire JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_payment ON status_payment.id = hire.status_payment_id WHERE hire.status_hire_id = 2 ORDER BY hire.id DESC";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Hire h = null;
            while (result.next()) {
                h = new Hire(
                        result.getInt("id"),
                        result.getInt("status_correct_id"),
                        result.getString("name"),
                        result.getString("pay_name")
                );
                ls.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static List<Hire> selectVehice(int id) {
        List<Hire> ls = new ArrayList<>();
        open();
        String sql = "SELECT hire.id,hire.start_date,hire.status_correct_id,status_hire.name ,status_payment.name as pay_name FROM hire JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_payment ON status_payment.id = hire.status_payment_id WHERE hire.vehice_id = ? ORDER BY hire.id DESC";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Hire h = null;
            while (result.next()) {
                h = new Hire(
                        result.getInt("id"),
                        result.getInt("status_correct_id"),
                        result.getString("start_date"),
                        result.getString("name"),
                        result.getString("pay_name")
                );
                ls.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static void deleteById(int id) {
        open();
        String sql = "DELETE FROM hire WHERE vehice_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void deleteByIdCus(int id) {
        open();
        String sql = "DELETE FROM hire WHERE customer_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    public static void deleteByIdEmp(int id) {
        open();
        String sql = "DELETE FROM hire WHERE employee_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static Hire findByIdFull(int id) {
        Hire h = null;
        open();
        String sql = "SELECT hire.*,status_hire.name,status_payment.name as pay_name,status_correct.name as corr_name,vehice.name as vehi_name,employee.fullname,customer.fullname as cus_name FROM hire JOIN status_hire ON status_hire.id = hire.status_hire_id JOIN status_payment ON status_payment.id = hire.status_payment_id JOIN status_correct ON status_correct.id = hire.status_correct_id JOIN vehice ON vehice.id = hire.vehice_id JOIN employee ON employee.id = hire.employee_id JOIN customer ON customer.id = hire.customer_id WHERE hire.id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                h = new Hire(
                        result.getInt("id"),
                        result.getInt("vehice_id"),
                        result.getInt("employee_id"),
                        result.getInt("customer_id"),
                        result.getInt("status_hire_id"),
                        result.getInt("status_correct_id"),
                        result.getInt("status_payment_id"),
                        result.getString("start_date"),
                        result.getString("end_date"),
                        result.getString("total_price"),
                        result.getString("name"),
                        result.getString("pay_name"),
                        result.getString("corr_name"),
                        result.getString("vehi_name"),
                        result.getString("fullname"),
                        result.getString("cus_name")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return h;
    }
    
    public static void updateFull(Hire h) {
        open();
        String sql = "";
            sql = "UPDATE hire SET vehice_id = ?, employee_id = ?, customer_id = ?, status_hire_id = ?, status_correct_id = ?, status_payment_id = ?, account_correct_id = ?, start_date = ?  WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, h.getVehice_id());
            statement.setInt(2, h.getEmployee_id());
            statement.setInt(3, h.getCustomer_id());
            statement.setInt(4, h.getStatus_hire_id());
            statement.setInt(5, h.getStatus_correct_id());
            statement.setInt(6, h.getStatus_payment_id());
            statement.setInt(7, h.getAccount_correct_id());
            statement.setString(8, h.getStart_date());
            statement.setInt(9, h.getId_hire());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void updatePrice(String p,int id) {
        open();
        String sql = "";
            sql = "UPDATE hire SET total_price = ?  WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, p);
            statement.setInt(2, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void updateEd(String p,int id) {
        open();
        String sql = "";
            sql = "UPDATE hire SET end_date = ?  WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, p);
            statement.setInt(2, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Hire> selectIdAcc(int id){
        List<Hire> ls = new ArrayList<>();
        Hire h = null;
        open();
        String sql = "SELECT id FROM hire WHERE account_correct_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                h = new Hire(
                        result.getInt("id")
                );
                ls.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static void updateAcc(int id) {
        open();
        String sql = "";
            sql = "UPDATE hire SET account_correct_id = 6  WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void delete(int id) {
        open();
        String sql = "DELETE FROM hire WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
}
