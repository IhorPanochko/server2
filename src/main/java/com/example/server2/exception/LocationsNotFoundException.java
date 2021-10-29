package com.example.server2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocationsNotFoundException extends AbstractException {

    public LocationsNotFoundException(String message, String details) {
        super(message, details);
    }

}
