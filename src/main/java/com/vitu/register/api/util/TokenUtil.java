package com.vitu.register.api.util;

import java.util.Base64;

public abstract class TokenUtil {

    public static String createToken(String name, String document, String documentType) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name)
                .append("-")
                .append(document)
                .append("-")
                .append(documentType);

        return Base64.getEncoder().encodeToString(stringBuilder.toString().getBytes());
    }
}
