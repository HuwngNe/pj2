/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.object.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class QuerryEmployee {
    static Connection conn = null;
    static PreparedStatement statement = null;
    static void open() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ctmailinh","root","");
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement = null;
        conn = null;
    }
    
    public static void insert(Employee employee) {
        open();
        String sql = "insert into employee(ID_card,fullname,gender,birthday,address,phone,salary) values ('"+employee.getID_card()+"','"+employee.getFullname()+"','"+employee.getGender()+"','"+employee.getBirthday()+"','"+employee.getAddress()+"','"+employee.getPhone()+"','"+employee.getSalary()+"')";
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static int insertGetId(Employee employee) {
        open();
        String sql = "insert into employee(ID_card,fullname,gender,birthday,address,phone,salary) values ('"+employee.getID_card()+"','"+employee.getFullname()+"','"+employee.getGender()+"','"+employee.getBirthday()+"','"+employee.getAddress()+"','"+employee.getPhone()+"','"+employee.getSalary()+"')";
        String[] returnId = { "BATCHID" };
        int key = -1;
        try {
            statement = conn.prepareStatement(sql,returnId);
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return key;
    }
    
    public static void delete(int id) {
        CheckException.checkNumberZero(id);
        open();
        String sql = "DELETE FROM employee WHERE id = "+id;
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void update(Employee e,int id) {
        open();
        String sql = "UPDATE employee SET ID_card = '"+e.getID_card()+"', fullname = '"+e.getFullname()+"', gender = '"+e.getGender()+"', birthday = '"+e.getBirthday()+"', address = '"+e.getAddress()+"', phone = '"+e.getPhone()+"', salary = '"+e.getSalary()+"' WHERE id = "+id;
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static Employee findById(int id) {
        Employee employee = new Employee();
        open();
        String sql = "SELECT * FROM employee WHERE id = "+id;
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                employee = new Employee(
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
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return employee;
    }
    
    public static String selectSalary(int i) {
        Employee employee = new Employee();
        open();
        String sql = "SELECT salary FROM employee WHERE id = "+i;
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                employee = new Employee(
                        result.getString("salary")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return employee.getSalary();
    }
}
