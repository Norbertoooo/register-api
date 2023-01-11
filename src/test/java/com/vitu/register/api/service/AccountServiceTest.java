package com.vitu.register.api.service;

import com.vitu.register.api.domain.Account;
import com.vitu.register.api.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.vitu.register.api.Constants.createFakeAccount;
import static com.vitu.register.api.Constants.createFakeSavedAccount;

@ExtendWith(SpringExtension.class)
class AccountServiceTest {

    @MockBean
    AccountRepository accountRepository;

    AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountService(accountRepository);
    }

    @Test
    void shouldReturnAccountWhenCreateAccountWithCpf() {

        // contexto
        Account account = createFakeAccount("CPF");

        Account savedAccount = createFakeSavedAccount("CPF", 30.00);

        Mockito.when(accountRepository.save(account)).thenReturn(savedAccount);

        // execução
        Account result = accountService.create(account);

        // verificação
        Assertions.assertEquals(account.getName(), result.getName());
        Assertions.assertEquals(account.getLastName(), result.getLastName());
        Assertions.assertEquals(account.getBirthdate(), result.getBirthdate());
        Assertions.assertEquals(account.getDocument(), result.getDocument());
        Assertions.assertEquals(30.00, result.getScore());

    }

    @Test
    void shouldReturnAccountWhenCreateAccountWithoutDocumentType() {

        // contexto
        Account account = createFakeAccount("passport");

        Account savedAccount = createFakeSavedAccount("passport", 0.0);

        Mockito.when(accountRepository.save(account)).thenReturn(savedAccount);

        // execução
        Account result = accountService.create(account);

        // verificação
        Assertions.assertEquals(account.getName(), result.getName());
        Assertions.assertEquals(account.getLastName(), result.getLastName());
        Assertions.assertEquals(account.getBirthdate(), result.getBirthdate());
        Assertions.assertEquals(account.getDocument(), result.getDocument());
        Assertions.assertEquals(0.0, result.getScore());

    }

    @Test
    void shouldReturnAccountWhenCreateAccountWithCnh() {

        // contexto
        Account account = createFakeAccount("CNH");

        Account savedAccount = createFakeSavedAccount("CNH", 10.00);

        Mockito.when(accountRepository.save(account)).thenReturn(savedAccount);

        // execução
        Account result = accountService.create(account);

        // verificação
        Assertions.assertEquals(account.getName(), result.getName());
        Assertions.assertEquals(account.getLastName(), result.getLastName());
        Assertions.assertEquals(account.getBirthdate(), result.getBirthdate());
        Assertions.assertEquals(account.getDocument(), result.getDocument());
        Assertions.assertEquals(10.00, result.getScore());

    }

    @Test
    void shouldReturnAccountWhenCreateAccountWithRg() {

        // contexto
        Account account = createFakeAccount("RG");

        Account savedAccount = createFakeSavedAccount("RG", 20.00);

        Mockito.when(accountRepository.save(account)).thenReturn(savedAccount);

        // execução
        Account result = accountService.create(account);

        // verificação
        Assertions.assertEquals(account.getName(), result.getName());
        Assertions.assertEquals(account.getLastName(), result.getLastName());
        Assertions.assertEquals(account.getBirthdate(), result.getBirthdate());
        Assertions.assertEquals(account.getDocument(), result.getDocument());
        Assertions.assertEquals(20.00, result.getScore());

    }

}