/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.object.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author Windows
 */
public class QuerryAccount {
    static Connection conn = null;
    static PreparedStatement statement = null;
    static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ctmailinh","root","");
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement = null;
        conn = null;
    }
    
    public static Account find(Account a) {
        Account account = null;
        open();
        String pass = DigestUtils.md5Hex(a.getPassword());
        System.out.println(pass);
        String sql = "SELECT * FROM account WHERE username LIKE '"+a.getUsername()+"' AND password LIKE '"+pass+"'";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getString("username"),
                    result.getString("password"),
                    result.getInt("id"),                    
                    result.getInt("permission_id")              
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return account;
    }
    
    public static void insert(Account a){
        String pass = DigestUtils.md5Hex(a.getPassword());
        open();
        String sql = "INSERT INTO account(customer_id,username,password) VALUES (?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, a.getCustomer_id());
            statement.setString(2, a.getUsername());
            statement.setString(3, pass);
            int check = statement.executeUpdate();
            if (check == 1) {
                System.out.println("tc");
            } else {
                System.out.println("tb");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
}
