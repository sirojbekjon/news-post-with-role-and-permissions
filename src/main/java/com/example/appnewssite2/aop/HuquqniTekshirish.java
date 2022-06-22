package com.example.appnewssite2.aop;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HuquqniTekshirish {
    String huquq();

}
