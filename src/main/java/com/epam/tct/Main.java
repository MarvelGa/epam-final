package com.epam.tct;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        ResourceBundle bundle = ResourceBundle.getBundle("resources");
        ResourceBundle bundle2 = ResourceBundle.getBundle("resources", new Locale("ru", "RU"));
        System.out.println(bundle.getLocale());
        System.out.println(bundle.getString("login2"));
        System.out.println(bundle2.getString("login1"));
//        Locales locales = new Locales();
    }
}
