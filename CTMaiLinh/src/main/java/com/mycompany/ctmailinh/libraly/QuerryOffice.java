/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.object.Office;
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
public class QuerryOffice {
    static Connection conn = null;
    static PreparedStatement statement = null;
    static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ctmailinh","root","");
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement = null;
        conn = null;
    }
    
    public static void insert(Office off) {
        open();
        String sql = "insert into office(id_employee,position,start) values ("+off.getId_employee()+",'"+off.getPosition()+"','"+off.getStart()+"')";
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Office> select() {
        List<Office> listOffice = new ArrayList<>();
        open();
        String sql = "SELECT employee.id,employee.ID_card,employee.fullname,employee.phone,office.id as office_id, office.position FROM office JOIN employee ON office.id_employee = employee.id";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Office office = null;
            while (result.next()) {
                office = new Office(
                        result.getInt("office_id"),
                        result.getString("position"),
                        result.getInt("id"),
                        result.getString("ID_card"),
                        result.getString("fullname"),
                        result.getString("phone")
                );
                listOffice.add(office);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listOffice;
    }
    
    public static Office findById(int id) {
        Office office = null;
        open();
        String sql = "SELECT employee.*,office.id as office_id, office.position, office.start FROM office JOIN employee ON office.id_employee = employee.id WHERE employee.id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                office = new Office(
                        result.getInt("office_id"),
                        result.getString("position"),
                        result.getString("start"),
                        result.getInt("id"),
                        result.getString("ID_card"),
                        result.getString("fullname"),
                        result.getString("gender"),
                        result.getString("address"),
                        result.getString("phone"),
                        result.getString("birthday"),
                        result.getString("salary")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return office;
    }
    
    public static void update(Office o) {
        open();
        String sql = "";
        if (o.getEnd() == null) {
            sql = "UPDATE office SET position = '"+o.getPosition()+"', start = '"+o.getStart()+"' WHERE id = "+o.getId_office();
        } else {
            sql = "UPDATE office SET position = '"+o.getPosition()+"', start = '"+o.getStart()+"', end = '"+o.getEnd()+"' WHERE id = "+o.getId_office();
        }
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Office> selectById(int id) {
        List<Office> listOffice = new ArrayList<>();
        open();
        String sql = "SELECT * FROM office WHERE id_employee = "+id;
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Office office = null;
            while (result.next()) {
                office = new Office(
                        result.getInt("id"),
                        result.getInt("id_employee"),
                        result.getString("position"),
                        result.getString("start"),
                        result.getString("end")
                );
                listOffice.add(office);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listOffice;
    }
    
    public static void deleteByIdFk(int i) {
        open();
        String sql = "DELETE FROM office WHERE id_employee = "+i;
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static Office findByIdPk(int id) {
        Office office = null;
        open();
        String sql = "SELECT * FROM office WHERE id = "+id;
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                office = new Office(
                        result.getInt("id"),
                        result.getInt("id_employee"),
                        result.getString("position"),
                        result.getString("start"),
                        result.getString("end")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return office;
    }
    
    public static void deleteByIdPk(int id) {
        open();
        String sql = "DELETE FROM office WHERE id = "+id;
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
}
