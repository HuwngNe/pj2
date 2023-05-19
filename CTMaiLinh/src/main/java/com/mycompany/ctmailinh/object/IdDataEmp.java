/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.object;

/**
 *
 * @author Windows
 */
public class IdDataEmp {
    private static int vehiceEmp_id = -1;
    private static int driverEmp_id = -1;
    private static int customerEmp_id = -1;

    public IdDataEmp() {
    }

    public static int getVehiceEmp_id() {
        return vehiceEmp_id;
    }

    public static void setVehiceEmp_id(int vehiceEmp_id) {
        IdDataEmp.vehiceEmp_id = vehiceEmp_id;
    }

    public static int getDriverEmp_id() {
        return driverEmp_id;
    }

    public static void setDriverEmp_id(int driverEmp_id) {
        IdDataEmp.driverEmp_id = driverEmp_id;
    }

    public static int getCustomerEmp_id() {
        return customerEmp_id;
    }

    public static void setCustomerEmp_id(int customerEmp_id) {
        IdDataEmp.customerEmp_id = customerEmp_id;
    }
    
    
}
