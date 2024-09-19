package com.weatherapi.forecast.application.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AemetErrorResponse {
    private String mensaje;
    private int httpStatus;
}