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
        String sql = "insert into vehice(name,testing_date,number_of_seats,color,license_plates,price,status) values (?,?,?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, vehice.getName());
            statement.setString(2, vehice.getTesting_date());
            statement.setInt(3, vehice.getNumber_of_seats());
            statement.setString(4, vehice.getColor());
            statement.setString(5, vehice.getLicense_plates());
            statement.setString(6, vehice.getPrice());
            statement.setInt(7, vehice.getStatus());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Vehice> select() {
        List<Vehice> listVehice = new ArrayList<>();
        open();
        String sql = "SELECT vehice.*, status.name as status_name FROM vehice JOIN status ON status.id = vehice.status";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Vehice vehice = null;
            while (result.next()) {
                vehice = new Vehice(
                        result.getInt("id"),
                        result.getString("status_name"),
                        result.getInt("number_of_seats"),
                        result.getString("name")
                );
                listVehice.add(vehice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listVehice;
    }
    
    public static List<Vehice> findByIdT(int a) {
        List<Vehice> listVehice = new ArrayList<>();
        open();
        String sql = "SELECT vehice.*, status.name as status_name FROM vehice JOIN status ON status.id = vehice.status WHERE vehice.id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, a);
            ResultSet result = statement.executeQuery();
            Vehice vehice = null;
            while (result.next()) {
                vehice = new Vehice(
                        result.getInt("id"),
                        result.getString("status_name"),
                        result.getInt("number_of_seats"),
                        result.getString("name")
                );
                listVehice.add(vehice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listVehice;
    }
    
    public static List<Vehice> selectStatus1() {
        List<Vehice> listVehice = new ArrayList<>();
        open();
        String sql = "SELECT vehice.*, status.name as status_name FROM vehice JOIN status ON status.id = vehice.status WHERE vehice.status = 1";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Vehice vehice = null;
            while (result.next()) {
                vehice = new Vehice(
                        result.getInt("id"),
                        result.getString("status_name"),
                        result.getInt("number_of_seats"),
                        result.getString("name")
                );
                listVehice.add(vehice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listVehice;
    }
    
    public static List<Vehice> selectStatus2() {
        List<Vehice> listVehice = new ArrayList<>();
        open();
        String sql = "SELECT vehice.*, status.name as status_name FROM vehice JOIN status ON status.id = vehice.status WHERE vehice.status = 2";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Vehice vehice = null;
            while (result.next()) {
                vehice = new Vehice(
                        result.getInt("id"),
                        result.getString("status_name"),
                        result.getInt("number_of_seats"),
                        result.getString("name")
                );
                listVehice.add(vehice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listVehice;
    }
    
    public static List<Vehice> selectSit4() {
        List<Vehice> listVehice = new ArrayList<>();
        open();
        String sql = "SELECT vehice.*, status.name as status_name FROM vehice JOIN status ON status.id = vehice.status WHERE vehice.number_of_seats = 4";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Vehice vehice = null;
            while (result.next()) {
                vehice = new Vehice(
                        result.getInt("id"),
                        result.getString("status_name"),
                        result.getInt("number_of_seats"),
                        result.getString("name")
                );
                listVehice.add(vehice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listVehice;
    }
    
    public static List<Vehice> selectSit8() {
        List<Vehice> listVehice = new ArrayList<>();
        open();
        String sql = "SELECT vehice.*, status.name as status_name FROM vehice JOIN status ON status.id = vehice.status WHERE vehice.number_of_seats = 8";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Vehice vehice = null;
            while (result.next()) {
                vehice = new Vehice(
                        result.getInt("id"),
                        result.getString("status_name"),
                        result.getInt("number_of_seats"),
                        result.getString("name")
                );
                listVehice.add(vehice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listVehice;
    }
    
    public static List<Vehice> selectSit16() {
        List<Vehice> listVehice = new ArrayList<>();
        open();
        String sql = "SELECT vehice.*, status.name as status_name FROM vehice JOIN status ON status.id = vehice.status WHERE vehice.number_of_seats = 16";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Vehice vehice = null;
            while (result.next()) {
                vehice = new Vehice(
                        result.getInt("id"),
                        result.getString("status_name"),
                        result.getInt("number_of_seats"),
                        result.getString("name")
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
        open();
        String sql = "DELETE FROM vehice WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static Vehice find(int id) {
        Vehice vehice = null;
        open();
        String sql = "SELECT * FROM vehice WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
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
                    result.getString("price")
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
        String sql = "UPDATE vehice SET number_of_seats = ?, name = ?, testing_date = ?, color = ?, license_plates = ?, price = ? WHERE id = ?";
        
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, vehice.getNumber_of_seats());
            statement.setString(2, vehice.getName());
            statement.setString(3, vehice.getTesting_date());
            statement.setString(4, vehice.getColor());
            statement.setString(5, vehice.getLicense_plates());
            statement.setString(6, vehice.getPrice());
            statement.setInt(7, vehice.getId());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static Vehice findDetail(int id) {
        Vehice vehice = null;
        open();
        String sql = "SELECT vehice.*,status.name as status_name FROM vehice JOIN status ON status.id = vehice.status WHERE vehice.id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                vehice = new Vehice(
                    result.getInt("id"),
                    result.getInt("number_of_seats"),
                    result.getString("name"),
                    result.getString("testing_date"),
                    result.getString("color"),
                    result.getString("license_plates"),
                    result.getString("price"),
                    result.getString("status_name")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return vehice;
    }
    
    public static List<Vehice> findByStatus() {
        List<Vehice> lsList = new ArrayList<>();
        Vehice vehice = null;
        open();
        String sql = "SELECT * FROM vehice WHERE status = 1";
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
                    result.getString("price")
                );
                lsList.add(vehice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return lsList;
    }
    
    public static String findReturnName(int id) {
        Vehice ve = null;
        open();
        String sql = "SELECT name FROM vehice WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                ve = new Vehice(
                    result.getString("name")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ve.getName();
    }
    
    public static String findReturnPrice(int id) {
        Vehice ve = null;
        open();
        String sql = "SELECT id,price FROM vehice WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                ve = new Vehice(
                    result.getInt("id"),
                    result.getString("price")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ve.getPrice();
    }
    
    public static void updateStatus(int id,int status){
        open();
        String sql = "UPDATE vehice SET status = ? WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, status);
            statement.setInt(2, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Vehice> findBySearch(int id) {
        List<Vehice> listVehice = new ArrayList<>();
        open();
        String sql = "SELECT vehice.*, status.name as status_name FROM vehice JOIN status ON status.id = vehice.status WHERE vehice.id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Vehice vehice = null;
            while (result.next()) {
                vehice = new Vehice(
                        result.getInt("id"),
                        result.getString("status_name"),
                        result.getInt("number_of_seats"),
                        result.getString("name")
                );
                listVehice.add(vehice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryVehice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listVehice;
    }
}
