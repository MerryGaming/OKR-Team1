package org.aibles.okr_team1.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Exception extends RuntimeException{
  private String message;
  private HttpStatus httpStatus;

  public Exception(String message, HttpStatus httpStatus) {
    this.httpStatus=httpStatus;
    this.message=message;
  }

}
