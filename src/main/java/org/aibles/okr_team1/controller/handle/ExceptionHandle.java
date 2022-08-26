package org.aibles.okr_team1.controller.handle;


import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr_team1.exception.Exception;
import org.aibles.okr_team1.exception.response.ExceptionReponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandle {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionReponse> handle(Exception ex) {
    log.error("(Exception) error: {}", ex);
    ExceptionReponse exceptionResponse = new ExceptionReponse();
    exceptionResponse.setError("Error exception");
    exceptionResponse.setMessage(ex.getMessage());
    exceptionResponse.setTimestamp(Instant.now());
    return ResponseEntity.status(HttpStatus.valueOf(ex.getStatus())).body(exceptionResponse);
  }
}

