package com.myposts.services.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidApiParameterException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidApiParameterException(String message) {
        super(message);
    }
}