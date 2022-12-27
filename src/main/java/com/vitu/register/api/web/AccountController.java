package com.vitu.register.api.web;

import com.vitu.register.api.domain.Account;
import com.vitu.register.api.service.AccountService;
import com.vitu.register.api.web.mapper.AccountMapper;
import com.vitu.register.api.web.request.CreateAccountRequestDto;
import com.vitu.register.api.web.response.AccountResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<AccountResponseDto> createAccount(@RequestBody CreateAccountRequestDto requestDto) {
        log.info("Receiving request to create new account: {}", requestDto);

        Account domain = accountMapper.createDomain(requestDto);

        Account account = accountService.create(domain);

        AccountResponseDto response = accountMapper.createResponse(account);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
