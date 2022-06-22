package com.example.appnewssite2.entity;

import com.example.appnewssite2.entity.enums.Huquq;
import com.example.appnewssite2.entity.template.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lavozim extends AbstractEntity {

    @Column(unique = true,nullable = false)
    private String name;//ADMIN,USER,BOSHQALAR

    @Enumerated(value = EnumType.STRING)
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Huquq> huquqList;

    @Column(columnDefinition = "text")
    private String description;

//    @MapKeyEnumerated(value = EnumType.STRING)
//    private LavozimTurlari lavozimTurlari;
//



}
