package com.weatherapi.forecast.application.dto.prevision;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrediccionMunicipioDto {
    private String nombre;
    private PrediccionDto prediccion;
}