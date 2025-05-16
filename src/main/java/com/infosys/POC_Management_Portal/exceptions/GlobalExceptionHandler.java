package com.infosys.POC_Management_Portal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> generalExceptionHandler(Exception ex)
    {
        ErrorMessage error = new ErrorMessage();
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage("exception occured, please check ");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(POCNOTFoundException.class)
    public ResponseEntity<ErrorMessage> customerNotFoundExceptionHandler(POCNOTFoundException ex)
    {
        ErrorMessage error = new ErrorMessage();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
