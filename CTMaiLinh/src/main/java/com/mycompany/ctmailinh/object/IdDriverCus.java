/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.object;

/**
 *
 * @author Windows
 */
public class IdDriverCus {
    private static int driver_id = -1;

    public IdDriverCus() {
    }

    public static int getDriver_id() {
        return driver_id;
    }

    public static void setDriver_id(int driver_id) {
        IdDriverCus.driver_id = driver_id;
    }
    
}
