package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// Method Not Allowed (405): This exception occurs when an HTTP method is used on a resource that does not support that method. For example, trying to use a POST request on an endpoint that only accepts GET requests.
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowedException extends RuntimeException {
    public MethodNotAllowedException(String message) {
        super(message);
    }
}
