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
public class Salary extends Employee{
    protected int id_salary,id_employee;
    protected double salary,overtime,total_salary;
    protected String date;

    public Salary() {
    }

    public Salary(int id_salary, int id_employee, double salary, double overtime, double total_salary, String date) {
        CheckException.checkNumberZero(id_salary);
        CheckException.checkNumberZero(id_employee);
        CheckException.checkNumberZero(salary);
        CheckException.checkNumberZero(total_salary);
        CheckException.checkDate(date);
        this.id_salary = id_salary;
        this.id_employee = id_employee;
        this.salary = salary;
        this.overtime = overtime;
        this.total_salary = total_salary;
        this.date = date;
    }

    public int getId_salary() {
        return id_salary;
    }

    public void setId_salary(int id_salary) {
        CheckException.checkNumberZero(id_salary);
        this.id_salary = id_salary;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        CheckException.checkNumberZero(id_employee);
        this.id_employee = id_employee;
    }

    public void setSalary(double salary) {
        CheckException.checkNumberZero(salary);
        this.salary = salary;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    public double getTotal_salary() {
        return total_salary;
    }

    public void setTotal_salary(double total_salary) {
        CheckException.checkNumberZero(total_salary);
        this.total_salary = total_salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        CheckException.checkDate(date);
        this.date = date;
    }

}
