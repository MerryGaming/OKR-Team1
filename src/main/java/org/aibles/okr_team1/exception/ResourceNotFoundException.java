package org.aibles.okr_team1.exception;

import org.springframework.http.HttpStatus;


public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String message, HttpStatus httpStatus){
        super(message,httpStatus);
    }
}
