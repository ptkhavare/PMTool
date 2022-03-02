package com.pranavkhavare.pmt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectDoesNotExistException extends RuntimeException {
    public ProjectDoesNotExistException(String message) {
        super(message);
    }
}