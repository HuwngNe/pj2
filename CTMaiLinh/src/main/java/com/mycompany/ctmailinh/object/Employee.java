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
    protected String ID_card,fullname,gender,address,phone,birthday,salary;

    public Employee() {
    }

    public Employee(int id, String ID_card, String fullname, String phone) {
        CheckException.checkNumberZero(id);
        CheckException.checkNumber(ID_card);
        CheckException.checkCharacter(fullname);
        CheckException.checkPhone(phone);
        this.id = id;
        this.ID_card = ID_card;
        this.fullname = fullname;
        this.phone = phone;
    }

    public Employee(int id, String ID_card, String fullname, String gender, String address, String phone, String birthday, String salary) {
        this.id = id;
        this.ID_card = ID_card;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
        this.salary = salary;
    }
    
    public Employee(int id, String ID_card, String fullname, String phone,String salary) {
        CheckException.checkNumberZero(id);
        CheckException.checkNumber(ID_card);
        CheckException.checkCharacter(fullname);
        CheckException.checkPhone(phone);
        CheckException.checkNumber(salary);
        this.id = id;
        this.ID_card = ID_card;
        this.fullname = fullname;
        this.phone = phone;
        this.salary = salary;
    }

    public Employee(String ID_card, String fullname, String gender, String address, String phone, String birthday) {
        CheckException.checkNumber(ID_card);
        CheckException.checkCharacter(fullname);
        CheckException.checkGender(gender);
        CheckException.checkPhone(phone);
        CheckException.checkDate(birthday);
        this.ID_card = ID_card;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    @Override
    public String toString() {
        return "Employee{" + ", ID_card=" + ID_card + ", fullname=" + fullname + ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", birthday=" + birthday + ", salary=" + salary + '}';
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
        
    }
}
