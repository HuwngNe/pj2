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
import java.util.ArrayList;
import java.util.List;
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
        String sql = "SELECT * FROM account WHERE username LIKE ? AND password LIKE ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, a.getUsername());
            statement.setString(2, pass);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getString("username"),
                    result.getString("password"),
                    result.getInt("id"), 
                    result.getInt("employee_id"),   
                    result.getInt("customer_id"),   
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
    
    public static int findById(int id) {
        Account account = null;
        open();
        String sql = "SELECT permission_id FROM account WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getInt("permission_id")              
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return account.getPermission_id();
    }
    
    public static String findByIdFull(int id) {
        Account account = null;
        open();
        String sql = "SELECT username FROM account WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getString("username")              
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return account.getUsername();
    }
    
    public static void insert(Account a){
        String pass = DigestUtils.md5Hex(a.getPassword());
        open();
        String sql = "INSERT INTO account(customer_id,username,password,permission_id) VALUES (?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, a.getCustomer_id());
            statement.setString(2, a.getUsername());
            statement.setString(3, pass);
            statement.setInt(4, a.getPermission_id());
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
    
    public static boolean CheckPass(String pass,int id) {
        pass = DigestUtils.md5Hex(pass);
        Account account = null;
        open();
        String sql = "SELECT username FROM account WHERE id = ? AND password like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, pass);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getString("username")              
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return account != null;
    }
    
    public static void updatePass(String pass,int id) {
        pass = DigestUtils.md5Hex(pass);
        open();
        String sql = "UPDATE account SET password = ? WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, pass);
            statement.setInt(2, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static Account findByIdFk(int id) {
        Account account = null;
        open();
        String sql = "SELECT id,customer_id,employee_id FROM account WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getInt("id"),      
                    result.getInt("customer_id"),
                    result.getInt("employee_id")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return account;
    }
    
    public static void delete(int id) {
        open();
        String sql = "DELETE FROM account WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void deleteByIdCus(int id) {
        open();
        String sql = "DELETE FROM account WHERE customer_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void deleteByIdEmp(int id) {
        open();
        String sql = "DELETE FROM account WHERE employee_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Account> selectCus() {
        List<Account> ls = new ArrayList<>();
        Account account = null;
        open();
        String sql = "SELECT id,username,customer_id FROM account WHERE customer_id NOT LIKE 'NULL'";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getString("username"),
                    result.getInt("id"),
                    result.getInt("customer_id")
                );
                ls.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static boolean findAcc(String a) {
        Account account = null;
        open();
        String sql = "SELECT id,username,customer_id FROM account WHERE username LIKE ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, a);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getString("username"),
                    result.getInt("id"),
                    result.getInt("customer_id")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return account != null;
    }
    
    public static List<Account> findID(int a) {
        List<Account> ls = new ArrayList<>();
        Account account = null;
        open();
        String sql = "SELECT id,username,customer_id FROM account WHERE id = ? AND customer_id NOT LIKE 'NULL'";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, a);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getString("username"),
                    result.getInt("id"),
                    result.getInt("customer_id")
                );
                ls.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static List<Account> findIDName(String a) {
        List<Account> ls = new ArrayList<>();
        Account account = null;
        open();
        String sql = "SELECT id,username,customer_id FROM account WHERE username LIKE ? AND customer_id NOT LIKE 'NULL'";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, a);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getString("username"),
                    result.getInt("id"),
                    result.getInt("customer_id")
                );
                ls.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static List<Account> findIDNV(int a) {
        List<Account> ls = new ArrayList<>();
        Account account = null;
        open();
        String sql = "SELECT id,username,employee_id,permission_id FROM account WHERE id = ? AND employee_id NOT LIKE 'NULL'";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, a);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getString("username"),
                    result.getInt("id"),
                    result.getInt("employee_id"),
                    result.getInt("permission_id")   
                );
                ls.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static List<Account> findIDNameNV(String a) {
        List<Account> ls = new ArrayList<>();
        Account account = null;
        open();
        String sql = "SELECT id,username,employee_id,permission_id FROM account WHERE username LIKE ? AND employee_id NOT LIKE 'NULL'";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, a);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getString("username"),
                    result.getInt("id"),
                    result.getInt("employee_id"),
                    result.getInt("permission_id")  
                );
                ls.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static List<Account> selectEmp() {
        List<Account> ls = new ArrayList<>();
        Account account = null;
        open();
        String sql = "SELECT id,username,employee_id,permission_id FROM account WHERE employee_id NOT LIKE 'NULL'";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getString("username"),
                    result.getInt("id"),
                    result.getInt("employee_id"),
                    result.getInt("permission_id")  
                );
                ls.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static boolean findAcc(int a) {
        Account account = null;
        open();
        String sql = "SELECT id,username,customer_id FROM account WHERE employee_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, a);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                account = new Account(
                    result.getString("username"),
                    result.getInt("id"),
                    result.getInt("customer_id")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return account != null;
    }
    
    public static void insertEmp(Account a){
        String pass = DigestUtils.md5Hex(a.getPassword());
        open();
        String sql = "INSERT INTO account(employee_id,username,password,permission_id) VALUES (?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, a.getEmployee_id());
            statement.setString(2, a.getUsername());
            statement.setString(3, pass);
            statement.setInt(4, a.getPermission_id());
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
