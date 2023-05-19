/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.object;

/**
 *
 * @author Windows
 */
public class IdLogin {
    private static int id = -1;
    private static int idCurrent = -1;

    public IdLogin() {
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        IdLogin.id = id;
    }

    public static int getIdCurrent() {
        return idCurrent;
    }

    public static void setIdCurrent(int idCurrent) {
        IdLogin.idCurrent = idCurrent;
    }

}
