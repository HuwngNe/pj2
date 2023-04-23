/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctmailinh.libraly;

import com.mycompany.ctmailinh.exception.ExceptionDate;
import com.mycompany.ctmailinh.exception.ExceptionCharacter;
import com.mycompany.ctmailinh.exception.ExceptionCharacterNumber;
import com.mycompany.ctmailinh.exception.ExceptionDateTime;
import com.mycompany.ctmailinh.exception.ExceptionGender;
import com.mycompany.ctmailinh.exception.ExceptionNumber;
import com.mycompany.ctmailinh.exception.ExceptionNumberZero;
import com.mycompany.ctmailinh.exception.ExceptionPhone;
import com.mycompany.ctmailinh.exception.ExceptionStatusVehice;
import com.mycompany.ctmailinh.exception.ExceptionTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class CheckException {
    public static void checkCharacter(String string){
        String regexCharacter = "[a-zA-Z ]+";
        Pattern patternCharacter = Pattern.compile(regexCharacter);
        Matcher matcherCharacter = patternCharacter.matcher(string);
        if (!matcherCharacter.find()) {
            try {
                throw new ExceptionCharacter();
            } catch (ExceptionCharacter ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void checkCharacterNumber(String stringNumber){
        String regex = "[a-zA-Z0-9 ]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringNumber);
        if (!matcher.find()) {
            try {
                throw new ExceptionCharacterNumber();
            } catch (ExceptionCharacterNumber ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void checkNumber(String number){
        String regexNumber = "[0-9]+";
        Pattern patternID = Pattern.compile(regexNumber);
        Matcher matcherID = patternID.matcher(number);
        if (!matcherID.find()) {
            try {
                throw new ExceptionNumber();
            } catch (ExceptionNumber ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void checkGender(String gender){
        String[] regexGender = {"male","female","orther"};
        int count = 0;
        for (String string : regexGender) {
            if (string.equalsIgnoreCase(gender)) {
                count = 1;
                break;
            }
        }
        if (count == 0) {
            try {
                throw new ExceptionGender();
            } catch (ExceptionGender ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void checkPhone(String phone){
        String regex = "^[0-9]{10,11}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        if (!matcher.find()) {
            try {
                throw new ExceptionPhone();
            } catch (ExceptionPhone ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void checkDate(String date){
        int count = 0;
        for (int i = 0; i < date.length(); i++) {
            char c = date.charAt(i);
            if (c == '-') {
                count++;
            }
        }
        if (count != 2) {
            try {
                throw new ExceptionDate();
            } catch (ExceptionDate ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        String[] checkNumber = date.split("-");
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        for (String string : checkNumber) {
            Matcher matcher = pattern.matcher(string);
            if (!matcher.find()) {
                try {
                    throw new ExceptionDate();
                } catch (ExceptionDate ex) {
                    Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (Integer.parseInt(string) <= 0) {
                try {
                    throw new ExceptionDate();
                } catch (ExceptionDate ex) {
                    Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if (checkNumber[0].length() != 2 || checkNumber[1].length() != 2 || checkNumber[2].length() != 4) {
            try {
                throw new ExceptionDate();
            } catch (ExceptionDate ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        switch (Integer.parseInt(checkNumber[1])) {
            case 2 -> {
                if (Integer.parseInt(checkNumber[2]) % 4 == 0) {
                    if (Integer.parseInt(checkNumber[0]) > 29) {
                        try {
                            throw new ExceptionDate();
                        } catch (ExceptionDate ex) {
                            Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    if (Integer.parseInt(checkNumber[0]) > 28) {
                        try {
                            throw new ExceptionDate();
                        } catch (ExceptionDate ex) {
                            Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            case 1, 3, 5, 7, 8, 10, 12 -> {
                if (Integer.parseInt(checkNumber[0]) > 31) {
                    try {
                        throw new ExceptionDate();
                    } catch (ExceptionDate ex) {
                        Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            case 4, 6, 9, 11 -> {
                if (Integer.parseInt(checkNumber[0]) > 30) {
                    try {
                        throw new ExceptionDate();
                    } catch (ExceptionDate ex) {
                        Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            default -> {
                try {
                    throw new ExceptionDate();
                } catch (ExceptionDate ex) {
                    Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void checkStatus(int a){
        switch (a) {
            case 1,2,3 -> {
            }
            default -> {
                try {
                    throw new ExceptionStatusVehice();
                } catch (ExceptionStatusVehice ex) {
                    Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void checkNumberZero(double a) {
        if (a <= 0) {
            try {
                throw new ExceptionNumberZero();
            } catch (ExceptionNumberZero ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void checkNumberZero(int a) {
        if (a <= 0) {
            try {
                throw new ExceptionNumberZero();
            } catch (ExceptionNumberZero ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void checkTime(String a){
        String[] check = a.split(":");
        if (check.length != 3) {
            try {
                throw new ExceptionTime();
            } catch (ExceptionTime ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (check[1].length() != 2 || check[2].length() != 2 || check[0].length() != 2) {
            try {
                throw new ExceptionTime();
            } catch (ExceptionTime ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (String string : check) {
            checkNumber(string);
        }
        if (Integer.parseInt(check[0]) > 24 || Integer.parseInt(check[0]) < 0) {
            try {
                throw new ExceptionTime();
            } catch (ExceptionTime ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (Integer.parseInt(check[1]) > 60 || Integer.parseInt(check[0]) < 0) {
            try {
                throw new ExceptionTime();
            } catch (ExceptionTime ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (Integer.parseInt(check[2]) > 60 || Integer.parseInt(check[0]) < 0) {
            try {
                throw new ExceptionTime();
            } catch (ExceptionTime ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void checkDateTime(String a) {
        String[] check = a.split(" ");
        if (check.length != 2) {
            try {
                throw new ExceptionDateTime();
            } catch (ExceptionDateTime ex) {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        checkDate(check[0]);
        checkTime(check[1]);
    } 
}
