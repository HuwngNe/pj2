/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.object.Vehice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class QuerryVehice {
    static Connection conn = null;
    static PreparedStatement statement = null;
    static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ctmailinh","root","");
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement = null;
        conn = null;
    }
    
    public static void insert(Vehice vehice) {
        open();
        String sql = "insert into vehice(name,testing_date,number_of_seats,color,license_plates,price,status) values ("+vehice.getName()+","+vehice.getTesting_date()+","+vehice.getNumber_of_seats()+","+vehice.getColor()+","+vehice.getLicense_plates()+","+vehice.getPrice()+","+vehice.getStatus()+")";
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Vehice> select() {
        List<Vehice> listVehice = new ArrayList<>();
        open();
        String sql = "SELECT * FROM vehice";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Vehice vehice = null;
            while (result.next()) {
                vehice = new Vehice(
                        result.getInt("id"),
                        result.getInt("number_of_seats"),
                        result.getInt("status"),
                        result.getString("name"),
                        result.getString("testing_date"),
                        result.getString("color"),
                        result.getString("license_plates"),
                        result.getDouble("price")
                );
                listVehice.add(vehice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listVehice;
    }
    
    public static void delete(int id) {
        CheckException.checkNumberZero(id);
        open();
        String sql = "DELETE FROM vehice WHERE id = "+id;
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static Vehice find(String id) {
        CheckException.checkCharacterNumber(id);
        Vehice vehice = null;
        open();
        String sql = "SELECT * FROM vehice WHERE license_plates like %"+id+"%";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                vehice = new Vehice(
                    result.getInt("id"),
                    result.getInt("number_of_seats"),
                    result.getInt("status"),
                    result.getString("name"),
                    result.getString("testing_date"),
                    result.getString("color"),
                    result.getString("license_plates"),
                    result.getDouble("price")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return vehice;
    }
    
    public static void editById(Vehice vehice) {
        open();
        String sql = "UPDATE vehice SET number_of_seats = "+vehice.getNumber_of_seats()+", status = "+vehice.getStatus()+", name = "+vehice.getName()+", testing_date = "+vehice.getTesting_date()+", color = "+vehice.getColor()+", license_plates = "+vehice.getLicense_plates()+", price = "+vehice.getPrice()+" WHERE id = "+vehice.getId();
        
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
}
