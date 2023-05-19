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
import java.util.ArrayList;
import java.util.List;
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
    
    public static void insert(Employee e) {
        open();
        String sql = "insert into employee(ID_card,fullname,gender,birthday,address,phone,salary) values (?,?,?,?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, e.getID_card());
            statement.setString(2, e.getFullname());
            statement.setString(3, e.getGender());
            statement.setString(4, e.getBirthday());
            statement.setString(5, e.getAddress());
            statement.setString(6, e.getPhone());
            statement.setString(7, e.getSalary());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static int insertGetId(Employee e) {
        open();
        String sql = "insert into employee(ID_card,fullname,gender,birthday,address,phone,salary) values (?,?,?,?,?,?,?)";
        String[] returnId = { "BATCHID" };
        int key = -1;
        try {
            statement = conn.prepareStatement(sql,returnId);
            statement.setString(1, e.getID_card());
            statement.setString(2, e.getFullname());
            statement.setString(3, e.getGender());
            statement.setString(4, e.getBirthday());
            statement.setString(5, e.getAddress());
            statement.setString(6, e.getPhone());
            statement.setString(7, e.getSalary());
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
        String sql = "DELETE FROM employee WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void update(Employee e,int id) {
        open();
        String sql = "UPDATE employee SET ID_card = ?, fullname = ?, gender = ?, birthday = ?, address = ?, phone = ?, salary = ? WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, e.getID_card());
            statement.setString(2, e.getFullname());
            statement.setString(3, e.getGender());
            statement.setString(4, e.getBirthday());
            statement.setString(5, e.getAddress());
            statement.setString(6, e.getPhone());
            statement.setString(7, e.getSalary());
            statement.setInt(8, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static Employee findById(int id) {
        Employee employee = new Employee();
        open();
        String sql = "SELECT * FROM employee WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
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
        String sql = "SELECT salary FROM employee WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, i);
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
    
    public static void update(Employee e) {
        open();
        String sql = "UPDATE employee SET ID_card = ?, fullname = ?, gender = ?, birthday = ?, address = ?, phone = ? WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, e.getID_card());
            statement.setString(2, e.getFullname());
            statement.setString(3, e.getGender());
            statement.setString(4, e.getBirthday());
            statement.setString(5, e.getAddress());
            statement.setString(6, e.getPhone());
            statement.setInt(7, e.getId());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Employee> selectDriver() {
        List<Employee> ls = new ArrayList<>();
        Employee employee = null;
        open();
        String sql = "SELECT employee.fullname, employee.id FROM employee JOIN office ON office.id_employee = employee.id WHERE office.position_id = 4 AND employee.status_id = 1";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                employee = new Employee(
                    result.getInt("id"),
                    result.getString("fullname")
                );
                ls.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
    
    public static String findReturnName(int id) {
        Employee employee = null;
        open();
        String sql = "SELECT id,fullname FROM employee WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                employee = new Employee(
                    result.getInt("id"),
                    result.getString("fullname")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return employee.getFullname();
    }
    
    public static List<Employee> select() {
        List<Employee> ls = new ArrayList<>();
        Employee employee = null;
        open();
        String sql = "SELECT employee.fullname, employee.id FROM employee";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                employee = new Employee(
                    result.getInt("id"),
                    result.getString("fullname")
                );
                ls.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return ls;
    }
}
