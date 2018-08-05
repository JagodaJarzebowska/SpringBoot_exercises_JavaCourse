package com.sda.springbootEx01toEx08;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SumError extends Exception {

    public SumError(String message){
        super(message);
    }
}
