package com.example.appnewssite2.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
@Data
@EqualsAndHashCode(callSuper = true)
public class ForbiddenException extends RuntimeException{
    private String type;
    private String message;

    public ForbiddenException(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
