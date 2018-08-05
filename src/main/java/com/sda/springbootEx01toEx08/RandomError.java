package com.sda.springbootEx01toEx08;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RandomError extends Exception{

    public RandomError(String message){
        super(message);
    }

    // not working
}
