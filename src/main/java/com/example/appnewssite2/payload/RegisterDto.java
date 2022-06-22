package com.example.appnewssite2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RegisterDto {

    @NotNull(message = "fullName bo'sh bolmasin")
    private String fullName;

    @NotNull(message = "username bo'sh bolmasin")
    private String username;


    @NotNull(message = "parol bo'sh bolmasin")
    private String password;

    @NotNull(message = "parol takrori bo'sh bolmasin")
    private String prePassword;



}
