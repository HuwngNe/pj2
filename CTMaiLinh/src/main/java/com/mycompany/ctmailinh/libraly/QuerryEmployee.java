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
    
    public static void insert(Employee employee) {
        open();
        String sql = "insert into employee(ID_card,fullname,gender,birthday,address,phone,start_join) values ("+employee.getID_card()+","+employee.getFullname()+","+employee.getGender()+","+employee.getBirthday()+","+employee.getAddress()+","+employee.getPhone()+","+employee.getStart_join()+")";
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Employee> select() {
        List<Employee> listEmployee = new ArrayList<>();
        open();
        String sql = "SELECT * FROM employee";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Employee employee = null;
            while (result.next()) {
                employee = new Employee(
                        result.getInt("id"),
                        result.getString("ID_card"),
                        result.getString("fullname"),
                        result.getString("gender"),
                        result.getString("address"),
                        result.getString("phone"),
                        result.getString("birthday"),
                        result.getString("start_join")
                );
                listEmployee.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return listEmployee;
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
    
    public static Employee find(String id) {
        CheckException.checkCharacterNumber(id);
        Employee employee = null;
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
                    result.getString("start_join")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
        return employee;
    }
    
    public static void editById(Employee employee) {
        open();
        String sql = "UPDATE customer SET ID_card = "+employee.getID_card()+", fullname = "+employee.getFullname()+", gender = "+employee.getGender()+", address = "+employee.getAddress()+", phone = "+employee.getPhone()+", birthday = "+employee.getBirthday()+", start_join = "+employee.getStart_join()+" WHERE id = "+employee.getId();
        
        try {
            statement = conn.prepareStatement(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
}
