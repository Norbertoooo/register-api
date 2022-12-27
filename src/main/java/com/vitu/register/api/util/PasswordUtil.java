package com.vitu.register.api.util;

import java.time.LocalDate;

public abstract class PasswordUtil {

    public static String createDefaultPassword(String name, String lastName, LocalDate birthdate) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(lastName)
                .append(name)
                .append(birthdate.getYear());

        if (stringBuilder.toString().length() < 12) {
            while (stringBuilder.toString().length() < 12) {
                stringBuilder.append(0);
            }
        }

        return stringBuilder.toString();
    }
}
