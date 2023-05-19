/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.object.Bonus;
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
public class QuerryBonus {
    static Connection conn = null;
    static PreparedStatement statement = null;
    static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ctmailinh","root","");
        } catch (SQLException ex) {
            Logger.getLogger(QuerryBonus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryBonus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryBonus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement = null;
        conn = null;
    }
    
    public static void insert(Bonus b) {
        open();
        String sql = "INSERT INTO bonus(id_salary,name,pay) VALUES (?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, b.getId_salary_bonus());
            statement.setString(2, b.getName());
            statement.setString(3, b.getPay());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryBonus.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Bonus> selectByFk(int id) {
        List<Bonus> lsBonus = new ArrayList<>();
        Bonus bonus = null;
        open();
        String sql = "SELECT * FROM bonus WHERE id_salary = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                bonus = new Bonus(
                    result.getInt("id"),
                    result.getInt("id_salary"),
                    result.getString("pay"),
                    result.getString("name")
                );
                lsBonus.add(bonus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryBonus.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return lsBonus;
    }
    
    public static Bonus findById(int id) {
        Bonus bonus = null;
        open();
        String sql = "SELECT * FROM bonus WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                bonus = new Bonus(
                    result.getInt("id"),
                    result.getInt("id_salary"),
                    result.getString("pay"),
                    result.getString("name")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryBonus.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return bonus;
    }
    
    public static void update(Bonus b) {
        open();
        String sql = "UPDATE bonus SET name = ?,pay = ? WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, b.getName());
            statement.setString(2, b.getPay());
            statement.setInt(3, b.getId_bonus());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryBonus.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void delete(int id) {
        open();
        String sql = "DELETE FROM bonus WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryBonus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        close();
    }
}
