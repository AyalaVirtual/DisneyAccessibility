package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// Conflict (409): This exception is used to indicate that the request cannot be processed due to a conflict with the current state of the resource. For instance, when attempting to create a resource that already exists.
@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
