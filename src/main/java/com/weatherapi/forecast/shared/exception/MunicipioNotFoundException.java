package com.weatherapi.forecast.shared.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MunicipioNotFoundException extends RuntimeException {

    private HttpStatus httpStatus;

    public MunicipioNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}