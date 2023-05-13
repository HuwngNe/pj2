/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.object;

import com.mycompany.ctmailinh.libraly.CheckException;

/**
 *
 * @author Windows
 */
public class Account {
    private String username,password;
    private int id,employee_id,customer_id,permission_id;

    public Account() {
    }

    public Account(String username, int id) {
        this.username = username;
        this.id = id;
    }

    
    public Account(String username, String password, int id,int permission_id) {
        this.username = username;
        this.password = password;
        this.id = id;        
        this.permission_id = permission_id;
    }

    public Account(String username, String password) {
        CheckException.checkCharacter(username);
        this.username = username;
        this.password = password;
    }

    
    public Account(String username, String password, int id, int employee_id, int customer_id) {
        CheckException.checkCharacter(username);
        this.username = username;
        this.password = password;
        this.id = id;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        CheckException.checkCharacter(username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", id=" + id+ '}';
    }
    
}
