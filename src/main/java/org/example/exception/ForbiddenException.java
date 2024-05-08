package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// Forbidden (403): This exception deals with authorization errors. Forbidden (403) indicates that the user is authenticated but lacks the necessary permissions.
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message) {
        super(message);
    }
}
