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
    protected String date,overtime,total_salary;

    public Salary() {
    }

    public Salary(int id_salary, int id_employee, String date, String overtime, String total_salary) {
        this.id_salary = id_salary;
        this.id_employee = id_employee;
        this.date = date;
        this.overtime = overtime;
        this.total_salary = total_salary;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        CheckException.checkCharacterNumber(salary);
        this.salary = salary;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        CheckException.checkCharacterNumber(overtime);
        this.overtime = overtime;
    }

    public String getTotal_salary() {
        return total_salary;
    }

    public void setTotal_salary(String total_salary) {
        CheckException.checkCharacterNumber(total_salary);
        this.total_salary = total_salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        CheckException.checkDate(date);
        this.date = date;
    }

    @Override
    public String toString() {
        return "Salary{" + "id_salary=" + id_salary + ", id_employee=" + id_employee + ", date=" + date + ", overtime=" + overtime + ", total_salary=" + total_salary + '}';
    }

    
}
