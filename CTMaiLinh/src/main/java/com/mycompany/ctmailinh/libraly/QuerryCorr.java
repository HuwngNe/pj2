/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.object.StatusCorr;
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
public class QuerryCorr {
    static Connection conn = null;
    static PreparedStatement statement = null;
    static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ctmailinh","root","");
        } catch (SQLException ex) {
            Logger.getLogger(QuerryCorr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryCorr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryCorr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement = null;
        conn = null;
    }
    
    public static List<StatusCorr> select() {
        List<StatusCorr> ls = new ArrayList<>();
        open();
        String sql = "SELECT * FROM status_correct";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            StatusCorr sc = null;
            while (result.next()) {
                sc = new StatusCorr(
                        result.getInt("id"),
                        result.getString("name")
                );
                ls.add(sc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryCorr.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
}
