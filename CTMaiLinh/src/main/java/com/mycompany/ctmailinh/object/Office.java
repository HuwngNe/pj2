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
public class Office extends Employee{
    protected int id_office,id_employee;
    protected String position,start,end;

    public Office() {
    }

    public Office(int id_office, int id_employee, String position, String start, String end) {
        this.id_office = id_office;
        this.id_employee = id_employee;
        this.position = position;
        this.start = start;
        this.end = end;
    }

    public Office(int id_office, String position, int id, String ID_card, String fullname, String phone) {
        super(id, ID_card, fullname, phone);
        CheckException.checkNumberZero(id_office);
        CheckException.checkCharacter(position);
        this.id_office = id_office;
        this.position = position;
    }

    public Office(int id_office, String position,String start,int id, String ID_card, String fullname, String gender, String address, String phone, String birthday, String salary) {
        super(id, ID_card, fullname, gender, address, phone, birthday, salary);
        CheckException.checkNumberZero(id_office);
        CheckException.checkCharacter(position);
        this.id_office = id_office;
        this.position = position;
        this.start = start;
    }

    public Office(int id_office, String position, int id, String ID_card, String fullname, String phone,String salary) {
        super(id, ID_card, fullname, phone,salary);
        CheckException.checkNumberZero(id_office);
        CheckException.checkCharacter(position);
        this.id_office = id_office;
        this.position = position;
    }

    public int getId_office() {
        return id_office;
    }

    public void setId_office(int id_office) {
        CheckException.checkNumberZero(id_office);
        this.id_office = id_office;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        CheckException.checkCharacter(position);
        this.position = position;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        CheckException.checkDate(start);
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        CheckException.checkDate(end);
        this.end = end;
    }
}
