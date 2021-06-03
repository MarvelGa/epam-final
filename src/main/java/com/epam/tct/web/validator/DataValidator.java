package com.epam.tct.web.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DataValidator {
    private static final String EMAIL_REGEX = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";

    private static final String PASSWORD_REGEX = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*[\\W|_]).{8,20}";
    private static final String NAME_REGEX = "^[А-ЯA-Z][a-яa-z]{2,24}";
    private static final String SURNAME_REGEX = "^[А-ЯA-Z][a-яa-z]{2,24}(-[А-ЯA-Z][a-яa-z]{2,12})?";
    private static final String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";


    public static boolean isNameValid(String name) {
        return (name != null) && name.matches(NAME_REGEX);
    }

    public static boolean isSurnameValid(String surname) {
        return (surname != null) && surname.matches(SURNAME_REGEX);

    }
    public static boolean isEmailValid(String email) {
        return (email != null) && email.matches(EMAIL_REGEX);
    }

    public static boolean isPasswordValid(String password) {
        return (password != null) && password.matches(PASSWORD_REGEX);
    }

    public static boolean isPasswordRepeatValid(String password, String passwordRepeat) {
        boolean resp = false;
        if (passwordRepeat != null && password != null) {
            resp = password.equals(passwordRepeat);
        }
        return resp;
    }

    public static boolean isDateValid(String date) {
        return date.matches(DATE_REGEX);
    }

    public static boolean isTimePeriodValid(LocalDate startDate, LocalDate endDate) {
        int result = startDate.compareTo(endDate);
        return result <= 0;
    }

//    public static boolean isValidDateAfterToday(Date date) {
//        return new Date().compareTo(date) < 0;
//    }
//
//    public static boolean isValidDateAfterToday(LocalDateTime date) {
//        return LocalDateTime.now().compareTo(date) < 0;
//    }

    private DataValidator() {

    }


}
