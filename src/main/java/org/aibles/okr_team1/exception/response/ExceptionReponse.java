package org.aibles.okr_team1.exception.response;

import java.time.Instant;
import lombok.Data;

@Data
public class ExceptionReponse {
    private String error;
    private String message;
    private Instant timeStamp;



}
