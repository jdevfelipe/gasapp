package com.gasapp.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequestNotSuccessException extends RuntimeException{
    public RequestNotSuccessException(String s) {
        super(s);
    }
}
