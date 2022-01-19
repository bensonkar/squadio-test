package com.example.squadio.exceptions;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException{
    private String message;
    private HttpStatus status;

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
        this.message = message;
    }

    public ApplicationException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
