/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.object;

import com.mycompany.ctmailinh.libraly.CheckException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class WorkDay extends Employee{
    protected int id_workday,employee_id;
    protected double total_price_date;
    protected String time_start,time_end;

    public WorkDay() {
    }

    public WorkDay(int id, String ID_card, String fullname, String gender, String address, String phone, String birthday, String start_join,int id_workday, int employee_id, double total_price_date, String time_start, String time_end) {
        super.setId(id);
        super.setID_card(ID_card);
        super.setFullname(fullname);
        super.setGender(gender);
        super.setAddress(address);
        super.setPhone(phone);
        super.setBirthday(birthday);
        super.setStart_join(start_join);
        CheckException.checkNumberZero(id_workday);
        CheckException.checkNumberZero(employee_id);
        CheckException.checkNumberZero(total_price_date);
        CheckException.checkDateTime(time_start);
        CheckException.checkDateTime(time_end);
        this.id_workday = id_workday;
        this.employee_id = employee_id;
        this.total_price_date = total_price_date;
        this.time_start = time_start;
        this.time_end = time_end;
    }

    public WorkDay(int id, String ID_card, String fullname, String gender, String address, String phone, String birthday, String start_join,int employee_id, double total_price_date, String time_start, String time_end) {
        super.setId(id);
        super.setID_card(ID_card);
        super.setFullname(fullname);
        super.setGender(gender);
        super.setAddress(address);
        super.setPhone(phone);
        super.setBirthday(birthday);
        super.setStart_join(start_join);
        CheckException.checkNumberZero(employee_id);
        CheckException.checkNumberZero(total_price_date);
        CheckException.checkDateTime(time_start);
        CheckException.checkDateTime(time_end);
        this.employee_id = employee_id;
        this.total_price_date = total_price_date;
        this.time_start = time_start;
        this.time_end = time_end;
    }

    public int getId_workday() {
        return id_workday;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        CheckException.checkNumberZero(employee_id);
        this.employee_id = employee_id;
    }

    public double getTotal_price_date() {
        return total_price_date;
    }

    public void setTotal_price_date(double total_price_date) {
        CheckException.checkNumberZero(total_price_date);
        this.total_price_date = total_price_date;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        CheckException.checkDateTime(time_start);
        this.time_start = time_start;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        CheckException.checkDateTime(time_end);
        this.time_end = time_end;
    }
    
    @Override
    public void input(){
        super.input();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter id employee:");
        employee_id = Integer.parseInt(sc.nextLine());
        CheckException.checkNumberZero(employee_id);
        
        System.out.println("Enter total price on the date");
        total_price_date = Double.parseDouble(sc.nextLine());
        CheckException.checkNumberZero(total_price_date);
        
        System.out.println("Enter start (dd-mm-YYYY HH:ii:ss)");
        time_start = sc.nextLine();
        CheckException.checkDateTime(time_start);
        
        System.out.println("Enter end (dd-mm-YYYY HH:ii:ss)");
        time_end = sc.nextLine();
        CheckException.checkDateTime(time_end);
        
    }

    @Override
    public String toString() {
        return super.toString()+"id_workday=" + id_workday + ", employee_id=" + employee_id + ", total_price_date=" + total_price_date + ", time_start=" + time_start + ", time_end=" + time_end;
    }
    
    
}
