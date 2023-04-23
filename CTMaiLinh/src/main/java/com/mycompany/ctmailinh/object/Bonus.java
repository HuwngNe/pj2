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
public class Bonus extends Salary{
    protected int id_bonus,id_salary_bonus;
    protected double pay;
    protected String name;

    public Bonus() {
    }

    public Bonus(int id_salary_bonus, double pay, String name) {
        CheckException.checkNumberZero(id_salary_bonus);
        CheckException.checkNumberZero(pay);
        CheckException.checkCharacter(name);
        this.id_salary_bonus = id_salary_bonus;
        this.pay = pay;
        this.name = name;
    }
    
    public Bonus(int id_bonus, int id_salary_bonus, double pay, String name) {
        CheckException.checkNumberZero(id_bonus);
        CheckException.checkNumberZero(id_salary_bonus);
        CheckException.checkNumberZero(pay);
        CheckException.checkCharacter(name);
        this.id_bonus = id_bonus;
        this.id_salary_bonus = id_salary_bonus;
        this.pay = pay;
        this.name = name;
    }

    public Bonus(int id_bonus, int id_salary_bonus, double pay, String name, int id_salary, int id_employee, double salary, double overtime, double total_salary, String date) {
        super(id_salary, id_employee, salary, overtime, total_salary, date);
        CheckException.checkNumberZero(id_bonus);
        CheckException.checkNumberZero(id_salary_bonus);
        CheckException.checkNumberZero(pay);
        CheckException.checkCharacter(name);
        this.id_bonus = id_bonus;
        this.id_salary_bonus = id_salary_bonus;
        this.pay = pay;
        this.name = name;
    }

    public Bonus(int id_bonus, int id_salary_bonus, double pay, String name, int id_salary, int id_employee, double salary, double overtime, double total_salary, String date, int id, String ID_card, String fullname, String gender, String address, String phone, String birthday, String start_join) {
        super(id_salary, id_employee, salary, overtime, total_salary, date, id, ID_card, fullname, gender, address, phone, birthday, start_join);
        CheckException.checkNumberZero(id_bonus);
        CheckException.checkNumberZero(id_salary_bonus);
        CheckException.checkNumberZero(pay);
        CheckException.checkCharacter(name);
        this.id_bonus = id_bonus;
        this.id_salary_bonus = id_salary_bonus;
        this.pay = pay;
        this.name = name;
    }

    public Bonus(int id_bonus, int id_salary_bonus, double pay, String name, int id_salary, int id_employee, double salary, double overtime, double total_salary, String date, String ID_card, String fullname, String gender, String address, String phone, String birthday, String start_join) {
        super(id_salary, id_employee, salary, overtime, total_salary, date, ID_card, fullname, gender, address, phone, birthday, start_join);
        CheckException.checkNumberZero(id_bonus);
        CheckException.checkNumberZero(id_salary_bonus);
        CheckException.checkNumberZero(pay);
        CheckException.checkCharacter(name);
        this.id_bonus = id_bonus;
        this.id_salary_bonus = id_salary_bonus;
        this.pay = pay;
        this.name = name;
    }

    public int getId_bonus() {
        return id_bonus;
    }

    public void setId_bonus(int id_bonus) {
        CheckException.checkNumberZero(id_bonus);
        this.id_bonus = id_bonus;
    }

    public int getId_salary_bonus() {
        return id_salary_bonus;
    }

    public void setId_salary_bonus(int id_salary_bonus) {
        CheckException.checkNumberZero(id_salary_bonus);
        this.id_salary_bonus = id_salary_bonus;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        CheckException.checkNumberZero(pay);
        this.pay = pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        CheckException.checkCharacter(name);
        this.name = name;
    }
    
    
}
