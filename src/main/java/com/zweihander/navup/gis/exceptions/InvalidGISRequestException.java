package com.zweihander.navup.gis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid Request")
public class InvalidGISRequestException extends RuntimeException {

    public InvalidGISRequestException(){
        super("That is not a valid GIS request");
    }

}
