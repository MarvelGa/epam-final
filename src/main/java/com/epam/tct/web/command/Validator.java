package com.epam.tct.web.command;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {




    public static boolean isValidEmail(final String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidNumber(final String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[0-9.]+$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public static boolean isValidPassword(final String pass, final String verification) {
        if (pass == null || verification == null || pass.isEmpty() || verification.isEmpty()) {
            return false;
        }
        if (pass.length() < 4 || verification.length() < 4) {
            return false;
        }
        return pass.equals(verification);
    }

    public static boolean isValidString(final String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z\u0430-\u044F\u0410-\u042F\u0451\u04010-9. _]{2,}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean isValidDate(final String date) {
        if (date == null || date.isEmpty()) {
            return false;
        }
        return date.matches("[\\d]{4}-[\\d]{2}-[\\d]{2}T[\\d]{2}:[\\d]{2}");
    }

    public static boolean isValidLength(final String string, final int length) {
        if (string == null || string.isEmpty() || length <= 0) {
            return false;
        }
        return string.length() > length;
    }

//    public static boolean isValidDateAfterToday(Date date) {
//        return new Date().compareTo(date) < 0;
//    }
//
//    public static boolean isValidDateAfterToday(LocalDateTime date) {
//        return LocalDateTime.now().compareTo(date) < 0;
//    }

    private Validator() {

    }



}
