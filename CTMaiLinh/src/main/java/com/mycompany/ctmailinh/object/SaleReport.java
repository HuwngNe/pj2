/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.object;

/**
 *
 * @author Windows
 */
public class SaleReport {
    private int id,total_hire;
    private String total_price,date;

    public SaleReport() {
    }

    public SaleReport(String total_price) {
        this.total_price = total_price;
    }

    public SaleReport(int id, int total_hire) {
        this.id = id;
        this.total_hire = total_hire;
    }

    public SaleReport(int id, int total_hire, String total_price, String date) {
        this.id = id;
        this.total_hire = total_hire;
        this.total_price = total_price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal_hire() {
        return total_hire;
    }

    public void setTotal_hire(int total_hire) {
        this.total_hire = total_hire;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
