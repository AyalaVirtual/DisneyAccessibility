package org.example.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


// Unauthorized (401): This exception deals with authentication errors. Unauthorized (401) is used when a user is not authenticated to access a resource.
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
