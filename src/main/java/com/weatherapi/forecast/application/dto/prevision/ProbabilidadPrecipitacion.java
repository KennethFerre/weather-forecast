package com.weatherapi.forecast.application.dto.prevision;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProbabilidadPrecipitacion {
    private String probabilidad;
    private String periodo;
}