/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.object.SaleReport;
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
 * @author Windows
 */
public class QuerrySaleReport {
    static Connection conn = null;
    static PreparedStatement statement = null;
    static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ctmailinh","root","");
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySaleReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerrySaleReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerrySaleReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement = null;
        conn = null;
    }
    
    public static void insert(SaleReport sr) {
        open();
        String sql = "INSERT INTO sales_report(date,total_price,total_hire) VALUES (?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, sr.getDate());
            statement.setString(2, sr.getTotal_price());
            statement.setInt(3, sr.getTotal_hire());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySaleReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static boolean check(String str) {
        SaleReport sr = null;
        open();
        String sql = "SELECT id,total_hire FROM sales_report WHERE date LIKE ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, str);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                sr = new SaleReport(
                    result.getInt("id"),
                    result.getInt("total_hire")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySaleReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return sr != null;
    }
    
    public static List<SaleReport> select() {
        List<SaleReport> ls = new ArrayList<>();
        open();
        String sql = "SELECT * FROM sales_report";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            SaleReport sr = null;
            while (result.next()) {
                sr = new SaleReport(
                    result.getInt("id"),
                    result.getInt("total_hire"),
                    result.getString("total_price"),
                    result.getString("date")
                );
                ls.add(sr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySaleReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static List<SaleReport> find(String name) {
        List<SaleReport> ls = new ArrayList<>();
        open();
        String sql = "SELECT * FROM sales_report WHERE date LIKE ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            SaleReport sr = null;
            while (result.next()) {
                sr = new SaleReport(
                    result.getInt("id"),
                    result.getInt("total_hire"),
                    result.getString("total_price"),
                    result.getString("date")
                );
                ls.add(sr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySaleReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
}
