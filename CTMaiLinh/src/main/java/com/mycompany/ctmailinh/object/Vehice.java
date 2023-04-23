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
public class Vehice {
    protected int id,number_of_seats,status;
    protected String name,testing_date,color,license_plates;
    protected double price;

    public Vehice() {
    }

    public Vehice(int id, int number_of_seats, int status, String name, String testing_date, String color, String license_plates, double price) {
        CheckException.checkNumberZero(id);
        CheckException.checkNumberZero(number_of_seats);
        CheckException.checkStatus(status);
        CheckException.checkCharacterNumber(name);
        CheckException.checkDate(testing_date);
        CheckException.checkCharacter(color);
        CheckException.checkCharacterNumber(license_plates);
        CheckException.checkNumberZero(price);
        this.id = id;
        this.number_of_seats = number_of_seats;
        this.status = status;
        this.name = name;
        this.testing_date = testing_date;
        this.color = color;
        this.license_plates = license_plates;
        this.price = price;
    }

    public Vehice(int number_of_seats, int status, String name, String testing_date, String color, String license_plates, double price) {
        CheckException.checkNumberZero(number_of_seats);
        CheckException.checkStatus(status);
        CheckException.checkCharacterNumber(name);
        CheckException.checkDate(testing_date);
        CheckException.checkCharacter(color);
        CheckException.checkCharacterNumber(license_plates);
        CheckException.checkNumberZero(price);
        this.number_of_seats = number_of_seats;
        this.status = status;
        this.name = name;
        this.testing_date = testing_date;
        this.color = color;
        this.license_plates = license_plates;
        this.price = price;
    }
    
    
    
    public int getId() {
        return id;
    }

    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(int number_of_seats) {
        CheckException.checkNumberZero(number_of_seats);
        this.number_of_seats = number_of_seats;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        CheckException.checkStatus(status);
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        CheckException.checkCharacterNumber(name);
        this.name = name;
    }

    public String getTesting_date() {
        return testing_date;
    }

    public void setTesting_date(String testing_date) {
        CheckException.checkDate(testing_date);
        this.testing_date = testing_date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        CheckException.checkCharacter(color);
        this.color = color;
    }

    public String getLicense_plates() {
        return license_plates;
    }

    public void setLicense_plates(String license_plates) {
        CheckException.checkCharacterNumber(license_plates);
        this.license_plates = license_plates;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        CheckException.checkNumberZero(price);
        this.price = price;
    }
    
    public void input() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the car's name:");
        name = sc.nextLine();
        CheckException.checkCharacterNumber(name);
        
        System.out.println("Inspection date (dd-mm-YYYY):");
        testing_date = sc.nextLine();
        CheckException.checkDate(testing_date);
        
        System.out.println("Seating:");
        number_of_seats = Integer.parseInt(sc.nextLine());
        CheckException.checkNumberZero(number_of_seats);
        
        System.out.println("Color:");
        color = sc.nextLine();
        CheckException.checkCharacter(color);
        
        System.out.println("License plates:");
        license_plates = sc.nextLine();
        CheckException.checkCharacterNumber(license_plates);
        
        System.out.println("Priced for 1 hour:");
        price = Double.parseDouble(sc.nextLine());
        CheckException.checkNumberZero(price);
        
        System.out.println("Vehicle condition:");
        System.out.println("1. Empty");
        System.out.println("2. On loan");
        System.out.println("3. Is corrected");
        status = Integer.parseInt(sc.nextLine());
        CheckException.checkStatus(status);
    }
}
