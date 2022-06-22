package com.example.appnewssite2.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

    private final String resourceName;//lavozim

    private final String ResourceField;//name

    private final Object object;//USER,ADMIN,1,500



}
