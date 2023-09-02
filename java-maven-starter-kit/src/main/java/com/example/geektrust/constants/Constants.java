package com.example.geektrust.constants;

import java.util.regex.Pattern;

public class Constants {
     public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final String REJECTED = "REJECTED";
    public static final String ACCEPTED = "ACCEPTED";
    public static final String CANCEL_REJECTED = "CANCEL_REJECTED";
    public static final String CANCEL_ACCEPTED = "CANCEL_ACCEPTED";
    public static final Integer ZERO=0;
    public static final Integer ONE=1;
    public static final Integer TWO=2;
    public static final Integer THREE=3;
    public static final Integer FOUR=4;
    public static final Integer FIVE=5;

    public static String getValue(String input) {
        String value = "";
        switch (input) {
            case "ADD-COURSE-OFFERING":
                value = "ADD_COURSE_OFFERING";
                break;

            case "ALLOT-COURSE":
                value = "ALLOT_COURSE";
                break;

            default:
                value = input;
                break;
        }
        return value;
    }
}
