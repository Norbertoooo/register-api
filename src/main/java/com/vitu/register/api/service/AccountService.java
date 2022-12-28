package com.vitu.register.api.service;

import com.vitu.register.api.domain.Account;
import com.vitu.register.api.repository.AccountRepository;
import com.vitu.register.api.util.PasswordUtil;
import com.vitu.register.api.util.TokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> getAll() {
        log.info("Getting accounts");
        return accountRepository.findAll();
    }

    public Account create(Account account) {
        log.info("Creating new account: {}", account);
        account.setToken(this.createToken(account));
        account.setPassword(this.createPassword(account));
        account.setScore(getScore(account));
        return accountRepository.save(account);
    }

    private Double getScore(Account account) {
        return switch (account.getDocumentType()) {
            case "CNH" -> 10.00;
            case "RG" -> 20.00;
            case "CPF" -> 30.00;
            default -> 0.0;
        };
    }

    private String createPassword(Account account) {
        return PasswordUtil.createDefaultPassword(account.getName(), account.getLastName(), account.getBirthdate());
    }

    private String createToken(Account account) {
        return TokenUtil.createToken(account.getName(), account.getDocument(), account.getDocumentType());
    }

}
