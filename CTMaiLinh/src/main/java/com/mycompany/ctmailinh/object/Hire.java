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
    protected int id_hire,vehice_id,employee_id,customer_id,status_hire_id,status_correct_id,status_payment_id,account_correct_id;
    protected String start_date,end_date,total_price,nameHire,namePayment,nameCorr,nameVehi,nameEploy,nameCus;
    
    public Hire() {
        
    }
    public Hire(int id_hire) {
        this.id_hire = id_hire;
    }

    public Hire(int id_hire, String total_price) {
        this.id_hire = id_hire;
        this.total_price = total_price;
    }

    public Hire(int id_hire, int vehice_id, int employee_id, int customer_id, int status_hire_id, int status_correct_id, int status_payment_id, String start_date, String end_date, String total_price, String nameHire, String namePayment, String nameCorr, String nameVehi, String nameEploy, String nameCus) {
        this.id_hire = id_hire;
        this.vehice_id = vehice_id;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.status_hire_id = status_hire_id;
        this.status_correct_id = status_correct_id;
        this.status_payment_id = status_payment_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.total_price = total_price;
        this.nameHire = nameHire;
        this.namePayment = namePayment;
        this.nameCorr = nameCorr;
        this.nameVehi = nameVehi;
        this.nameEploy = nameEploy;
        this.nameCus = nameCus;
    }

    public Hire(int vehice_id, int employee_id, int customer_id, String start_date, String end_date, String nameHire, String namePayment, String nameCorr, String nameVehi, String nameEploy, String nameCus) {
        this.vehice_id = vehice_id;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.nameHire = nameHire;
        this.namePayment = namePayment;
        this.nameCorr = nameCorr;
        this.nameVehi = nameVehi;
        this.nameEploy = nameEploy;
        this.nameCus = nameCus;
    }

    public Hire(int vehice_id, int customer_id, String start_date, String end_date, String nameHire, String namePayment, String nameCorr, String nameVehi, String nameCus) {
        this.vehice_id = vehice_id;
        this.customer_id = customer_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.nameHire = nameHire;
        this.namePayment = namePayment;
        this.nameCorr = nameCorr;
        this.nameVehi = nameVehi;
        this.nameCus = nameCus;
    }

    public Hire(int id_hire, int vehice_id, String start_date, String end_date, String nameHire, String namePayment, String nameCorr, String nameVehi) {
        this.id_hire = id_hire;
        this.vehice_id = vehice_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.nameHire = nameHire;
        this.namePayment = namePayment;
        this.nameCorr = nameCorr;
        this.nameVehi = nameVehi;
    }

    public Hire(int id_hire, int vehice_id, int employee_id, String start_date, String end_date, String nameHire, String namePayment, String nameCorr, String nameVehi, String nameEploy) {
        this.id_hire = id_hire;
        this.vehice_id = vehice_id;
        this.employee_id = employee_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.nameHire = nameHire;
        this.namePayment = namePayment;
        this.nameCorr = nameCorr;
        this.nameVehi = nameVehi;
        this.nameEploy = nameEploy;
    }

    public Hire(int id_hire, int vehice_id, int employee_id, String start_date) {
        this.id_hire = id_hire;
        this.vehice_id = vehice_id;
        this.employee_id = employee_id;
        this.start_date = start_date;
    }

    public Hire(int id_hire, int status_correct_id, String nameHire, String namePayment) {
        this.id_hire = id_hire;
        this.status_correct_id = status_correct_id;
        this.nameHire = nameHire;
        this.namePayment = namePayment;
    }

    public Hire(int id_hire, int status_correct_id, String start_date, String nameHire, String namePayment) {
        this.id_hire = id_hire;
        this.status_correct_id = status_correct_id;
        this.start_date = start_date;
        this.nameHire = nameHire;
        this.namePayment = namePayment;
    }

    

    public Hire(int id_hire, String nameHire, String namePayment) {
        this.id_hire = id_hire;
        this.nameHire = nameHire;
        this.namePayment = namePayment;
    }

    public String getNameCorr() {
        return nameCorr;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public void setNameCorr(String nameCorr) {
        this.nameCorr = nameCorr;
    }

    public String getNameVehi() {
        return nameVehi;
    }

    public void setNameVehi(String nameVehi) {
        this.nameVehi = nameVehi;
    }

    public String getNameEploy() {
        return nameEploy;
    }

    public void setNameEploy(String nameEploy) {
        this.nameEploy = nameEploy;
    }

    public int getAccount_correct_id() {
        return account_correct_id;
    }

    public void setAccount_correct_id(int account_correct_id) {
        this.account_correct_id = account_correct_id;
    }

    public String getNameHire() {
        return nameHire;
    }

    public void setNameHire(String nameHire) {
        this.nameHire = nameHire;
    }

    public String getNamePayment() {
        return namePayment;
    }

    public void setNamePayment(String namePayment) {
        this.namePayment = namePayment;
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

    public int getStatus_hire_id() {
        return status_hire_id;
    }

    public void setStatus_hire_id(int status_hire_id) {
        this.status_hire_id = status_hire_id;
    }

    public int getStatus_correct_id() {
        return status_correct_id;
    }

    public void setStatus_correct_id(int status_correct_id) {
        this.status_correct_id = status_correct_id;
    }

    public int getStatus_payment_id() {
        return status_payment_id;
    }

    public void setStatus_payment_id(int status_payment_id) {
        this.status_payment_id = status_payment_id;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
    
    public void input() {
        
    }
}
