/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.object.Salary;
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
public class QuerrySalary {
    static Connection conn = null;
    static PreparedStatement statement = null;
    static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ctmailinh","root","");
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySalary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerrySalary.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerrySalary.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement = null;
        conn = null;
    }
    
    public static List<Salary> selectById(int id) {
        List<Salary> lsSalary = new ArrayList<>();
        open();
        String sql = "SELECT * FROM salary WHERE id_employee = "+id;
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Salary salary = null;
            while (result.next()) {
                salary = new Salary(
                        result.getInt("id"),
                        result.getInt("id_employee"),
                        result.getString("date"),
                        result.getString("overtime"),
                        result.getString("total_salary")
                );
                lsSalary.add(salary);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySalary.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return lsSalary;
    }
    
    public static void insert(Salary s) {
        open();
        String sql = "insert into salary(id_employee,overtime,date,total_salary) values ("+s.getId_employee()+",'"+s.getOvertime()+"','"+s.getDate()+"','"+s.getTotal_salary()+"')";
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySalary.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static Salary findById(int id) {
        Salary salary = null;
        open();
        String sql = "SELECT * FROM salary WHERE id = "+id;
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                salary = new Salary(
                        result.getInt("id"),
                        result.getInt("id_employee"),
                        result.getString("date"),
                        result.getString("overtime"),
                        result.getString("total_salary")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySalary.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return salary;
    }
    
    public static void update(Salary s) {
        open();
        String sql = "UPDATE salary SET overtime = '"+s.getOvertime()+"', date = '"+s.getDate()+"', total_salary = '"+s.getTotal_salary()+"' WHERE id = "+s.getId_salary();
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySalary.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void delete(int id) {
        open();
        String sql = "DELETE FROM salary WHERE id = "+id;
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySalary.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void updateTotal(String total,int id) {
        open();
        String sql = "UPDATE salary SET total_salary = '"+total+"' WHERE id = "+id;
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerrySalary.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
}
