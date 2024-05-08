package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// Internal Server Error (500): This is a generic server error indicating that something unexpected went wrong on the server side. It's important to handle this gracefully and provide a generic error message to the client without exposing sensitive information.
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}
