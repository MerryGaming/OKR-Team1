package org.aibles.okr_team1.exception;

import org.springframework.http.HttpStatus;


public class BadRequestException extends Exception {
    public BadRequestException(String message, HttpStatus httpStatus){
        super(message,httpStatus);
    }
}
