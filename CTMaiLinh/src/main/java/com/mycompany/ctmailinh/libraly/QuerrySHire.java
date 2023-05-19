/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.object.StatusHire;
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
public class QuerrySHire {
    static Connection conn = null;
    static PreparedStatement statement = null;
    static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ctmailinh","root","");
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySHire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerrySHire.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerrySHire.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement = null;
        conn = null;
    }
    
    public static List<StatusHire> select() {
        List<StatusHire> ls = new ArrayList<>();
        open();
        String sql = "SELECT * FROM status_hire";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            StatusHire sc = null;
            while (result.next()) {
                sc = new StatusHire(
                        result.getInt("id"),
                        result.getString("name")
                );
                ls.add(sc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySHire.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
}
