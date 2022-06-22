package com.example.appnewssite2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LoginDto {



    @NotNull(message = "username bo'sh bolmasin")
    private String username;


    @NotNull(message = "parol bo'sh bolmasin")
    private String password;



}
