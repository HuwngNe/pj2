/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.object.Customer;
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
public class QuerryCustomer {
    static Connection conn = null;
    static PreparedStatement statement = null;
    static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ctmailinh","root","");
        } catch (SQLException ex) {
            Logger.getLogger(QuerryCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement = null;
        conn = null;
    }
    
    public static void insert(Customer customer) {
        open();
        String sql = "insert into customer(ID_card,fullname,gender,birthday,address,phone) values ("+customer.getID_card()+","+customer.getFullname()+","+customer.getGender()+","+customer.getBirthday()+","+customer.getAddress()+","+customer.getPhone()+")";
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static int insertGetID(Customer customer) {
        open();
        String sql = "insert into customer(ID_card,fullname,gender,birthday,address,phone) values (?,?,?,?,?,?)";
        String[] returnId = { "BATCHID" };
        int key = -1;
        try {
            statement = conn.prepareStatement(sql,returnId);
            statement.setString(1, customer.getID_card());
            statement.setString(2, customer.getFullname());
            statement.setString(3, customer.getGender());
            statement.setString(4, customer.getBirthday());
            statement.setString(5, customer.getAddress());
            statement.setString(6, customer.getPhone());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuerryCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return key;
    }
    
    public static List<Customer> select() {
        List<Customer> listCustomer = new ArrayList<>();
        open();
        String sql = "SELECT * FROM customer";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Customer customer = null;
            while (result.next()) {
                customer = new Customer(
                        result.getInt("id"),
                        result.getString("fullname"),
                        result.getString("phone")
                );
                listCustomer.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listCustomer;
    }
    
    public static void delete(int id) {
        CheckException.checkNumberZero(id);
        open();
        String sql = "DELETE FROM customer WHERE id = "+id;
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static Customer find(String id) {
        CheckException.checkCharacterNumber(id);
        Customer customer = null;
        open();
        String sql = "SELECT * FROM customer WHERE id = "+id;
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                customer = new Customer(
                    result.getInt("id"),
                    result.getString("ID_card"),
                    result.getString("fullname"),
                    result.getString("gender"),
                    result.getString("address"),
                    result.getString("phone"),
                    result.getString("birthday")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return customer;
    }
    
    public static void editById(Customer customer) {
        open();
        String sql = "UPDATE customer SET ID_card = "+customer.getID_card()+", fullname = "+customer.getFullname()+", gender = "+customer.getGender()+", address = "+customer.getAddress()+", phone = "+customer.getPhone()+", birthday = "+customer.getBirthday()+" WHERE id = "+customer.getId();
        
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
}
