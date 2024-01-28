package com.scm.http.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomException extends Exception {

    private HttpStatus status;

    public CustomException(String errorMessage) {
        super(errorMessage);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public CustomException(Exception exception) {
        super(exception);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public CustomException(String exception, HttpStatus status) {
        super(exception);
        this.status = status;
    }

}

