package com.weatherapi.forecast.shared.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class AemetException extends RuntimeException {

    private String endpoint;
    private HttpStatus httpStatus;

    public AemetException(String message, String endpoint, HttpStatus httpStatus) {
        super(message);
        this.endpoint = endpoint;
        this.httpStatus = httpStatus;
    }

    public AemetException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}