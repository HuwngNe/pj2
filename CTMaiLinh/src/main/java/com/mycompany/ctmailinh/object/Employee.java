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
public class Employee {
    protected int id;
    protected String ID_card,fullname,gender,address,phone,birthday,start_join;

    public Employee() {
    }

    public Employee(int id, String ID_card, String fullname, String gender, String address, String phone, String birthday, String start_join) {
        CheckException.checkNumberZero(id);
        CheckException.checkNumber(ID_card);
        CheckException.checkCharacter(fullname);
        CheckException.checkGender(gender);
        CheckException.checkPhone(phone);
        CheckException.checkDate(birthday);
        CheckException.checkDate(start_join);
        this.id = id;
        this.ID_card = ID_card;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
        this.start_join = start_join;
    }

    public Employee(String ID_card, String fullname, String gender, String address, String phone, String birthday, String start_join) {
        CheckException.checkNumber(ID_card);
        CheckException.checkCharacter(fullname);
        CheckException.checkGender(gender);
        CheckException.checkPhone(phone);
        CheckException.checkDate(birthday);
        CheckException.checkDate(start_join);
        this.ID_card = ID_card;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
        this.start_join = start_join;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        CheckException.checkNumberZero(id);
        this.id = id;
    }

    public String getID_card() {
        return ID_card;
    }

    public void setID_card(String ID_card) {
        CheckException.checkNumber(ID_card);
        this.ID_card = ID_card;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        CheckException.checkCharacter(fullname);
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        CheckException.checkGender(gender);
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        CheckException.checkPhone(phone);
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        CheckException.checkDate(birthday);
        this.birthday = birthday;
    }

    public String getStart_join() {
        return start_join;
    }

    public void setStart_join(String start_join) {
        CheckException.checkDate(start_join);
        this.start_join = start_join;
    }

    @Override
    public String toString() {
        return "id=" + id + ", ID_card=" + ID_card + ", fullname=" + fullname + ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", birthday=" + birthday + ", start_join=" + start_join;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter CCCD or CMND:");
        ID_card = sc.nextLine();
        CheckException.checkNumber(ID_card);
        
        System.out.println("Employee's name");
        fullname = sc.nextLine();
        CheckException.checkCharacter(fullname);
        
        System.out.println("Gender:");
        gender = sc.nextLine();
        CheckException.checkGender(gender);
        
        System.out.println("Address:");
        address = sc.nextLine();
        
        System.out.println("Phone:");
        phone = sc.nextLine();
        CheckException.checkPhone(phone);
        
        System.out.println("Birthday (dd-mm-YYYY):");
        birthday = sc.nextLine();
        CheckException.checkDate(birthday);
        
        System.out.println("Start job (dd-mm-YYYY):");
        start_join = sc.nextLine();
        CheckException.checkDate(start_join);
    }
}
