/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

/**
 *
 * @author Windows
 */
public class HandleDate {
    
    public String dateString(String str){
        int index = str.indexOf("0");
        if (index == 0) {
            str = removeChatAt(str,index);
        }
        return str;
    }

    private String removeChatAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}
