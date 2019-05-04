package com.example.shynmcd.converter;

import androidx.databinding.InverseMethod;

public class IntergerConverter {
    public static int convertStringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @InverseMethod("convertStringToInt")
    public static String convertIntToString(int value) {
        return String.valueOf(value);
    }
}
