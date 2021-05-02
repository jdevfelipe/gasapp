package com.gasapp.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class NotAllowedException extends RuntimeException {
    public NotAllowedException(String s) {
        super(s);
    }
}
