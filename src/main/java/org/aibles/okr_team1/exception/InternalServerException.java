package org.aibles.okr_team1.exception;

import org.springframework.http.HttpStatus;


public class InternalServerException extends Exception {
    public InternalServerException(String message, HttpStatus httpStatus){
        super(message,httpStatus);
    }

}
