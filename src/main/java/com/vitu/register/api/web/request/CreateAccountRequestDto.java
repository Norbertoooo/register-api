package com.vitu.register.api.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotNull
    private LocalDate birthdate;

    @NotBlank
    @Size(min = 9)
    private String document;

    @NotBlank
    private String documentType;

}
