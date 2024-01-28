package com.scm.common.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@RequiredArgsConstructor
public class ResponseHeader {

    private Instant timestamp;
    private HttpStatus status;
    private Exception error;

    public ResponseHeader(Instant timestamp, HttpStatus status, Exception error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }
//    private Exception exception;

}
