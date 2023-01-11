package com.vitu.register.api.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vitu.register.api.domain.Account;
import com.vitu.register.api.service.AccountService;
import com.vitu.register.api.web.mapper.AccountMapper;
import com.vitu.register.api.web.request.CreateAccountRequestDto;
import com.vitu.register.api.web.response.AccountResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static com.vitu.register.api.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(controllers = AccountController.class)
@Import(AccountMapper.class)
class AccountControllerTest {

    public static final String ACCOUNT_URL = "/api/v1/account";
    @Autowired
    MockMvc mockMvc;

    @Autowired
    AccountMapper accountMapper;

    @MockBean
    AccountService accountService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createAccount() throws Exception {

        // contexto

        CreateAccountRequestDto fakeAccountRequest = createFakeAccountRequest();
        Account fakeSavedAccount = createFakeSavedAccount(DOCUMENT_TYPE, 10.00);
        Account fakeAccount = createFakeAccount(DOCUMENT_TYPE);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(ACCOUNT_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper()
                        .registerModule(new JavaTimeModule())
                        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                        .writeValueAsString(fakeAccountRequest));

        Mockito.when(accountService.create(fakeAccount))
                .thenReturn(fakeSavedAccount);

        // execução
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


        // verificação
    }

}