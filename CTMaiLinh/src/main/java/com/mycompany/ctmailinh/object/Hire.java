/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.object;

import com.mycompany.ctmailinh.libraly.CheckException;

/**
 *
 * @author Admin
 */
public class Hire{
    protected int id_hire,vehice_id,employee_id,customer_id;
    protected double total_price,forfeit;
    protected String start_date,end_date;
    
    public Hire() {
        
    }

    public Hire(int id_hire, int vehice_id, int employee_id, int customer_id, double total_price, double forfeit, String start_date, String end_date) {
        CheckException.checkNumberZero(id_hire);
        CheckException.checkNumberZero(vehice_id);
        CheckException.checkNumberZero(employee_id);
        CheckException.checkNumberZero(customer_id);
        CheckException.checkNumberZero(total_price);
        CheckException.checkDateTime(start_date);
        CheckException.checkDateTime(end_date);
        this.id_hire = id_hire;
        this.vehice_id = vehice_id;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.total_price = total_price;
        this.forfeit = forfeit;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Hire(int vehice_id, int employee_id, int customer_id, double total_price, double forfeit, String start_date, String end_date) {
        CheckException.checkNumberZero(vehice_id);
        CheckException.checkNumberZero(employee_id);
        CheckException.checkNumberZero(customer_id);
        CheckException.checkNumberZero(total_price);
        CheckException.checkDateTime(start_date);
        CheckException.checkDateTime(end_date);
        this.vehice_id = vehice_id;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.total_price = total_price;
        this.forfeit = forfeit;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getId_hire() {
        return id_hire;
    }

    public void setId_hire(int id_hire) {
        CheckException.checkNumberZero(id_hire);
        this.id_hire = id_hire;
    }

    public int getVehice_id() {
        return vehice_id;
    }

    public void setVehice_id(int vehice_id) {
        CheckException.checkNumberZero(vehice_id);
        this.vehice_id = vehice_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        CheckException.checkNumberZero(employee_id);
        this.employee_id = employee_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        CheckException.checkNumberZero(customer_id);
        this.customer_id = customer_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        CheckException.checkNumberZero(total_price);
        this.total_price = total_price;
    }

    public double getForfeit() {
        return forfeit;
    }

    public void setForfeit(double forfeit) {
        this.forfeit = forfeit;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        CheckException.checkDateTime(start_date);
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        CheckException.checkDateTime(end_date);
        this.end_date = end_date;
    }
    
    public void input() {
        
    }
}
