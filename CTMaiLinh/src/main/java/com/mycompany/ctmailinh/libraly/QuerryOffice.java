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
        String sql = "insert into office(id_employee,position_id,start) values (?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, off.getId_employee());
            statement.setInt(2, Integer.parseInt(off.getPosition()));
            statement.setString(3, off.getStart());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Office> select() {
        List<Office> listOffice = new ArrayList<>();
        open();
        String sql = "SELECT employee.id,employee.ID_card,employee.fullname,employee.phone,office.id as office_id, position.name FROM office JOIN employee ON office.id_employee = employee.id JOIN position ON position.id = office.position_id";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Office office = null;
            while (result.next()) {
                office = new Office(
                        result.getInt("office_id"),
                        result.getString("name"),
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
    
    public static List<Office> select(String name) {
        List<Office> listOffice = new ArrayList<>();
        open();
        String sql = "SELECT employee.id,employee.ID_card,employee.fullname,employee.phone,office.id as office_id, position.name FROM office JOIN employee ON office.id_employee = employee.id JOIN position ON position.id = office.position_id WHERE employee.fullname LIKE ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+name+"%");
            ResultSet result = statement.executeQuery();
            Office office = null;
            while (result.next()) {
                office = new Office(
                        result.getInt("office_id"),
                        result.getString("name"),
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
        String sql = "SELECT employee.*,office.id as office_id, position.name, office.start FROM office JOIN employee ON office.id_employee = employee.id JOIN position ON position.id = office.position_id WHERE employee.id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                office = new Office(
                        result.getInt("office_id"),
                        result.getString("name"),
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
            sql = "UPDATE office SET position_id = ?, start = ? WHERE id = ?";
        } else {
            sql = "UPDATE office SET position_id = ?, start = ?, end = ? WHERE id = ?";
        }
        try {
            statement = conn.prepareStatement(sql);
            if (o.getEnd() == null){
                statement.setInt(1, Integer.parseInt(o.getPosition()));
                statement.setString(2, o.getStart());
                statement.setInt(3, o.getId_office());
            } else {
                statement.setInt(1, Integer.parseInt(o.getPosition()));
                statement.setString(2, o.getStart());
                statement.setString(3, o.getEnd());
                statement.setInt(4, o.getId_office());
            }
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Office> selectById(int id) {
        List<Office> listOffice = new ArrayList<>();
        open();
        String sql = "SELECT office.*,position.name FROM office JOIN position ON position.id = office.position_id WHERE id_employee = ? ORDER BY office.id ";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Office office = null;
            while (result.next()) {
                office = new Office(
                        result.getInt("id"),
                        result.getInt("id_employee"),
                        result.getString("name"),
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
        String sql = "DELETE FROM office WHERE id_employee = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, i);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static Office findByIdPk(int id) {
        Office office = null;
        open();
        String sql = "SELECT * FROM office WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                office = new Office(
                        result.getInt("id"),
                        result.getInt("id_employee"),
                        result.getString("position_id"),
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
        String sql = "DELETE FROM office WHERE id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QuerryOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static List<Office> selectSortPosition() {
        List<Office> listOffice = new ArrayList<>();
        open();
        String sql = "SELECT employee.id,employee.ID_card,employee.fullname,employee.phone,office.id as office_id, position.name FROM office JOIN employee ON office.id_employee = employee.id JOIN position ON position.id = office.position_id ORDER BY position.id ASC";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Office office = null;
            while (result.next()) {
                office = new Office(
                        result.getInt("office_id"),
                        result.getString("name"),
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
    
    public static List<Office> selectSortPositionDesc() {
        List<Office> listOffice = new ArrayList<>();
        open();
        String sql = "SELECT employee.id,employee.ID_card,employee.fullname,employee.phone,office.id as office_id, position.name FROM office JOIN employee ON office.id_employee = employee.id JOIN position ON position.id = office.position_id ORDER BY position.id DESC";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Office office = null;
            while (result.next()) {
                office = new Office(
                        result.getInt("office_id"),
                        result.getString("name"),
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
    
    public static List<Office> selectSortName() {
        List<Office> listOffice = new ArrayList<>();
        open();
        String sql = "SELECT employee.id,employee.ID_card,employee.fullname,employee.phone,office.id as office_id, position.name FROM office JOIN employee ON office.id_employee = employee.id JOIN position ON position.id = office.position_id ORDER BY employee.fullname ASC";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Office office = null;
            while (result.next()) {
                office = new Office(
                        result.getInt("office_id"),
                        result.getString("name"),
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
    
    public static List<Office> selectSortNameDesc() {
        List<Office> listOffice = new ArrayList<>();
        open();
        String sql = "SELECT employee.id,employee.ID_card,employee.fullname,employee.phone,office.id as office_id, position.name FROM office JOIN employee ON office.id_employee = employee.id JOIN position ON position.id = office.position_id ORDER BY employee.fullname DESC";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            Office office = null;
            while (result.next()) {
                office = new Office(
                        result.getInt("office_id"),
                        result.getString("name"),
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
}
