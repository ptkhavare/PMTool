package com.pranavkhavare.pmt.exceptions.handlers;

import com.pranavkhavare.pmt.exceptions.ProjectDoesNotExistException;
import com.pranavkhavare.pmt.exceptions.ProjectIdentifierException;
import com.pranavkhavare.pmt.exceptions.responses.SingleStringExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * https://www.youtube.com/watch?v=2o7LJLTIgdE&ab_channel=in28minutesCloud%2CDevOpsandMicroservices
 */
@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProjectIdentifierException.class)
    public final ResponseEntity<Object> handleProjectIdentifierException(ProjectIdentifierException ex, WebRequest webRequest) {
        SingleStringExceptionResponse singleStringExceptionResponse = new SingleStringExceptionResponse(ex.getMessage());
        return new ResponseEntity(singleStringExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProjectDoesNotExistException.class)
    public final ResponseEntity<Object> handleProjectDoesNotExistException(ProjectDoesNotExistException ex, WebRequest webRequest) {
        SingleStringExceptionResponse singleStringExceptionResponse = new SingleStringExceptionResponse(ex.getMessage());
        return new ResponseEntity(singleStringExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}