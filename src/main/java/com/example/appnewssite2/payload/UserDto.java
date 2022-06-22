package com.example.appnewssite2.payload;

import com.example.appnewssite2.entity.Lavozim;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    @NotNull(message = "fullName bo'sh bolmasin")
    private String fullName;

    @NotNull(message = "username bo'sh bolmasin")
    private String username;


    @NotNull(message = "parol bo'sh bolmasin")
    private String password;


    @NotNull(message = "lavozim bo'sh bolishi mumkin emas")
    private Integer lavozimId;



}
