package com.weatherapi.forecast.infrastructure.adapters.rest.in;

import com.weatherapi.forecast.application.dto.responses.AemetErrorResponse;
import com.weatherapi.forecast.shared.exception.AemetException;
import com.weatherapi.forecast.shared.exception.MunicipioNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import org.slf4j.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AemetException.class)
    public ResponseEntity<AemetErrorResponse> handleAemetException(AemetException ex) {
        String mensaje = String.format("Error de comunicación con el servicio: '%s', Mensaje: %s", ex.getEndpoint());
        AemetErrorResponse responseError = new AemetErrorResponse(mensaje, ex.getHttpStatus().value());
        LOGGER.info("A ocurrido una excepcion: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(responseError, ex.getHttpStatus());
    }

    @ExceptionHandler(MunicipioNotFoundException.class)
    public ResponseEntity<AemetErrorResponse> handleMunicipioNotFoundException(MunicipioNotFoundException ex) {
        AemetErrorResponse responseError = new AemetErrorResponse(ex.getMessage(), ex.getHttpStatus().value());
        LOGGER.info("A ocurrido una excepcion: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(responseError, HttpStatus.OK);
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<AemetErrorResponse> handleRestClientException(RestClientException ex) {
    LOGGER.info("A ocurrido una excepcion: {}", ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<AemetErrorResponse> handleNullPointerException(NullPointerException ex) {
        LOGGER.info("A ocurrido una excepcion: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}