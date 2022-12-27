package com.vitu.register.api.web.mapper;

import com.vitu.register.api.domain.Account;
import com.vitu.register.api.web.request.CreateAccountRequestDto;
import com.vitu.register.api.web.response.AccountResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountResponseDto createResponse(Account account) {
        return AccountResponseDto.builder()
                .id(account.getId())
                .name(account.getName())
                .lastName(account.getLastName())
                .password(account.getPassword())
                .token(account.getToken())
                .birthdate(account.getBirthdate())
                .document(account.getDocument())
                .documentType(account.getDocumentType())
                .creationDate(account.getCreateDate())
                .build();
    }

    public Account createDomain(CreateAccountRequestDto accountRequestDto) {
        return Account.builder()
                .name(accountRequestDto.getName())
                .lastName(accountRequestDto.getLastName())
                .birthdate(accountRequestDto.getBirthdate())
                .document(accountRequestDto.getDocument())
                .documentType(accountRequestDto.getDocumentType())
                .build();
    }
}
