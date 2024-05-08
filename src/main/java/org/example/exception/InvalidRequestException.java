package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// Invalid Request (400): This exception indicates that the client has made a request that the server cannot process due to invalid parameters or data. For instance, when a request payload is missing required fields or contains invalid data formats.
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
