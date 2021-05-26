package com.metropolitan.courseholic.exception;

import org.springframework.http.HttpStatus;

public class CourseholicAPIException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;

    public CourseholicAPIException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public CourseholicAPIException(String message, HttpStatus httpStatus, String message1) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message1;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
