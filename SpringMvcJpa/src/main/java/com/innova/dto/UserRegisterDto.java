package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class UserRegisterDto {
    @NotEmpty(message = "Kullanici adi bos olamaz")
    private String username;

    @NotEmpty(message = "Sifre bos olamaz")
    @Size(min = 6,max = 20)
    private String password;

    @NotEmpty(message = "Email bos olamaz")
    @Email(message = "Email formatina uygun bir e-posta adresi giriniz")
    private String email;
}
