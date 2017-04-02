package com.zweihander.navup.gis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="GIS data not found")
public class GISObjectNotFoundException extends RuntimeException {
    public GISObjectNotFoundException(){
        super("Cannot find requested GISDataObject");
    }
}
