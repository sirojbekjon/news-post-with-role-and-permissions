package com.example.appnewssite2.payload;

import com.example.appnewssite2.entity.enums.Huquq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LavozimDto {

    @NotBlank
    private String name;


    private String description;

    @NotEmpty
    private List<Huquq> huquqList;
}
