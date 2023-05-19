/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.object.Position;
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
public class QuerryPosition {
    static Connection conn = null;
    static PreparedStatement statement = null;
    static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ctmailinh","root","");
        } catch (SQLException ex) {
            Logger.getLogger(QuerryPosition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryPosition.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryPosition.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement = null;
        conn = null;
    }
    
    public static List<Position> select() {
        List<Position> ls = new ArrayList<>();
        open();
        String sql = "SELECT * FROM position";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Position po = null;
            while (result.next()) {
                po = new Position(
                        result.getInt("id"),
                        result.getString("name")
                );
                ls.add(po);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryPosition.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static Position findById(int id) {
        Position po = null;
        open();
        String sql = "SELECT * FROM position WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                po = new Position(
                        result.getInt("id"),
                        result.getString("name")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryPosition.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return po;
    }
    
    public static Position findByName(String n) {
        Position po = null;
        open();
        String sql = "SELECT * FROM position WHERE name LIKE ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, n);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                po = new Position(
                        result.getInt("id"),
                        result.getString("name")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryPosition.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return po;
    }
}
