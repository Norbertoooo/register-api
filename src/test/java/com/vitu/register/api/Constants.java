package com.vitu.register.api;

import com.vitu.register.api.domain.Account;
import com.vitu.register.api.web.request.CreateAccountRequestDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Constants {

    public static final String NAME = "guss";
    public static final String LAST_NAME = "riquena";
    public static final LocalDate BIRTHDATE = LocalDate.of(2000, 2, 8);
    public static final String DOCUMENT = "12332112312";
    public static final String DOCUMENT_TYPE = "CNH";

    public static Account createFakeAccount(String documentType) {
        return Account.builder()
                .name(NAME)
                .lastName(LAST_NAME)
                .birthdate(BIRTHDATE)
                .document(DOCUMENT)
                .documentType(documentType)
                .build();
    }

    public static CreateAccountRequestDto createFakeAccountRequest() {
        return CreateAccountRequestDto.builder()
                .name(NAME)
                .lastName(LAST_NAME)
                .birthdate(BIRTHDATE)
                .document(DOCUMENT)
                .documentType(DOCUMENT_TYPE)
                .build();
    }

    public static Account createFakeSavedAccount(String documentType, Double score) {
        return Account.builder()
                .id(1L)
                .name(NAME)
                .lastName(LAST_NAME)
                .birthdate(BIRTHDATE)
                .document(DOCUMENT)
                .documentType(documentType)
                .token("")
                .password("")
                .score(score)
                .createDate(LocalDateTime.now())
                .build();
    }
}
