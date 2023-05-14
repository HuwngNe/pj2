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
    protected String name,pay;

    public Bonus() {
    }

    
    public Bonus(int id_salary_bonus, String pay, String name) {
        CheckException.checkNumberZero(id_salary_bonus);
        CheckException.checkCharacterNumber(pay);
        CheckException.checkCharacter(name);
        this.id_salary_bonus = id_salary_bonus;
        this.pay = pay;
        this.name = name;
    }
    
    public Bonus(int id_bonus, int id_salary_bonus, String pay, String name) {
        CheckException.checkNumberZero(id_bonus);
        CheckException.checkNumberZero(id_salary_bonus);
        CheckException.checkCharacterNumber(pay);
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

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        CheckException.checkCharacterNumber(pay);
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
