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
public class Office extends WorkDay{
    protected int id_office,id_workday_office;
    protected String position,start,end;

    public Office() {
    }

    public Office(int id_office, int id_workday_office, String position, String start, String end) {
        CheckException.checkNumberZero(id_office);
        CheckException.checkNumberZero(id_workday_office);
        CheckException.checkCharacter(position);
        CheckException.checkDate(start);
        CheckException.checkDate(end);
        this.id_office = id_office;
        this.id_workday_office = id_workday_office;
        this.position = position;
        this.start = start;
        this.end = end;
    }

    public Office(int id_office, int id_workday_office, String position, String start, String end, int id, String ID_card, String fullname, String gender, String address, String phone, String birthday, String start_join, int id_workday, int employee_id, double total_price_date, String time_start, String time_end) {
        super(id, ID_card, fullname, gender, address, phone, birthday, start_join, id_workday, employee_id, total_price_date, time_start, time_end);
        CheckException.checkNumberZero(id_office);
        CheckException.checkNumberZero(id_workday_office);
        CheckException.checkCharacter(position);
        CheckException.checkDate(start);
        CheckException.checkDate(end);
        this.id_office = id_office;
        this.id_workday_office = id_workday_office;
        this.position = position;
        this.start = start;
        this.end = end;
    }

    public Office(int id_office, int id_workday_office, String position, String start, String end, int id, String ID_card, String fullname, String gender, String address, String phone, String birthday, String start_join, int employee_id, double total_price_date, String time_start, String time_end) {
        super(id, ID_card, fullname, gender, address, phone, birthday, start_join, employee_id, total_price_date, time_start, time_end);
        CheckException.checkNumberZero(id_office);
        CheckException.checkNumberZero(id_workday_office);
        CheckException.checkCharacter(position);
        CheckException.checkDate(start);
        CheckException.checkDate(end);
        this.id_office = id_office;
        this.id_workday_office = id_workday_office;
        this.position = position;
        this.start = start;
        this.end = end;
    }
    
    public int getId_office() {
        return id_office;
    }

    public void setId_office(int id_office) {
        CheckException.checkNumberZero(id_office);
        this.id_office = id_office;
    }

    public int getId_workday_office() {
        return id_workday_office;
    }

    public void setId_workday_office(int id_workday_office) {
        CheckException.checkNumberZero(id_workday_office);
        this.id_workday_office = id_workday_office;
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
