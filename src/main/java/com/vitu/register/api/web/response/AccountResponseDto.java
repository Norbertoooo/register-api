package com.vitu.register.api.web.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto {

    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String token;
    private String password;
    private String document;
    private String documentType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMMM-yyyy HH:mm:ss", locale = "US")
    private LocalDateTime creationDate;
}
